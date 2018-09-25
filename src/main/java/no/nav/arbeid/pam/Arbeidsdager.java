package no.nav.arbeid.pam;

import java.util.HashMap;
import java.util.Map;

import com.neovisionaries.i18n.LanguageCode;

public enum Arbeidsdager implements Kode {

    @SuppressWarnings("serial")
    DAGTID("DAGTID", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Dagtid");
            put(LanguageCode.nn, "Dagtid");
        }
    }), @SuppressWarnings("serial")
    KVELD("KVELD", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Kveld");
            put(LanguageCode.nn, "Kveld");
        }
    }), @SuppressWarnings("serial")
    NATT("NATT", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Natt");
            put(LanguageCode.nn, "Natt");
        }
    });

    protected String defaultTekst;
    protected Map<String, String> sprakTekster = new HashMap<>();

    private Arbeidsdager(String defaultTekst, Map<LanguageCode, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        sprakTekster.forEach((lc, tekst) -> this.sprakTekster.put(lc.name().toLowerCase(), tekst));
    }

    private Arbeidsdager(String defaultTekst) {
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
