package com.email.entidade;

/**
 *
 * @author manasses 
 * @Email manasses.java@gmail.com
 *
 */
public class Mensagem {

    private String assunto = null;
    private String mensagem = null;
    private String remetente = null;
    private String destinatario = null;
    
    private Email email = null;

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

    public Email getEmail() {
        return email;
    }

    public void setEmail(Email email) {
        this.email = email;
    } 
}