package no.nav.arbeid.pam.kodeverk.ansettelse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial", "unused"})
public enum Arbeidstidsordning implements Kode {

    SKIFT("SKIFT", new HashMap<String, String>() {
        {
            put("nb", "Skift");
            put("nn", "Skift");
        }
    }), @SuppressWarnings("serial")
    TURNUS("TURNUS", new HashMap<String, String>() {
        {
            put("nb", "Turnus");
            put("nn", "Turnus");
        }
    }), @SuppressWarnings("serial")
    VAKT("VAKT", new HashMap<String, String>() {
        {
            put("nb", "Vakt");
            put("nn", "Vakt");
        }
    });

    private final String defaultTekst;
    private final Map<String, String> sprakTekster;

    Arbeidstidsordning(String defaultTekst, Map<String, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    Arbeidstidsordning(String defaultTekst) {
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
