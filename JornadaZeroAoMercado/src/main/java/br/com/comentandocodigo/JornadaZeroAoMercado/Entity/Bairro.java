package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Bairro extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer ID_BAIRRO;
    private String NOME;

    @ManyToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "ID_CIDADE")
    private Cidade cidade;

    @OneToMany(mappedBy = "bairro")
    private List<Endereco> lstEndereco;

    public Integer getID_BAIRRO() {
        return ID_BAIRRO;
    }

    public void setID_BAIRRO(Integer ID_BAIRRO) {
        this.ID_BAIRRO = ID_BAIRRO;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<Endereco> getLstEndereco() {
        return lstEndereco;
    }

    public void setLstEndereco(List<Endereco> lstEndereco) {
        this.lstEndereco = lstEndereco;
    }

    @Override
    public void setId(Integer id) {
        this.ID_BAIRRO = id;
    }
}
