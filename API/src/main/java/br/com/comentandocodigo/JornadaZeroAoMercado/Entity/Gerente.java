package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue( value = "gerente")
public class Gerente extends Pessoa {

    private Boolean podeAcessarCofre;

    public Boolean getPodeAcessarCofre() {
        return podeAcessarCofre;
    }

    public void setPodeAcessarCofre(Boolean podeAcessarCofre) {
        this.podeAcessarCofre = podeAcessarCofre;
    }
}
