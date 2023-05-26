package utility;

import domain.Utente;

public class Authentication {

    public static boolean isAuthenticated(Utente utente) {
        return utente != null;
    }
}
