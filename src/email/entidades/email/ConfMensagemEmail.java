package email.entidades.email;

/**
 *
 * @author manasses Email manasses.java@gmail.com
 *
 */
public class ConfMensagemEmail {

    private String assunto = null;
    private String mensagem = null;
    private String remetente = null;
    private String destinatario = null;
    private String senhaEmail = null;
    private boolean debug = false;

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getRemetente() {
        return remetente;
    }

    public void setRemetente(String remetente) {
        this.remetente = remetente;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getSenhaEmail() {
        return senhaEmail;
    }

    public void setSenhaEmail(String senhaEmail) {
        this.senhaEmail = senhaEmail;
    }

    public boolean isDebug() {
        return debug;
    }

    public void setDebug(boolean debug) {
        this.debug = debug;
    }
}
