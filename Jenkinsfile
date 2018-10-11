@Library('deploy')
import deploy

def deployLib = new deploy()

node {
    def application = "pam-ansettelseskodeverk"
    def committer, committerEmail, changelog, pom, releaseVersion, isSnapshot, isMaster, majorMinorVersion, patchVersion, nextVersion // metadata

    def mvnHome = tool "maven-3.3.9"
    def mvn = "${mvnHome}/bin/mvn"
    def color

    try {
        stage("checkout") {
            checkout scm
        }

        stage("initialize") {
        	
            println ("Initialize $BRANCH_NAME")
            if (BRANCH_NAME.contains("master")) {                
                isMaster = true
            } else {                
                isMaster = false                
            }
            pom = readMavenPom file: 'pom.xml'
            currentBuild.description = "#${BUILD_NUMBER}, branch ${BRANCH}, version ${pom.version}"
            releaseVersion = pom.version.tokenize("-")[0]
            isSnapshot = pom.version.contains("-SNAPSHOT")
            committer = sh(script: 'git log -1 --pretty=format:"%an (%ae)"', returnStdout: true).trim()
            committerEmail = sh(script: 'git log -1 --pretty=format:"%ae"', returnStdout: true).trim()
            changelog = sh(script: 'git log `git describe --tags --abbrev=0`..HEAD --oneline', returnStdout: true)
        }

        stage("verify maven versions") {
            sh 'echo "Verifying that no snapshot dependencies is being used."'
            sh 'grep module pom.xml | cut -d">" -f2 | cut -d"<" -f1 > snapshots.txt'
            sh 'echo "./" >> snapshots.txt'
            sh 'while read line;do if [ "$line" != "" ];then if [ `grep SNAPSHOT $line/pom.xml | wc -l` -gt 1 ];then echo "SNAPSHOT-dependencies found. See file $line/pom.xml.";exit 1;fi;fi;done < snapshots.txt'
        }


        stage("build and test") {
            sh "${mvn} clean install -Djava.io.tmpdir=/tmp/${application} -B -e"
        }

        stage("release version") {
            if (isMaster) {
                withEnv(['HTTPS_PROXY=http://webproxy-utvikler.nav.no:8088']) {
                    withCredentials([string(credentialsId: 'navikt-ci-oauthtoken', variable: 'token')]) {
                        sh "${mvn} versions:set -B -DnewVersion=${releaseVersion} -DgenerateBackupPoms=false"
                        sh "git commit -am \"set version to ${releaseVersion} (from Jenkins pipeline)\""
                        sh ("git push -u https://${token}:x-oauth-basic@github.com/navikt/${application}.git HEAD:$BRANCH_NAME")
                        sh ("git tag -a ${releaseVersion} -m ${application}-${releaseVersion}")
                        sh ("git push -u https://${token}:x-oauth-basic@github.com/navikt/${application}.git --tags HEAD:$BRANCH_NAME")
                    }
                }
            }
        }

        stage("publish artifact") {
           withCredentials([usernamePassword(credentialsId: 'nexusUploader', usernameVariable: 'DEP_USERNAME', passwordVariable: 'DEP_PASSWORD')]) {
               sh "${mvn} clean deploy -Dusername=${env.DEP_USERNAME} -Dpassword=${env.DEP_PASSWORD} -DskipTests -B -e"
           }
        }

        stage("new dev version") {
            if (isMaster) {
                withEnv(['HTTPS_PROXY=http://webproxy-utvikler.nav.no:8088']) {
                    withCredentials([string(credentialsId: 'navikt-ci-oauthtoken', variable: 'token')]) {
                        majorMinorVersion = sh(script: "echo ${releaseVersion} | perl -pe 's/\\.\\d+\\s*\$//g'", returnStdout: true).trim()
                        patchVersion = releaseVersion.tokenize(".").last().toInteger() + 1
                        nextVersion = "${majorMinorVersion}.${patchVersion}-SNAPSHOT"
                        sh "${mvn} versions:set -B -DnewVersion=${nextVersion} -DgenerateBackupPoms=false"
                        sh "git commit -am \"updated to new dev-version ${nextVersion} after release by ${committer} (from Jenkins pipeline)\""
                        sh "git push -u https://${token}:x-oauth-basic@github.com/navikt/${application}.git HEAD:$BRANCH_NAME"
                    }
                }
            }
        }

        color = '#BDFFC3'
        GString message = ":heart_eyes_cat: Siste commit på ${application} bygd og deploya OK.\nSiste commit ${changelog}"
        slackSend color: color, channel: '#pam_bygg', message: message, teamDomain: 'nav-it', tokenCredentialId: 'pam-slack'


    } catch (e) {
        color = '#FF0004'
        println "Exception: ${e.message}"
        GString message = ":crying_cat_face: :crying_cat_face: :crying_cat_face: :crying_cat_face: :crying_cat_face: :crying_cat_face: Halp sad cat! \n Siste commit på ${application} gikk ikkje gjennom. Sjå logg for meir info ${env.BUILD_URL}\nLast commit ${changelog}"
        slackSend color: color, channel: '#pam_bygg', message: message, teamDomain: 'nav-it', tokenCredentialId: 'pam-slack'
        currentBuild.result = 'FAILURE'
    }

}
