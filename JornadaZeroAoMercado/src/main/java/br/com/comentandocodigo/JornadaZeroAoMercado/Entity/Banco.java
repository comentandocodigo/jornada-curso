package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Banco extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer CODIGO;
    private String NOME;

    public Integer getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(Integer CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    @Override
    public void setId(Integer id) {
        this.CODIGO = id;
    }
}
