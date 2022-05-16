package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Cidade extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer ID_Cidade;
    private String nome;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "ID_ESTADO")
    private Estado estado;

    @OneToMany(mappedBy = "cidade")
    private List<Bairro> lstBairro;

    public Cidade() {}

    public Cidade(Integer ID_Cidade, String nome, Estado estado) {
        this.ID_Cidade = ID_Cidade;
        this.nome = nome;
        this.estado = estado;
    }

    public Integer getID_Cidade() {
        return ID_Cidade;
    }

    public void setID_Cidade(Integer ID_Cidade) {
        this.ID_Cidade = ID_Cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Bairro> getLstBairro() {
        return lstBairro;
    }

    public void setLstBairro(List<Bairro> lstBairro) {
        this.lstBairro = lstBairro;
    }

    @Override
    public void setId(Integer id) {
        this.ID_Cidade = id;
    }
}
