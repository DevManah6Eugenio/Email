package email.entidades.secao;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

/**
 *
 * @author manasses Email manasses.java@gmail.com
 *
 */
public class AuthenticatorImpl extends Authenticator {

    private PasswordAuthentication passwordAuthentication = null;

    public AuthenticatorImpl(String email, String senha) {
        passwordAuthentication = new PasswordAuthentication(email, senha);
    }

    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return passwordAuthentication;
    }
}
