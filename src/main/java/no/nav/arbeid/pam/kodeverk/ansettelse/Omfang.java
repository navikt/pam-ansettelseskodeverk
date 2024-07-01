package no.nav.arbeid.pam.kodeverk.ansettelse;

import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.BOKMAL;
import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.NYNORSK;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("serial")
public enum Omfang implements Kode {

    HELTID(new HashMap<String, String>() {
        {
            put(BOKMAL, "Heltid");
            put(NYNORSK, "Heltid");
        }
    }),

    DELTID(new HashMap<String, String>() {
        {
            put(BOKMAL, "Deltid");
            put(NYNORSK, "Deltid");
        }
    }),

    HELTID_OG_DELTID(new HashMap<String, String>() {
        {
            put(BOKMAL, "Heltid_og_Deltid");
            put(NYNORSK, "Heltid_og_Deltid");
        }
    }),

    UKJENT(new HashMap<String, String>() {
        {
            put(BOKMAL, "Ukjent");
            put(NYNORSK, "Ukjent");
        }
    });

    private final Map<String, String> sprakTekster;

    Omfang(Map<String, String> sprakTekster) {
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    @Override
    public Map<String, String> tekster() {
        return sprakTekster;
    }

}
