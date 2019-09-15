package com.email.entidade;

import com.email.secao.Secao;
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

    public ConfMensagemEmail getConfiguracao() {
        return configuracao;
    }
    
    public void enviar() throws AddressException, MessagingException {
        Message message = new MimeMessage(this.secao.getSession());
        message.setFrom(new InternetAddress(this.configuracao.getRemetente()));//Remetente

        Address[] toUser = InternetAddress
                .parse(this.configuracao.getDestinatario().trim().toLowerCase());//Destinatário(s)

        message.setRecipients(Message.RecipientType.TO, toUser);
        message.setSubject(this.configuracao.getAssunto());//Assunto
        message.setContent(this.configuracao.getMensagem(), "text/html");//mensagem
        
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