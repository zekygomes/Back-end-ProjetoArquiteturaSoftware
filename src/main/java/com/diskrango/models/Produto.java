package com.diskrango.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author Zeky and Maurício
 *
 */
@Entity
@Table(name="produto")
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cod_produto;
	
	@Column(name="nome")
	private String nome;

	@Column(name="preco_produto")
	private String preco_produto;
	
	@Column(name="tipo_produto")
	private String tipo_produto;
	
	@Column(name="qnt_produto")
	private String qnt_estoque;
	@JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produto")
    private List<ItemPedido> itensPedido;
    
    public Produto(){}
	
    @JsonCreator
	public Produto(@JsonProperty("codProduto")Long codProduto,
			@JsonProperty("nome")String nome, 
			@JsonProperty("precoProduto")String precoProduto, 
			@JsonProperty("qntEstoque")String qntEstoque, 
			@JsonProperty("tipoProduto")String tipoProduto)  {
		this.cod_produto = codProduto;
		this.nome = nome;
		this.preco_produto = precoProduto;
		this.tipo_produto = tipoProduto;
		this.qnt_estoque = qntEstoque;
	}

	@Override
	public String toString() {
		return "Produto{codProduto='" + this.cod_produto + '\'' + 
                ", nome='" + this.nome + '\'' +
                ", preco='" + this.preco_produto + '\'' + 
                ", quantidade='" + this.qnt_estoque +'\''+
                ", tipoProduto='" + this.tipo_produto + '\'' +
                '}';
	}
	
	public void atualizarEstoque(Produto produto, String qntEstoque){
		produto.qnt_estoque = qntEstoque;
	}

	public Long getCod_produto() {
		return cod_produto;
	}

	public void setCod_produto(Long cod_produto) {
		this.cod_produto = cod_produto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco_produto() {
		return preco_produto;
	}

	public void setPreco_produto(String preco_produto) {
		this.preco_produto = preco_produto;
	}

	public String getTipo_produto() {
		return tipo_produto;
	}

	public void setTipo_produto(String tipo_produto) {
		this.tipo_produto = tipo_produto;
	}

	public String getQnt_estoque() {
		return qnt_estoque;
	}

	public void setQnt_estoque(String qnt_estoque) {
		this.qnt_estoque = qnt_estoque;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}


}
