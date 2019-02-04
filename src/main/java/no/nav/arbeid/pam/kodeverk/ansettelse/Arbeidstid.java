package no.nav.arbeid.pam.kodeverk.ansettelse;

import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.BOKMAL;
import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.NYNORSK;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial"})
public enum Arbeidstid implements Kode {

    DAGTID(new HashMap<String, String>() {
        {
            put(BOKMAL, "Dagtid");
            put(NYNORSK, "Dagtid");
        }
    }),

    KVELD(new HashMap<String, String>() {
        {
            put(BOKMAL, "Kveld");
            put(NYNORSK, "Kveld");
        }
    }),

    NATT(new HashMap<String, String>() {
        {
            put(BOKMAL, "Natt");
            put(NYNORSK, "Natt");
        }
    });

    private final Map<String, String> sprakTekster;

    Arbeidstid(Map<String, String> sprakTekster) {
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    @Override
    public Map<String, String> tekster() {
        return sprakTekster;
    }

}
