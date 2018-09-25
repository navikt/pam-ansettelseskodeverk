package no.nav.arbeid.pam;

import java.util.HashMap;
import java.util.Map;

import com.neovisionaries.i18n.LanguageCode;

public enum Ansettelsesform implements Kode {

    @SuppressWarnings("serial")
    ENGASJEMENT("ENGASJEMENT", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Engasjement");
            put(LanguageCode.nn, "Engasjement");
        }
    }), @SuppressWarnings("serial")
    FAST("FAST", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Fast");
            put(LanguageCode.nn, "Fast");
        }
    }), @SuppressWarnings("serial")
    FERIEJOBB("FERIEJOBB", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Feriejobb");
            put(LanguageCode.nn, "Feriejobb");
        }
    }), @SuppressWarnings("serial")
    PROSJEKT("PROSJEKT", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Prosjekt");
            put(LanguageCode.nn, "Prosjekt");
        }
    }), @SuppressWarnings("serial")
    SELVSTENDIG_NAERINGSDRIVENDE("SELVSTENDIG NÆRINGSDRIVENDE", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Selvstendig næringsdrivende");
            put(LanguageCode.nn, "Selvstendig næringsdrivende");
        }
    }), @SuppressWarnings("serial")
    SESONG("SESONG", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Sesong");
            put(LanguageCode.nn, "Sesong");
        }
    }), @SuppressWarnings("serial")
    VIKARIAT("VIKARIAT", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Vikariat");
            put(LanguageCode.nn, "Vikariat");
        }
    }), @SuppressWarnings("serial")
    TRAINEE("TRAINEE", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Trainee");
            put(LanguageCode.nn, "Trainee");
        }
    }), @SuppressWarnings("serial")
    LAERLING("LÆRLING", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Lærling");
            put(LanguageCode.nn, "Lærling");
        }
    }),@SuppressWarnings("serial")
    ANNET("ANNET", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Annet");
            put(LanguageCode.nn, "Annet");
        }
    });

    protected String defaultTekst;
    protected Map<String, String> sprakTekster = new HashMap<>();

    private Ansettelsesform(String defaultTekst, Map<LanguageCode, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        sprakTekster.forEach((lc, tekst) -> this.sprakTekster.put(lc.name().toLowerCase(), tekst));
    }

    private Ansettelsesform(String defaultTekst) {
        this.defaultTekst = defaultTekst;
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
