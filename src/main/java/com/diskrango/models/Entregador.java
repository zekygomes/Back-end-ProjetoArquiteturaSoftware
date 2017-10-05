package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="entregador")
public class Entregador {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_entregador;
	
	@Column(name="placa_veiculo")
	private String placa_veiculo;
	
	@Column(name ="nome")
    protected String nome;
	
	public Entregador(){
		new Entregador("João","HJH_9888");
		new Entregador("Pedro","HHH-9999");
		new Entregador("Paulo","HJJ-8888");
	}
	
	@JsonCreator
	public Entregador(@JsonProperty("idEntregador")Long idEntregador, @JsonProperty("nome")String nome, @JsonProperty("placaVeiculo")String placaVeiculo) {
		this.nome = nome;
		this.id_entregador = idEntregador;
		this.placa_veiculo = placaVeiculo;
	}
	
	public Entregador(String nome,String placaVeiculo) {
		this.nome = nome;
		this.placa_veiculo = placaVeiculo;
	}


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
	
	public Long getIdEntregador() {
		return id_entregador;
	}

	public void setIdEntregador(Long idEntregador) {
		this.id_entregador = idEntregador;
	}

	public String getPlacaVeiculo() {
		return placa_veiculo;
	}

	public void setPlacaVeiculo(String placaVeiculo) {
		this.placa_veiculo = placaVeiculo;
	}

}

