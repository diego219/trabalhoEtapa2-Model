/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CNPJ;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "cliente_empresa")
public class ClienteEmpresa extends Cliente implements Serializable{
    @NotNull(message = "O CNPJ deve ser informado")
    @Column(name = "cnpj", length = 14, nullable = false)
    private int cnpj;
    @NotBlank(message = "O Nome do Contato deve ser informado")
    @Length(max = 50, message = "O Nome do Contato não deve possuir mais de {max} caracteres")
    @Column(name = "nome_contato", length = 50, nullable = false)
    private String nome_contato;
    @NotBlank(message = "O Celular do Contato deve ser informado")
    @Length(max = 14, message = "O Celular do Contato não deve possuir mais de {max} caracteres")
    @Column(name = "celular_contato", length = 14, nullable = false)
    private String celular_contato;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "fundacao", nullable = false)
    private Date fundacao;
    @NotBlank(message = "O Razão Social deve ser informado")
    @Length(max = 50, message = "O Razão Social não deve possuir mais de {max} caracteres")
    @Column(name = "razao_social", length = 50, nullable = false)
    private String razao_social;

    /**
     * @return the cnpj
     */
    public int getCnpj() {
        return cnpj;
    }

    /**
     * @param cnpj the cnpj to set
     */
    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the nome_contato
     */
    public String getNome_contato() {
        return nome_contato;
    }

    /**
     * @param nome_contato the nome_contato to set
     */
    public void setNome_contato(String nome_contato) {
        this.nome_contato = nome_contato;
    }

    /**
     * @return the celular_contato
     */
    public String getCelular_contato() {
        return celular_contato;
    }

    /**
     * @param celular_contato the celular_contato to set
     */
    public void setCelular_contato(String celular_contato) {
        this.celular_contato = celular_contato;
    }

    /**
     * @return the fundacao
     */
    public Date getFundacao() {
        return fundacao;
    }

    /**
     * @param fundacao the fundacao to set
     */
    public void setFundacao(Date fundacao) {
        this.fundacao = fundacao;
    }

    /**
     * @return the razao_social
     */
    public String getRazao_social() {
        return razao_social;
    }

    /**
     * @param razao_social the razao_social to set
     */
    public void setRazao_social(String razao_social) {
        this.razao_social = razao_social;
    }
    
    
}
