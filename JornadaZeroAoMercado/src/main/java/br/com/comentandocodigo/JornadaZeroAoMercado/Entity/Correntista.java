package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Correntista extends GenericEntity<Integer> {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer ID_CORRENTISTA;
    private String NOME;
    private String CPF;

    @OneToMany(mappedBy = "correntista")
    private List<Conta_x_correntista> lstRelacionamentoConta;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable( name = "ENDERECO_X_CORRENTISTA",
            joinColumns = { @JoinColumn( name = "ID_CORRENTISTA") },
            inverseJoinColumns = { @JoinColumn( name = "ID_ENDERECO") }
    )
    private List<Endereco> endereco;

    public Integer getID_CORRENTISTA() {
        return ID_CORRENTISTA;
    }

    public void setID_CORRENTISTA(Integer ID_CORRENTISTA) {
        this.ID_CORRENTISTA = ID_CORRENTISTA;
    }

    public String getNOME() {
        return NOME;
    }

    public void setNOME(String NOME) {
        this.NOME = NOME;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public List<Conta_x_correntista> getLstRelacionamentoConta() {
        return lstRelacionamentoConta;
    }

    public void setLstRelacionamentoConta(List<Conta_x_correntista> lstRelacionamentoConta) {
        this.lstRelacionamentoConta = lstRelacionamentoConta;
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    @Override
    public void setId(Integer id) {
        this.ID_CORRENTISTA = id;
    }
}
