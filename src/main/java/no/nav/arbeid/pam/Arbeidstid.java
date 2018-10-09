package no.nav.arbeid.pam;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial", "unused"})
public enum Arbeidstid implements Kode {

    LOERDAG("LØRDAG", new HashMap<String, String>() {
        {
            put("nb", "Lørdag");
            put("nn", "Lørdag");
        }
    }),

    SOENDAG("SØNDAG", new HashMap<String, String>() {
        {
            put("nb", "Søndag");
            put("nn", "Søndag");
        }
    }),

    UKEDAGER("UKEDAGER", new HashMap<String, String>() {
        {
            put("nb", "Ukedager");
            put("nn", "Ukedager");
        }
    });

    private final String defaultTekst;
    private final Map<String, String> sprakTekster;

    Arbeidstid(String defaultTekst, Map<String, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    Arbeidstid(String defaultTekst) {
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
