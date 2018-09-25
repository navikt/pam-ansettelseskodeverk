package no.nav.arbeid.pam;

import java.util.HashMap;
import java.util.Map;

import com.neovisionaries.i18n.LanguageCode;

public enum Omfang implements Kode {

    @SuppressWarnings("serial")
    HELTID("HELTID", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Heltid");
            put(LanguageCode.nn, "Heltid");
        }
    }), @SuppressWarnings("serial")
    DELTID("DELTID", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Deltid");
            put(LanguageCode.nn, "Deltid");
        }
    });

    protected String defaultTekst;
    protected Map<String, String> sprakTekster = new HashMap<>();

    private Omfang(String defaultTekst, Map<LanguageCode, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        sprakTekster.forEach((lc, tekst) -> this.sprakTekster.put(lc.name().toLowerCase(), tekst));
    }

    private Omfang(String defaultTekst) {
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
