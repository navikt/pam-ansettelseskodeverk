package no.nav.arbeid.pam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial", "unused"})
public enum Ansettelsesform implements Kode {

    ENGASJEMENT("ENGASJEMENT", new HashMap<String, String>() {
        {
            put("nb", "Engasjement");
            put("nn", "Engasjement");
        }
    }),

    FAST("FAST", new HashMap<String, String>() {
        {
            put("nb", "Fast");
            put("nn", "Fast");
        }
    }),

    FERIEJOBB("FERIEJOBB", new HashMap<String, String>() {
        {
            put("nb", "Feriejobb");
            put("nn", "Feriejobb");
        }
    }),

    PROSJEKT("PROSJEKT", new HashMap<String, String>() {
        {
            put("nb", "Prosjekt");
            put("nn", "Prosjekt");
        }
    }),

    SELVSTENDIG_NAERINGSDRIVENDE("SELVSTENDIG NÆRINGSDRIVENDE", new HashMap<String, String>() {
        {
            put("nb", "Selvstendig næringsdrivende");
            put("nn", "Selvstendig næringsdrivende");
        }
    }),

    SESONG("SESONG", new HashMap<String, String>() {
        {
            put("nb", "Sesong");
            put("nn", "Sesong");
        }
    }),

    VIKARIAT("VIKARIAT", new HashMap<String, String>() {
        {
            put("nb", "Vikariat");
            put("nn", "Vikariat");
        }
    }),

    TRAINEE("TRAINEE", new HashMap<String, String>() {
        {
            put("nb", "Trainee");
            put("nn", "Trainee");
        }
    }),

    LAERLING("LÆRLING", new HashMap<String, String>() {
        {
            put("nb", "Lærling");
            put("nn", "Lærling");
        }
    }),

    ANNET("ANNET", new HashMap<String, String>() {
        {
            put("nb", "Annet");
            put("nn", "Annet");
        }
    });

    private final String defaultTekst;
    private final Map<String, String> sprakTekster;

    Ansettelsesform(String defaultTekst, Map<String, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    Ansettelsesform(String defaultTekst) {
        this(defaultTekst, Collections.emptyMap());
    }

    @Override
    public String defaultTekst() {
        return defaultTekst;
    }

    @Override
    public Map<String, String> tekster() {
        return sprakTekster;
    }

}
