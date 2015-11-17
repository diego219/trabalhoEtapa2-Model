/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author diego
 */
public class Referencia implements Serializable{
    @NotBlank(message = "O Nome deve ser informado")
    @Length(max = 50, message = "O Nome não deve possuir mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotBlank(message = "O Telefone deve ser informado")
    @Length(max = 14, message = "O Telefone não deve possuir mais de {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;
    @NotBlank(message = "O Celular deve ser informado")
    @Length(max = 14, message = "O Celular não deve possuir mais de {max} caracteres")
    @Column(name = "celular", length = 14, nullable = false)
    private String celular;
    @NotBlank(message = "O Grau de Parentesco deve ser informado")
    @Length(max = 50, message = "O Grau de Parentesco deve possuir mais de {max} caracteres")
    @Column(name = "parentesco", length = 50, nullable = false)
    private String parentesco;

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
}
