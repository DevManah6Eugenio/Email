package com.email.entidade;

import java.util.Properties;

/**
 *
 * @author Manasses
 */
public class PropertiesGmail {
    
    private Email email = null;
    private Properties pr = null;
    
    public PropertiesGmail() {
    }
    
    public PropertiesGmail(Email email) {
        this.email = email;
    }

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Properties getPr() {
        return pr;
    }

    public void setPr(Properties pr) {
        this.pr = pr;
    }
    
    public Properties getProperties() {
        pr = new Properties();
        pr.put("mail.smtp.host", email.getEnderecoSmtp());
        pr.put("mail.smtp.socketFactory.port", email.getPortaSsl());
        pr.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        pr.put("mail.smtp.auth", email.getIsSslNecessario());
        pr.put("mail.smtp.port", email.getPortaSsl());
        return pr;
    }
}
