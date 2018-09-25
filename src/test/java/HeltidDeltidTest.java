import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.neovisionaries.i18n.LanguageCode;

import no.nav.arbeid.pam.Omfang;

public class HeltidDeltidTest {

    @Test
    public void skalGiDefaultTekst() {
        assertThat(Omfang.HELTID.defaultTekst(), is("HELTID"));
    }

    @Test
    public void skalGiKorrektTekstVedBrukAvEksisterendeLanguageCode() {
        assertThat(Omfang.HELTID.tekst(LanguageCode.nb), is("Heltid"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvIkkeeksisterendeLanguageCode() {
        assertThat(Omfang.HELTID.tekst(LanguageCode.ee), is("HELTID"));
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
        String nullString = null;
        assertThat(Omfang.HELTID.tekst(nullString), is("HELTID"));
    }

    @Test
    public void skalGiDefaultTekstVedBrukAvNullLanguageCode() {
        LanguageCode nullLc = null;
        assertThat(Omfang.HELTID.tekst(nullLc), is("HELTID"));
    }

}
