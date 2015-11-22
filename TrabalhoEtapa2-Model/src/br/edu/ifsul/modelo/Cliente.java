/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "cliente")
abstract class Cliente implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
    private int id;
    @NotBlank(message = "O Nome deve ser informado")
    @Length(max = 50, message = "O Nome não deve possuir mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;
    @NotBlank(message = "O Endereço deve ser informado")
    @Length(max = 150, message = "O Endereço não deve possuir mais de {max} caracteres")
    @Column(name = "endereco", length = 150, nullable = false)
    private String endereco;
    @NotBlank(message = "O Cep deve ser informado")
    @Length(max = 9, message = "O Cep não deve possuir mais de {max} caracteres")
    @Column(name = "cep", length = 9, nullable = false)
    private String cep;
    @NotBlank(message = "O Telefone deve ser informado")
    @Length(max = 14, message = "O Telefone não deve possuir mais de {max} caracteres")
    @Column(name = "telefone", length = 14, nullable = false)
    private String telefone;
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "data_cadastro", nullable = false)
    private Date data_cadastro; //Preenche automatico
    @NotNull
    @Column(name = "ativo", nullable = false)
    private Boolean ativo; //Preenche automatico
    @NotNull(message = "A cidade deve ser informada")
    @ManyToOne
    @JoinColumn(name = "cidade",referencedColumnName = "id",nullable = false)
    private Cidade cidade;
    @OneToMany(mappedBy = "cliente",cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)    
    private List<OrdemServico> ordens_servico = new ArrayList<>();

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
     * @return the endereco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco the endereco to set
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * @return the cep
     */
    public String getCep() {
        return cep;
    }

    /**
     * @param cep the cep to set
     */
    public void setCep(String cep) {
        this.cep = cep;
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
     * @return the ativo
     */
    public Boolean getAtivo() {
        return ativo;
    }

    /**
     * @param ativo the ativo to set
     */
    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }
    
    /**
     * @return the cidade
     */
    public Cidade getCidade() {
        return cidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public List<OrdemServico> getOrdens_servico() {
        return ordens_servico;
    }

    public void setOrdens_servico(List<OrdemServico> ordens_servico) {
        this.ordens_servico = ordens_servico;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.id;
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
        final Cliente other = (Cliente) obj;
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
