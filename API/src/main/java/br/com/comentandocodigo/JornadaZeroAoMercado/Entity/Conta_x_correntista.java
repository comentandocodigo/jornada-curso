package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;

@Entity
public class Conta_x_correntista extends GenericEntity<Conta_x_correntistaId> {

    @EmbeddedId
    private Conta_x_correntistaId ID;
    private String tipo;

    @ManyToOne( cascade = CascadeType.ALL )
    @MapsId( "ID_CONTA" )
    private Conta conta;

    @ManyToOne( cascade = CascadeType.ALL )
    @MapsId( "ID_CORRENTISTA" )
    private Correntista correntista;

    public Conta_x_correntistaId getID() {
        return ID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Conta getConta() {
        return conta;
    }

    public void setConta(Conta conta) {
        this.conta = conta;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public void setCorrentista(Correntista correntista) {
        this.correntista = correntista;
    }

    @Override
    public void setId(Conta_x_correntistaId id) {
        this.ID = id;
    }
}
