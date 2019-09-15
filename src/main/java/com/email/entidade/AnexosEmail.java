package com.email.entidade;

import java.util.ArrayList;
import java.util.Collection;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;

/**
 *
 * @author manasses
 * Email manasses.java@gmail.com
 *
 */

public class AnexosEmail {

    private Collection<DataSource> anexos = null;

    public AnexosEmail() {
        anexos = new ArrayList<>();
    }
    
    public void add(String caminhoArquivo){
        anexos.add(new FileDataSource(caminhoArquivo));
    }
    
    public void addFile(DataSource file){
        anexos.add(file);
    }

    public Collection<DataSource> getAnexos() {
        return (Collection<DataSource>) (DataHandler) anexos;
    }

    public void setAnexos(Collection<DataSource> anexos) {
        this.anexos = anexos;
    }
}