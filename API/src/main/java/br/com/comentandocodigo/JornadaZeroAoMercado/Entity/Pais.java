package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Pais extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer ID_PAIS;
    private String NOME;

    @OneToMany( mappedBy = "pais")
    private List<Estado> lstEstado;

    public Integer getID_PAIS() {
        return ID_PAIS;
    }

    public void setID_PAIS(Integer ID_PAIS) {
        this.ID_PAIS = ID_PAIS;
    }

    @Override
    public void setId(Integer id) {
        this.ID_PAIS = id;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public List<Estado> getLstEstado() {
        return lstEstado;
    }

    public void setLstEstado(List<Estado> lstEstado) {
        this.lstEstado = lstEstado;
    }
}