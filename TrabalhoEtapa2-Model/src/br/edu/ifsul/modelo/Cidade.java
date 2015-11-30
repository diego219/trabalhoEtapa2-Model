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
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "cidade")
public class Cidade implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_cidade", sequenceName = "seq_cidade_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cidade", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotEmpty(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome deve ter no máximo {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @NotEmpty(message = "A UF deve ser informada")
    @Length(max = 2, message = "A UF deve ter no máximo {max} caracteres")
    @Column(name = "uf", length = 2, nullable = false)
    private String uf;

    @Length(max = 7, message = "O Código de Municipio do IBGE deve ter no máximo {max} caracteres")
    @Column(name = "codigo_municipio_ibge", length = 7, nullable = true)
    private String codigo_municipio_ibge;

    @Length(max = 2, message = "O Código de Estado do IBGE deve ter no máximo {max} caracteres")
    @Column(name = "codigo_estado_ibge", length = 2, nullable = true)
    private String codigo_estado_ibge;

    public Cidade() {

    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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
     * @return the uf
     */
    public String getUf() {
        return uf;
    }

    /**
     * @param uf the uf to set
     */
    public void setUf(String uf) {
        this.uf = uf;
    }

    /**
     * @return the codigo_municipio_ibge
     */
    public String getCodigo_municipio_ibge() {
        return codigo_municipio_ibge;
    }

    /**
     * @param codigo_municipio_ibge the codigo_municipio_ibge to set
     */
    public void setCodigo_municipio_ibge(String codigo_municipio_ibge) {
        this.codigo_municipio_ibge = codigo_municipio_ibge;
    }

    /**
     * @return the codigo_estado_ibge
     */
    public String getCodigo_estado_ibge() {
        return codigo_estado_ibge;
    }

    /**
     * @param codigo_estado_ibge the codigo_estado_ibge to set
     */
    public void setCodigo_estado_ibge(String codigo_estado_ibge) {
        this.codigo_estado_ibge = codigo_estado_ibge;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 43 * hash + this.id;
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
        final Cidade other = (Cidade) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nome + " - " + uf;
    }
}
