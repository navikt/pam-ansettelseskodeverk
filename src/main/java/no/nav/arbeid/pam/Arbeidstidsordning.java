package no.nav.arbeid.pam;

import java.util.HashMap;
import java.util.Map;

import com.neovisionaries.i18n.LanguageCode;

public enum Arbeidstidsordning implements Kode {

    @SuppressWarnings("serial")
    SKIFT("SKIFT", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Skift");
            put(LanguageCode.nn, "Skift");
        }
    }), @SuppressWarnings("serial")
    TURNUS("TURNUS", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Turnus");
            put(LanguageCode.nn, "Turnus");
        }
    }), @SuppressWarnings("serial")
    VAKT("VAKT", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Vakt");
            put(LanguageCode.nn, "Vakt");
        }
    });

    protected String defaultTekst;
    protected Map<String, String> sprakTekster = new HashMap<>();

    private Arbeidstidsordning(String defaultTekst, Map<LanguageCode, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        sprakTekster.forEach((lc, tekst) -> this.sprakTekster.put(lc.name().toLowerCase(), tekst));
    }

    private Arbeidstidsordning(String defaultTekst) {
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
