package email.entidades.email;

import email.entidades.secao.Secao;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Email {

    private Secao secao = null;
    private ConfMensagemEmail configuracao = null;

    public Email(ConfMensagemEmail configuracao) {
        this.configuracao = configuracao;
        this.secao = new Secao(configuracao.getRemetente(), configuracao.getSenhaEmail(), configuracao.isDebug());
    }

    public void setConfiguracao(ConfMensagemEmail configuracao) {
        this.configuracao = configuracao;
        this.setSecao(new Secao(this.configuracao.getRemetente(), this.configuracao.getSenhaEmail(), configuracao.isDebug()));
    }

    public void enviar() throws AddressException, MessagingException {
        Message message = new MimeMessage(this.secao.getSession());
        message.setFrom(new InternetAddress(configuracao.getRemetente()));//Remetente

        Address[] toUser = InternetAddress
                .parse(configuracao.getDestinatario().trim().toLowerCase());//Destinatário(s)

        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject(configuracao.getAssunto());//Assunto
        message.setContent(configuracao.getMensagem(), "text/html");//mensagem
        
//        FileDataSource fds = new FileDataSource("/home/manasses/Downloads/sql1br.sql");
//        message.setDataHandler(new DataHandler(fds));
//        message.setFileName(fds.getName());
        
        // Método para enviar a mensagem criada
        Transport.send(message);
    }

    private void setSecao(Secao secao) {
        this.secao = secao;
    }
}