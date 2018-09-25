package no.nav.arbeid.pam;

import java.util.Map;
import java.util.Optional;

import com.neovisionaries.i18n.LanguageCode;

public interface Kode {

    String name();
    
    default String getId() {
        return name();
    }

    String defaultTekst();

    Map<String, String> tekster();

    default String tekst(LanguageCode sprak) {
        return Optional.ofNullable(sprak).map(lc -> tekst(sprak.name())).orElse(defaultTekst());
    }

    default String tekst(String iso2) {
        return Optional.ofNullable(iso2).map(iso -> tekster().get(iso.toLowerCase()))
                .orElse(defaultTekst());
    }

}
