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

@Entity
@Table(name="cliente")
public class Cliente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_cliente;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="email_cliente")
	private String email_cliente;

	@Column(name="endereco_cliente")
	private String endereco_cliente;
	
	@Column(name="telefone_cliente")
	private String telefone_cliente;
	
	@Column(name="ponto_referencia_cliente")
	private String ponto_referencia_cliente;
	
	@Column(name="situacao_cliente")
	private String situacao_cliente;
	
	@Column(name="devolucao_cliente")
	private Integer devolucao_cliente;
	
    public Integer getDevolucao_cliente() {
		return devolucao_cliente;
	}

	public void setDevolucao_cliente(Integer devolucao_cliente) {
		this.devolucao_cliente = devolucao_cliente;
	}
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Pedido> pedidos;

	public Cliente() {
	}

	@JsonCreator
	public Cliente(@JsonProperty("idCliente")Long id, 
			@JsonProperty("nome")String nome, 
			@JsonProperty("emailCliente")String email, 
			@JsonProperty("enderecoCliente")String endereco, 
			@JsonProperty("telefoneCliente")String telefone, 
			@JsonProperty("pontoDeReferencia")String pontoDeReferencia, 
			@JsonProperty("situacaoCliente")String situacaoCliente,
			@JsonProperty("devolucaoCliente")Integer devolucaoCliente) {
		this.id_cliente = id;
		this.nome = nome;
		this.email_cliente = email;
		this.endereco_cliente = endereco;
		this.telefone_cliente = telefone;
		this.ponto_referencia_cliente = pontoDeReferencia;
		this.situacao_cliente = situacaoCliente;
		this.devolucao_cliente = devolucaoCliente;
	}

	@Override
	public String toString() {
		return "Cliente{ id='" + this.id_cliente + '\'' + 
						", nome='" + this.nome + '\'' + 
						", email='" + this.email_cliente + '\'' + 
						", endereço='" + this.endereco_cliente + '\''+
						", telefone='" + this.telefone_cliente + '\'' +
						", situacao='" + this.situacao_cliente + '\'' +
						", devolucao='" + this.devolucao_cliente + '\'' +'}';
	}

	public Long getId_cliente() {
		return id_cliente;
	}

	public void setId_cliente(Long id_cliente) {
		this.id_cliente = id_cliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail_cliente() {
		return email_cliente;
	}

	public void setEmail_cliente(String email_cliente) {
		this.email_cliente = email_cliente;
	}

	public String getEndereco_cliente() {
		return endereco_cliente;
	}

	public void setEndereco_cliente(String endereco_cliente) {
		this.endereco_cliente = endereco_cliente;
	}

	public String getTelefone_cliente() {
		return telefone_cliente;
	}

	public void setTelefone_cliente(String telefone_cliente) {
		this.telefone_cliente = telefone_cliente;
	}

	public String getPonto_referencia_cliente() {
		return ponto_referencia_cliente;
	}

	public void setPonto_referencia_cliente(String ponto_referencia_cliente) {
		this.ponto_referencia_cliente = ponto_referencia_cliente;
	}

	public String getSituacao_cliente() {
		return situacao_cliente;
	}

	public void setSituacao_cliente(String situacao_cliente) {
		this.situacao_cliente = situacao_cliente;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedidos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}


}
