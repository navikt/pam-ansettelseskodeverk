package no.nav.arbeid.pam.kodeverk.ansettelse;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import org.junit.Test;

public class OmfangTest {

    @Test
    public void skalGiDefaultTekst() {
        assertThat(Omfang.HELTID.defaultTekst(), is("Heltid"));
    }

    @Test
    public void skalGiKorrektTekstVedBrukAvEksisterendeLanguageCode() {
        assertThat(Omfang.HELTID.tekst(new Locale("nb")), is("Heltid"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvIkkeeksisterendeLanguageCode() {
        assertThat(Omfang.HELTID.tekst(new Locale("ee")), is("Heltid"));
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
        assertThat(Omfang.HELTID.tekst("EE"), is("Heltid"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvNullIsoString() {
        assertThat(Omfang.HELTID.tekst((String) null), is("Heltid"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvNullLanguageCode() {
        assertThat(Omfang.HELTID.tekst((Locale) null), is("Heltid"));
    }

}
