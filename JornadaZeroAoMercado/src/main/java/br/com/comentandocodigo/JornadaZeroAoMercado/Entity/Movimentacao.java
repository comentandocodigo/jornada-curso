package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;

@Entity
public class Movimentacao extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer ID_MOVIMENTACAO;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn( name = "ID_CONTA")
    private Conta conta;

    @Enumerated( EnumType.STRING )
    private TiposMovimentacaoEnum tiposMovimentacao;

    private Double valor;

    public Integer getID_MOVIMENTACAO() {
        return ID_MOVIMENTACAO;
    }

    public void setID_MOVIMENTACAO(Integer ID_MOVIMENTACAO) {
        this.ID_MOVIMENTACAO = ID_MOVIMENTACAO;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public TiposMovimentacaoEnum getTiposMovimentacao() {
        return tiposMovimentacao;
    }

    public void setTiposMovimentacao(TiposMovimentacaoEnum tiposMovimentacao) {
        this.tiposMovimentacao = tiposMovimentacao;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public void setId(Integer id) {
        this.ID_MOVIMENTACAO = id;
    }
}
