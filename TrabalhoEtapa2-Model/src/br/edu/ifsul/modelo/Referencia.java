/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "referencia")
public class Referencia implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_referencia", sequenceName = "seq_referencia_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_referencia", strategy = GenerationType.SEQUENCE)
    private int id;
    @NotBlank(message = "O Nome deve ser informado")
    @Length(max = 50, message = "O Nome não deve possuir mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotBlank(message = "O Telefone deve ser informado")
    @Length(max = 14, message = "O Telefone não deve possuir mais de {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;
    @Length(max = 14, message = "O Celular não deve possuir mais de {max} caracteres")
    @Column(name = "celular", length = 14, nullable = true)
    private String celular;
    @Length(max = 50, message = "O Grau de Parentesco deve possuir mais de {max} caracteres")
    @Column(name = "parentesco", length = 50, nullable = true)
    private String parentesco;
    @NotNull(message = "O Cliente Comum deve ser informado")
    @ManyToOne
    @JoinColumn(name = "cliente_comum_id", referencedColumnName = "id", nullable = false)
    private ClienteComum cliente_comum;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     * @return the celular
     */
    public String getCelular() {
        return celular;
    }

    /**
     * @param celular the celular to set
     */
    public void setCelular(String celular) {
        this.celular = celular;
    }

    /**
     * @return the parentesco
     */
    public String getParentesco() {
        return parentesco;
    }

    /**
     * @param parentesco the parentesco to set
     */
    public void setParentesco(String parentesco) {
        this.parentesco = parentesco;
    }

    public ClienteComum getCliente_comum() {
        return cliente_comum;
    }

    public void setCliente_comum(ClienteComum cliente_comum) {
        this.cliente_comum = cliente_comum;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Referencia other = (Referencia) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome;
    }
}
