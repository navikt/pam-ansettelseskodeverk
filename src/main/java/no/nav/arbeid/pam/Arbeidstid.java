package no.nav.arbeid.pam;

import java.util.HashMap;
import java.util.Map;

import com.neovisionaries.i18n.LanguageCode;

public enum Arbeidstid implements Kode {

    @SuppressWarnings("serial")
    LOERDAG("LØRDAG", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Lørdag");
            put(LanguageCode.nn, "Lørdag");
        }
    }), @SuppressWarnings("serial")
    SOENDAG("SØNDAG", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Søndag");
            put(LanguageCode.nn, "Søndag");
        }
    }), @SuppressWarnings("serial")
    UKEDAGER("UKEDAGER", new HashMap<LanguageCode, String>() {
        {
            put(LanguageCode.nb, "Ukedager");
            put(LanguageCode.nn, "Ukedager");
        }
    });

    protected String defaultTekst;
    protected Map<String, String> sprakTekster = new HashMap<>();

    private Arbeidstid(String defaultTekst, Map<LanguageCode, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        sprakTekster.forEach((lc, tekst) -> this.sprakTekster.put(lc.name().toLowerCase(), tekst));
    }

    private Arbeidstid(String defaultTekst) {
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
