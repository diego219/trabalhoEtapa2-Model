/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author diego
 */
public class OrdemServico implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_ordem_servico", sequenceName = "seq_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordem_servico", strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull(message = "O Valor Total deve ser informado")
    @Column(name = "unitario", columnDefinition = "decimal(12,2)", nullable = false)
    private Double valor_total;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_emissao", nullable = false)
    private Date data_emissao;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_prevista", nullable = false)
    private Date data_prevista;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_entrega", nullable = true)
    private Date data_entrega;
    @Length(max = 150, message = "A Observação não deve possuir mais de {max} caracteres")
    @Column(name = "nome", length = 150, nullable = true)
    private String observacoes;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the valor_total
     */
    public Double getValor_total() {
        return valor_total;
    }

    /**
     * @param valor_total the valor_total to set
     */
    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    /**
     * @return the data_emissao
     */
    public Date getData_emissao() {
        return data_emissao;
    }

    /**
     * @param data_emissao the data_emissao to set
     */
    public void setData_emissao(Date data_emissao) {
        this.data_emissao = data_emissao;
    }

    /**
     * @return the data_prevista
     */
    public Date getData_prevista() {
        return data_prevista;
    }

    /**
     * @param data_prevista the data_prevista to set
     */
    public void setData_prevista(Date data_prevista) {
        this.data_prevista = data_prevista;
    }

    /**
     * @return the data_entrega
     */
    public Date getData_entrega() {
        return data_entrega;
    }

    /**
     * @param data_entrega the data_entrega to set
     */
    public void setData_entrega(Date data_entrega) {
        this.data_entrega = data_entrega;
    }

    /**
     * @return the observacoes
     */
    public String getObservacoes() {
        return observacoes;
    }

    /**
     * @param observacoes the observacoes to set
     */
    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.id;
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
        final OrdemServico other = (OrdemServico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "id=" + id;
    }
    
}
