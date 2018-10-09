package no.nav.arbeid.pam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial", "unused"})
public enum Omfang implements Kode {


    HELTID("HELTID", new HashMap<String, String>() {
        {
            put("nb", "Heltid");
            put("nn", "Heltid");
        }
    }),

    DELTID("DELTID", new HashMap<String, String>() {
        {
            put("nb", "Deltid");
            put("nn", "Deltid");
        }
    });

    private final String defaultTekst;
    private final Map<String, String> sprakTekster;

    Omfang(String defaultTekst, Map<String, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    Omfang(String defaultTekst) {
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
