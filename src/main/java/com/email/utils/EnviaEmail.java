package com.email.utils;

import com.email.entidade.Mensagem;
import com.email.entidade.Email;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Manasses
 */
public class EnviaEmail {

    private Email email = null;
    private Mensagem mensagem = null;
    private Session secao = null;

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    public Mensagem getMensagem() {
        return mensagem;
    }

    public void setMensagem(Mensagem mensagem) {
        this.mensagem = mensagem;
    }

    public Session getSecao() {
        return secao;
    }

    public void setSecao(Session secao) {
        this.secao = secao;
    }

    public void enviar() throws AddressException, MessagingException {
        Message message = null;
        Address[] toUser = null;
        Transport transport = null;
        try {
            message = new MimeMessage(this.secao);
            message.setFrom(new InternetAddress(mensagem.getRemetente()));//Remetente

            toUser = InternetAddress
                    .parse(mensagem.getDestinatario().trim().toLowerCase());//Destinatário(s)

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(mensagem.getAssunto());//Assunto
            message.setContent(mensagem.getMensagem(), "text/html");//mensagem

            transport = this.secao.getTransport();
            transport.connect();
            transport.sendMessage(message, toUser);
            transport.close();

            Transport.send(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            message = null;
            toUser = null;
            transport = null;
        }
    }
}
