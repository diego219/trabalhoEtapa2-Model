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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "produto_servico")
public class ProdutoServico implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_produto_servico", sequenceName = "seq_produto_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_produto_servico", strategy = GenerationType.SEQUENCE)
    private int id;
    @NotBlank(message = "A Descrição deve ser informada")
    @Length(max = 50, message = "A Descrição não deve possuir mais de {max} caracteres")
    @Column(name = "descricao", length = 50, nullable = false)
    private String descricao;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Date data_cadastro;
    @NotNull(message = "O Valor de Custo deve ser informado")
    @Column(name = "valor_custo", nullable = false, columnDefinition = "decimal(9,2)")
    private Double valor_custo;
    @NotNull(message = "O Valor de Acréscimo deve ser informado")
    @Column(name = "valor_unitario", nullable = false, columnDefinition = "decimal(9,2)")
    private Double valor_unitario;
    @NotBlank(message = "A Unidade deve ser informada")
    @Length(max = 2, message = "A Unidade não deve possuir mais de {max} caracteres")
    @Column(name = "unidade", length = 2, nullable = false)
    private String unidade;

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
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the data_cadastro
     */
    public Date getData_cadastro() {
        return data_cadastro;
    }

    /**
     * @param data_cadastro the data_cadastro to set
     */
    public void setData_cadastro(Date data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    /**
     * @return the valor_custo
     */
    public Double getValor_custo() {
        return valor_custo;
    }

    /**
     * @param valor_custo the valor_custo to set
     */
    public void setValor_custo(Double valor_custo) {
        this.valor_custo = valor_custo;
    }

    /**
     * @return the valor_unitario
     */
    public Double getValor_unitario() {
        return valor_unitario;
    }

    /**
     * @param valor_unitario the valor_unitario to set
     */
    public void setValor_unitario(Double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    /**
     * @return the unidade
     */
    public String getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.id;
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
        final ProdutoServico other = (ProdutoServico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return descricao;
    }
}
