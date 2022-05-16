package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class Conta_x_correntistaId implements Serializable {

    private Integer ID_CONTA;
    private Integer ID_CORRENTISTA;

    public Conta_x_correntistaId(Integer ID_CONTA, Integer ID_CORRENTISTA) {
        this.ID_CONTA = ID_CONTA;
        this.ID_CORRENTISTA = ID_CORRENTISTA;
    }

    public Conta_x_correntistaId() {}
}
