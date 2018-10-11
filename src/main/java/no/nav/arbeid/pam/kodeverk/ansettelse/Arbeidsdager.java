package no.nav.arbeid.pam.kodeverk.ansettelse;

import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.BOKMAL;
import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.NYNORSK;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings({"serial"})
public enum Arbeidsdager implements Kode {

    LOERDAG(new HashMap<String, String>() {
        {
            put(BOKMAL, "Lørdag");
            put(NYNORSK, "Lørdag");
        }
    }),

    SOENDAG(new HashMap<String, String>() {
        {
            put(BOKMAL, "Søndag");
            put(NYNORSK, "Søndag");
        }
    }),

    UKEDAGER(new HashMap<String, String>() {
        {
            put(BOKMAL, "Ukedager");
            put(NYNORSK, "Ukedager");
        }
    });

    private final Map<String, String> sprakTekster;

    private Arbeidsdager(Map<String, String> sprakTekster) {
        this.sprakTekster = Collections.unmodifiableMap(sprakTekster);
    }

    @Override
    public Map<String, String> tekster() {
        return sprakTekster;
    }

}
