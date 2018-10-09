package no.nav.arbeid.pam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial", "unused"})
public enum Arbeidsdager implements Kode {


    DAGTID("DAGTID", new HashMap<String, String>() {
        {
            put("nb", "Dagtid");
            put("nn", "Dagtid");
        }
    }),

    KVELD("KVELD", new HashMap<String, String>() {
        {
            put("nb", "Kveld");
            put("nn", "Kveld");
        }
    }),

    NATT("NATT", new HashMap<String, String>() {
        {
            put("nb", "Natt");
            put("nn", "Natt");
        }
    });

    private final String defaultTekst;
    private final Map<String, String> sprakTekster;

    Arbeidsdager(String defaultTekst, Map<String, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    Arbeidsdager(String defaultTekst) {
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
