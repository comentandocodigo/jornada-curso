package br.com.comentandocodigo.JornadaZeroAoMercado.Entity;

import javax.persistence.*;

/*
* SINGLE TABLE -> 1 Tabela com todos os campos das 3 classes
*
* JOINED -> 3 tabelas (pessoa com campos dela, gerente com os campos dela + id pessoa e tabela usuario com os campos dela + id pessoa)
*
* TABLE PER CLASS -> Tabela gerente todos os campos de pessoa + de gerente, tabela usuario todos os campos de pessoa + usuario
*
* */


@Entity
//@Inheritance( strategy = InheritanceType.SINGLE_TABLE )
//@Inheritance( strategy = InheritanceType.JOINED )
@Inheritance( strategy = InheritanceType.TABLE_PER_CLASS )
@DiscriminatorValue( value = "pessoa" )
public class Pessoa extends GenericEntity<Integer> {

    @Id
    protected Integer id_pessoa;
    protected String nome;
    protected String CPF;

    public Integer getId_pessoa() {
        return id_pessoa;
    }

    public void setId_pessoa(Integer id_pessoa) {
        this.id_pessoa = id_pessoa;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    @Override
    public void setId(Integer id) {
        this.id_pessoa = id;
    }
}
