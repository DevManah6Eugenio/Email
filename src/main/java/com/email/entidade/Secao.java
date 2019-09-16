package com.email.entidade;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Session;

/**
 *
 * @author manasses Email 
 * @Email manasses.java@gmail.com
 *
 */
public class Secao {

    private Properties props = null;
    private Authenticator authenticator = null;
    private PropertiesGmail propertiesGmail = null;
    private boolean debug = false;
    
    public Secao(Email email) {
        propertiesGmail = new PropertiesGmail(email);
        props = propertiesGmail.getProperties();
        authenticator = new AuthenticatorImpl(email.getEnderecoEmail(), email.getSenhaSmtp());
    }

    public Properties getProps() {
        return props;
    }

    public void setProps(Properties props) {
        this.props = props;
    }

    public Authenticator getAuthenticator() {
        return authenticator;
    }

    public void setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
    }

    public PropertiesGmail getPropertiesGmail() {
        return propertiesGmail;
    }

    public void setPropertiesGmail(PropertiesGmail propertiesGmail) {
        this.propertiesGmail = propertiesGmail;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
    
    public Session getSession() {
        Session secao = Session.getDefaultInstance(props, authenticator);
        secao.setDebug(debug);
        return secao;
    }
}
