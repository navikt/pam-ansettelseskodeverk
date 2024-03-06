package no.nav.arbeid.pam.kodeverk.ansettelse;

import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.BOKMAL;
import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.NYNORSK;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial"})
public enum Ansettelsesform implements Kode {

    ENGASJEMENT(new HashMap<String, String>() {
        {
            put(BOKMAL, "Engasjement");
            put(NYNORSK, "Engasjement");
        }
    }),

    FAST(new HashMap<String, String>() {
        {
            put(BOKMAL, "Fast");
            put(NYNORSK, "Fast");
        }
    }),

    FERIEJOBB(new HashMap<String, String>() {
        {
            put(BOKMAL, "Feriejobb");
            put(NYNORSK, "Feriejobb");
        }
    }),

    PROSJEKT(new HashMap<String, String>() {
        {
            put(BOKMAL, "Prosjekt");
            put(NYNORSK, "Prosjekt");
        }
    }),

    SELVSTENDIG_NAERINGSDRIVENDE(new HashMap<String, String>() {
        {
            put(BOKMAL, "Selvstendig næringsdrivende");
            put(NYNORSK, "Selvstendig næringsdrivende");
        }
    }),

    SESONG(new HashMap<String, String>() {
        {
            put(BOKMAL, "Sesong");
            put(NYNORSK, "Sesong");
        }
    }),

    VIKARIAT(new HashMap<String, String>() {
        {
            put(BOKMAL, "Vikariat");
            put(NYNORSK, "Vikariat");
        }
    }),

    TRAINEE(new HashMap<String, String>() {
        {
            put(BOKMAL, "Trainee");
            put(NYNORSK, "Trainee");
        }
    }),

    LAERLING(new HashMap<String, String>() {
        {
            put(BOKMAL, "Lærling");
            put(NYNORSK, "Lærling");
        }
    }),

    AREMAL(new HashMap<String, String>() {
        {
            put(BOKMAL, "Åremål");
            put(NYNORSK, "Åremål");
        }
    }),

    FRILANSER(new HashMap<String, String>() {
        {
            put(BOKMAL, "Frilanser");
            put(NYNORSK, "Frilanser");
        }
    }),

    ANNET(new HashMap<String, String>() {
        {
            put(BOKMAL, "Annet");
            put(NYNORSK, "Annet");
        }
    });

    private final Map<String, String> sprakTekster;

    private Ansettelsesform(Map<String, String> sprakTekster) {
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    @Override
    public Map<String, String> tekster() {
        return sprakTekster;
    }

}
