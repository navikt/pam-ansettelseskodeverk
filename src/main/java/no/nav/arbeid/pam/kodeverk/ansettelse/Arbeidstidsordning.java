package no.nav.arbeid.pam.kodeverk.ansettelse;

import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.BOKMAL;
import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.NYNORSK;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial"})
public enum Arbeidstidsordning implements Kode {

    SKIFT(new HashMap<String, String>() {
        {
            put(BOKMAL, "Skift");
            put(NYNORSK, "Skift");
        }
    }), TURNUS(new HashMap<String, String>() {
        {
            put(BOKMAL, "Turnus");
            put(NYNORSK, "Turnus");
        }
    }), VAKT(new HashMap<String, String>() {
        {
            put(BOKMAL, "Vakt");
            put(NYNORSK, "Vakt");
        }
    });

    private final Map<String, String> sprakTekster;

    private Arbeidstidsordning(Map<String, String> sprakTekster) {
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    @Override
    public Map<String, String> tekster() {
        return sprakTekster;
    }

}
