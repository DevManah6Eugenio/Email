package email.entidades.secao;

import java.util.Properties;
import javax.mail.Session;

/**
 *
 * @author manasses Email manasses.java@gmail.com
 *
 */
public class Secao {

    private Properties props = null;
    Session session = null;

    public Secao(String email, String senha, boolean debug) {
        props = this.getPropertiesGmail();
        session = Session.getDefaultInstance(props, new AuthenticatorImpl(email, senha));
        session.setDebug(debug);
    }

    public Session getSession() {
        return session;
    }

    //properties para Gmail
    private Properties getPropertiesGmail() {
        Properties pr = new Properties();
        pr.put("mail.smtp.host", "smtp.gmail.com");
        pr.put("mail.smtp.socketFactory.port", 465);
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pr.put("mail.smtp.auth", true);
        pr.put("mail.smtp.port", 465);
        return pr;
    }
}
