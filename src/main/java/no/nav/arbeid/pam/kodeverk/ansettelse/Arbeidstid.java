package no.nav.arbeid.pam.kodeverk.ansettelse;

import java.util.Collections;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

import com.sun.jndi.ldap.EntryChangeResponseControl;

@SuppressWarnings({"serial", "unused"})
public enum Arbeidstid implements Kode {


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
            put("no", "Natt");
            put("nn", "Natt");
        }
    });

    private final String defaultTekst;
    private final Map<String, String> sprakTekster;

    Arbeidstid(String defaultTekst, Map<String, String> sprakTekster) {
        this.defaultTekst = defaultTekst;
        //Collections.unmodifiableMap(sprakTekster.entrySet().stream().collect(Collectors.toMap(entry->((Locale)entry.getKey()).getLanguage(), entry->entry.getValue())));
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
