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
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.br.CPF;

/**
 *
 * @author diego
 */
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cliente_comum")
public class ClienteComum extends Cliente implements Serializable{
    @CPF(message = "O CPF deve ser válido")
    @NotBlank(message = "O CPF deve ser informado")
    @Length(max = 14, message = "O CPF não deve possuir mais de {max} digitos")
    @Column(name = "cpf", length = 14, nullable = false, unique = true)
    private String cpf;
    //@@@AJUSTAR
    private Date nascimento;
    //@@@AJUSTAR
    private Boolean spc;

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nascimento
     */
    public Date getNascimento() {
        return nascimento;
    }

    /**
     * @param nascimento the nascimento to set
     */
    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    /**
     * @return the spc
     */
    public Boolean getSpc() {
        return spc;
    }

    /**
     * @param spc the spc to set
     */
    public void setSpc(Boolean spc) {
        this.spc = spc;
    }
    
    
}
