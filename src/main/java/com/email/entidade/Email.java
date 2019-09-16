package com.email.entidade;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Manasses
 */
@Entity
@Table(name = "email")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Email.findAll", query = "SELECT e FROM Email e"),
    @NamedQuery(name = "Email.findById", query = "SELECT e FROM Email e WHERE e.id = :id"),
    @NamedQuery(name = "Email.findByEnderecoSmtp", query = "SELECT e FROM Email e WHERE e.enderecoSmtp = :enderecoSmtp"),
    @NamedQuery(name = "Email.findByEnderecoEmail", query = "SELECT e FROM Email e WHERE e.enderecoEmail = :enderecoEmail"),
    @NamedQuery(name = "Email.findBySenhaSmtp", query = "SELECT e FROM Email e WHERE e.senhaSmtp = :senhaSmtp"),
    @NamedQuery(name = "Email.findByPortaSsl", query = "SELECT e FROM Email e WHERE e.portaSsl = :portaSsl"),
    @NamedQuery(name = "Email.findByIsSslNecessario", query = "SELECT e FROM Email e WHERE e.isSslNecessario = :isSslNecessario")})
public class Email implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "endereco_smtp")
    private String enderecoSmtp;
    @Size(max = 50)
    @Column(name = "endereco_email")
    private String enderecoEmail;
    @Size(max = 50)
    @Column(name = "senha_smtp")
    private String senhaSmtp;
    @Column(name = "porta_ssl")
    private Integer portaSsl;
    @Column(name = "is_ssl_necessario")
    private Boolean isSslNecessario;
    
    public Email() {
    }

    public Email(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEnderecoSmtp() {
        return enderecoSmtp;
    }

    public void setEnderecoSmtp(String enderecoSmtp) {
        this.enderecoSmtp = enderecoSmtp;
    }

    public String getEnderecoEmail() {
        return enderecoEmail;
    }

    public void setEnderecoEmail(String enderecoEmail) {
        this.enderecoEmail = enderecoEmail;
    }

    public String getSenhaSmtp() {
        return senhaSmtp;
    }

    public void setSenhaSmtp(String senhaSmtp) {
        this.senhaSmtp = senhaSmtp;
    }

    public Integer getPortaSsl() {
        return portaSsl;
    }

    public void setPortaSsl(Integer portaSsl) {
        this.portaSsl = portaSsl;
    }

    public Boolean getIsSslNecessario() {
        return isSslNecessario;
    }

    public void setIsSslNecessario(Boolean isSslNecessario) {
        this.isSslNecessario = isSslNecessario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Email)) {
            return false;
        }
        Email other = (Email) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.email.dao.Email[ id=" + id + " ]";
    }   
}
