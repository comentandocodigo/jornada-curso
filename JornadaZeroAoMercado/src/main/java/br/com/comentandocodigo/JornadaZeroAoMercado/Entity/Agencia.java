package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Agencia extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer CODIGO;
    private String NOME;

    @ManyToOne( cascade = CascadeType.ALL)
    @JoinColumn( name = "CODIG_BANCO" )
    private Banco banco;

    //@OneToOne( mappedBy = "agencia" )
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "ID_ENDERECO")
    private Endereco endereco;

    @OneToMany(mappedBy = "agencia")
    private List<Conta> lstContas;

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

    public Banco getBanco() {
        return banco;
    }

    public void setBanco(Banco banco) {
        this.banco = banco;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Conta> getLstContas() {
        return lstContas;
    }

    public void setLstContas(List<Conta> lstContas) {
        this.lstContas = lstContas;
    }

    @Override
    public void setId(Integer id) {
        this.CODIGO = id;
    }
}
