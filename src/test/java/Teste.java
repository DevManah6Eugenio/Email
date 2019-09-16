
import com.email.entidade.Mensagem;
import com.email.entidade.Email;
import com.email.entidade.Secao;
import com.email.utils.EnviaEmail;
import javax.mail.MessagingException;

/**
 *
 * @author Manasses
 */
public class Teste {

    public static void main(String[] args) throws MessagingException {

        for (int i = 0; i < 1; i++) {

            Mensagem mensagem = new Mensagem();

            //configuração do E-mail
            mensagem.setRemetente("manasses.java@gmail.com");//remetente
            mensagem.setAssunto("Assunto");//assunto
            mensagem.setMensagem("Mensagem");//mensagem
            mensagem.setDestinatario("manassescruz.sg@gmail.com");//destinatario(s)

            Email email = new Email();

            email.setEnderecoEmail("manasses.java@gmail.com");
            email.setEnderecoSmtp("smtp.gmail.com");
            email.setIsSslNecessario(Boolean.TRUE);
            email.setPortaSsl(465);
            email.setSenhaSmtp("senha");

            Secao secao = new Secao(email);
            secao.setDebug(true);

            //classe responsavel por enviar email
            EnviaEmail enviaEmail = new EnviaEmail();

            enviaEmail.setEmail(email);
            enviaEmail.setMensagem(mensagem);
            enviaEmail.setSecao(secao.getSession());
            for (int j = 0; j < 10; j++) {
                enviaEmail.enviar();
            }
        }
    }
}
