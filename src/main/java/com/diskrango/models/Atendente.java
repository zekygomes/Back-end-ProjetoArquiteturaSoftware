package com.diskrango.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * 
 * @author Zeky and Maurício
 *
 */
@Entity
@Table(name="atendente")
public class Atendente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id_atendente;
	
	@Column(name ="nome")
    protected String nome;
	

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

	public Long getIdAtendente() {
		return id_atendente;
	}

	public void setIdAtendente(Long idAtendente) {
		this.id_atendente = idAtendente;
	}
	@JsonCreator
	public Atendente(@JsonProperty("idAtendente") Long idAtendente, @JsonProperty("nome")String nome) {
		this.nome = nome;
		this.id_atendente = idAtendente;
	}
	
	

}