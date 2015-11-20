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

/**
 *
 * @author diego
 */
@Entity
@Table(name = "item_ordem_servico")
public class ItemOrdemServico implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_item_ordem_servico", sequenceName = "seq_item_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_item_ordem_servico", strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull(message = "A Quantidade deve ser informada")
    @Column(name = "quantidade", length = 10, nullable = false)
    private int quantidade;
    @NotNull(message = "O Desconto deve ser informado")
    @Column(name = "desconto", columnDefinition = "decimal(9,2)", nullable = false)
    private Double desconto;
    @NotNull(message = "O Acréscimo deve ser informada")
    @Column(name = "acrescimo", columnDefinition = "decimal(9,2)", nullable = false)
    private Double acrescimo;
    @NotNull(message = "O Valor Unitário deve ser informado")
    @Column(name = "unitario", columnDefinition = "decimal(9,2)", nullable = false)
    private Double unitario;
    @NotNull(message = "A O.S. deve ser informada")
    @ManyToOne
    @JoinColumn(name = "ordem_servico", referencedColumnName = "id", nullable = false)
    private OrdemServico ordem_servico;
    @NotNull(message = "O Produto/Serviço deve ser informado")
    @ManyToOne
    @JoinColumn(name = "produto_servico",referencedColumnName = "id",nullable = false)
    private ProdutoServico produto_servico;

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
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the desconto
     */
    public Double getDesconto() {
        return desconto;
    }

    /**
     * @param desconto the desconto to set
     */
    public void setDesconto(Double desconto) {
        this.desconto = desconto;
    }

    /**
     * @return the acrescimo
     */
    public Double getAcrescimo() {
        return acrescimo;
    }

    /**
     * @param acrescimo the acrescimo to set
     */
    public void setAcrescimo(Double acrescimo) {
        this.acrescimo = acrescimo;
    }

    /**
     * @return the unitario
     */
    public Double getUnitario() {
        return unitario;
    }

    /**
     * @param unitario the unitario to set
     */
    public void setUnitario(Double unitario) {
        this.unitario = unitario;
    }

    public OrdemServico getOrdem_servico() {
        return ordem_servico;
    }

    public void setOrdem_servico(OrdemServico ordem_servico) {
        this.ordem_servico = ordem_servico;
    }

    public ProdutoServico getProduto_servico() {
        return produto_servico;
    }

    public void setProduto_servico(ProdutoServico produto_servico) {
        this.produto_servico = produto_servico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + this.id;
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
        final ItemOrdemServico other = (ItemOrdemServico) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ID="+id;
    }
}
