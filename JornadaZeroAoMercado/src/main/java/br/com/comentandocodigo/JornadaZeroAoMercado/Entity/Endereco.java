package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Endereco extends GenericEntity<Integer> {

    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer ID_ENDERECO;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ID_BAIRRO")
    private Bairro bairro;

    private String LOUGRADOURO;
    private Integer NUMERO;
    private String CEP;
    private String COMPLEMENTO;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "ID_AGENCIA" )
    private Agencia agencia;

    @ManyToMany( cascade = CascadeType.ALL)
    @JoinTable( name = "ENDERECO_X_CORRENTISTA",
            joinColumns = { @JoinColumn( name = "ID_ENDERECO") },
            inverseJoinColumns = { @JoinColumn( name = "ID_CORRENTISTA") }
    )
    private List<Correntista> correntistas;

    public Integer getID_ENDERECO() {
        return ID_ENDERECO;
    }

    public void setID_ENDERECO(Integer ID_ENDERECO) {
        this.ID_ENDERECO = ID_ENDERECO;
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }

    public String getLOUGRADOURO() {
        return LOUGRADOURO;
    }

    public void setLOUGRADOURO(String LOUGRADOURO) {
        this.LOUGRADOURO = LOUGRADOURO;
    }

    public Integer getNUMERO() {
        return NUMERO;
    }

    public void setNUMERO(Integer NUMERO) {
        this.NUMERO = NUMERO;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }

    public String getCOMPLEMENTO() {
        return COMPLEMENTO;
    }

    public void setCOMPLEMENTO(String COMPLEMENTO) {
        this.COMPLEMENTO = COMPLEMENTO;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public List<Correntista> getCorrentistas() {
        return correntistas;
    }

    public void setCorrentistas(List<Correntista> correntistas) {
        this.correntistas = correntistas;
    }

    @Override
    public void setId(Integer id) {
        this.ID_ENDERECO = id;
    }
}
