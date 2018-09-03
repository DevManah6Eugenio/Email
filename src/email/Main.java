package email;

import email.entidades.email.Email;
import email.entidades.email.ConfMensagemEmail;
import javax.mail.MessagingException;

public class Main {

    public static void main(String[] args) throws MessagingException {

        ConfMensagemEmail configuracaoMensagem = new ConfMensagemEmail();
        //para exibir mais informações
        configuracaoMensagem.setDebug(true);
        
        //configuração do E-mail
        configuracaoMensagem.setRemetente("manasses.java@gmail.com");//remetente
        configuracaoMensagem.setSenhaEmail("");//senha
        configuracaoMensagem.setAssunto("Assunto");//assunto
        configuracaoMensagem.setMensagem("Mensagem");//mensagem
        configuracaoMensagem.setDestinatario("manassescruz.sg@gmail.com");//destinatario(s)

        //classe responsavel por enviar email
        Email email = new Email(configuracaoMensagem);
        email.enviar();
    }
}
