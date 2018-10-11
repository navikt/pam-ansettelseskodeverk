package no.nav.arbeid.pam.kodeverk.ansettelse;

import static no.nav.arbeid.pam.kodeverk.ansettelse.Sprak.BOKMAL;

import java.util.Locale;
import java.util.Map;
import java.util.Optional;

public interface Kode {

    String name();

    default String getId() {
        return name();
    }

    default String defaultTekst() {
        return Optional.ofNullable(tekster().get(BOKMAL)).orElse(name());
    }

    Map<String, String> tekster();

    default String tekst(Locale sprak) {
        return Optional.ofNullable(sprak).map(lc -> tekst(sprak.getLanguage()))
                .orElse(defaultTekst());
    }

    default String tekst(String iso2) {
        return Optional.ofNullable(iso2).map(iso -> tekster().get(iso.toLowerCase()))
                .orElse(defaultTekst());
    }

}
