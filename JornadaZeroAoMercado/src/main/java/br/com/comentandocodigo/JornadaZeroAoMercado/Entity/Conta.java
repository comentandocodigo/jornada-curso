package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Conta extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer CODIGO;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "ID_AGENCIA")
    private Agencia agencia;

    @OneToMany(mappedBy = "conta")
    private List<Conta_x_correntista> lstRelacionamentoCorrentista;

    @OneToMany(mappedBy = "conta")
    private List<Movimentacao> lstMovimentacao;

    private Double SALDO;

    public Integer getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(Integer CODIGO) {
        this.CODIGO = CODIGO;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Conta_x_correntista> getLstRelacionamentoCorrentista() {
        return lstRelacionamentoCorrentista;
    }

    public void setLstRelacionamentoCorrentista(List<Conta_x_correntista> lstRelacionamentoCorrentista) {
        this.lstRelacionamentoCorrentista = lstRelacionamentoCorrentista;
    }

    public Double getSALDO() {
        return SALDO;
    }

    public void setSALDO(Double SALDO) {
        this.SALDO = SALDO;
    }

    public List<Movimentacao> getLstMovimentacao() {
        return lstMovimentacao;
    }

    public void setLstMovimentacao(List<Movimentacao> lstMovimentacao) {
        this.lstMovimentacao = lstMovimentacao;
    }

    @Override
    public void setId(Integer id) {
        this.CODIGO = id;
    }
}
