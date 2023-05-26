package certificazione;

import configuration.Configuration;
import domain.Permesso;
import java.io.IOException;
import libCrittografia.Aes;
import libCrittografia.EccezioneCripto;
import libCrittografia.Rsa;
import utility.PermessoControllo;

public class EnteCertificazione {

    private static EnteCertificazione instance = null;

    private EnteCertificazione() {
    }

    public synchronized static EnteCertificazione getInstance() {
        if (null == instance) {
            instance = new EnteCertificazione();
        }

        return instance;
    }

    public String getPermessoControllo(Permesso permesso) throws EccezioneCripto, IOException {
        libCrittografia.Aes aes = new Aes(Configuration.getAES_KEY());

        String utenteCifrato = aes.cifraToString(permesso.getUtente().toString());
        PermessoControllo permessoControllato = new PermessoControllo(permesso);
        permessoControllato.setUtenteCifrato(utenteCifrato);

        return permessoControllato.toString();
    }

    public String firmaDigitalmente(Permesso permesso) throws EccezioneCripto, IOException {
        libCrittografia.Rsa rsa = new Rsa(Configuration.getRSA_PUBLIC_KEY(), Configuration.getRSA_PRIVATE_KEY());
        String permessoSicuro = getPermessoControllo(permesso);
        return rsa.cifraPrivata(permessoSicuro, rsa.getChiavePrivata());
    }

    public String contenutoFirma(String permessoFirmatoDigitalmente) throws EccezioneCripto, IOException {
        libCrittografia.Rsa rsa = new Rsa(Configuration.getRSA_PUBLIC_KEY(), Configuration.getRSA_PRIVATE_KEY());
        return rsa.decifraPubblica(permessoFirmatoDigitalmente, rsa.getChiavePubblica());
    }

    public String getDatiUtente(String permessoFirmatoDigitalmente) throws EccezioneCripto, IOException {
        String permessoControllo = contenutoFirma(permessoFirmatoDigitalmente);

        // Ottengo l'utente cifrato
        String[] split = permessoControllo.split(":");
        String utenteCifrato = split[split.length - 1];
        utenteCifrato = utenteCifrato.substring(2, utenteCifrato.length() - 3);
        libCrittografia.Aes aes = new Aes(Configuration.getAES_KEY());

        return aes.decifra(utenteCifrato);
    }
}
