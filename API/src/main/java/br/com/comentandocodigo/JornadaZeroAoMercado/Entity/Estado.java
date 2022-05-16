package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Estado extends GenericEntity<Integer> {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer ID_ESTADO;
    private String NOME;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "ID_PAIS" )
    private Pais pais;

    @OneToMany(mappedBy = "estado")
    private List<Cidade> lstCidade;

    public Integer getID_ESTADO() {
        return ID_ESTADO;
    }

    public void setID_ESTADO(Integer ID_ESTADO) {
        this.ID_ESTADO = ID_ESTADO;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public Pais getPais() {
        return pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public List<Cidade> getLstCidade() {
        return lstCidade;
    }

    public void setLstCidade(List<Cidade> lstCidade) {
        this.lstCidade = lstCidade;
    }

    @Override
    public void setId(Integer id) {
        this.ID_ESTADO = id;
    }
}
