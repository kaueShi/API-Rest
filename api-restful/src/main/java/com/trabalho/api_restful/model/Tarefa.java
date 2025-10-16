package com.trabalho.api_restful.model;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
public class Tarefa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false, length = 50)
	private String nome;
	
	@Column(name = "responsavel", nullable = false, length = 50)
	private String responsavel;
	
	@Column(name = "data_entrega" ,nullable = false)
	private LocalDate data_entrega;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public LocalDate getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(LocalDate data_entrega) {
		this.data_entrega = data_entrega;
	}

	@Override
	public String toString() {
		return "Tarefa [id=" + id + ", nome=" + nome + ", responsavel=" + responsavel + ", data_entrega=" + data_entrega
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(data_entrega, id, nome, responsavel);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(data_entrega, other.data_entrega) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && Objects.equals(responsavel, other.responsavel);
	}

}
