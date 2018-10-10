package no.nav.arbeid.pam.kodeverk.ansettelse;
import org.junit.Test;

import no.nav.arbeid.pam.kodeverk.ansettelse.Omfang;

import java.util.Locale;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class OmfangTest {

    @Test
    public void skalGiDefaultTekst() {
        assertThat(Omfang.HELTID.defaultTekst(), is("HELTID"));
    }

    @Test
    public void skalGiKorrektTekstVedBrukAvEksisterendeLanguageCode() {
        assertThat(Omfang.HELTID.tekst(new Locale("nb")), is("Heltid"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvIkkeeksisterendeLanguageCode() {
        assertThat(Omfang.HELTID.tekst(new Locale("ee")), is("HELTID"));
    }

    @Test
    public void skalGiKorrektTekstVedBrukAvEksisterendeIsoStringIFeilCase() {
        assertThat(Omfang.HELTID.tekst("NB"), is("Heltid"));
    }

    @Test
    public void skalGiKorrektTekstVedBrukAvEksisterendeIsoStringIKorrektCase() {
        assertThat(Omfang.HELTID.tekst("nb"), is("Heltid"));
    }

    @Test
    public void skalGiKorrektTekstVedBrukAvIkkeeksisterendeIsoString() {
        assertThat(Omfang.HELTID.tekst("EE"), is("HELTID"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvNullIsoString() {
        assertThat(Omfang.HELTID.tekst((String) null), is("HELTID"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvNullLanguageCode() {
        assertThat(Omfang.HELTID.tekst((Locale) null), is("HELTID"));
    }

}
