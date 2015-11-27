/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author diego
 */
@Entity
@Table(name = "ordem_servico")
public class OrdemServico implements Serializable{
    @Id
    @SequenceGenerator(name = "seq_ordem_servico", sequenceName = "seq_ordem_servico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_ordem_servico", strategy = GenerationType.SEQUENCE)
    private int id;
    @NotNull(message = "O Valor Total deve ser informado")
    @Column(name = "valor_total", columnDefinition = "decimal(12,2)", nullable = false)
    private Double valor_total;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_emissao", nullable = false)
    private Calendar data_emissao;
    @NotNull(message = "A Data de Previsão de Entrega deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_prevista", nullable = false)
    private Calendar data_prevista;
    @Temporal(TemporalType.DATE)
    @Column(name = "data_entrega", nullable = true)
    private Calendar data_entrega;
    @Length(max = 150, message = "A Observação não deve possuir mais de {max} caracteres")
    @Column(name = "observacoes", length = 150, nullable = true)
    private String observacoes;
    @NotNull(message = "O Cliente deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;
    @OneToMany(mappedBy = "ordem_servico",cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<ItemOrdemServico> itens_ordem_servico = new ArrayList<>();

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
    public Calendar getData_emissao() {
        return data_emissao;
    }

    /**
     * @param data_emissao the data_emissao to set
     */
    public void setData_emissao(Calendar data_emissao) {
        this.data_emissao = data_emissao;
    }

    /**
     * @return the data_prevista
     */
    public Calendar getData_prevista() {
        return data_prevista;
    }

    /**
     * @param data_prevista the data_prevista to set
     */
    public void setData_prevista(Calendar data_prevista) {
        this.data_prevista = data_prevista;
    }

    /**
     * @return the data_entrega
     */
    public Calendar getData_entrega() {
        return data_entrega;
    }

    /**
     * @param data_entrega the data_entrega to set
     */
    public void setData_entrega(Calendar data_entrega) {
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

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemOrdemServico> getItens_ordem_servico() {
        return itens_ordem_servico;
    }

    public void setItens_ordem_servico(List<ItemOrdemServico> itens_ordem_servico) {
        this.itens_ordem_servico = itens_ordem_servico;
    }
    
    public void adicionarItemOrdemServico(ItemOrdemServico obj){
        obj.setOrdem_servico(this);
        itens_ordem_servico.add(obj);
    }
    
    public void removerItemOrdemServico(int index){
        itens_ordem_servico.remove(index);
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
