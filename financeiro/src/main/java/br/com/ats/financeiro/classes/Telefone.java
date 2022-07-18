package br.com.ats.financeiro.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tb_fone")
public class Telefone extends GenericDomain {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 15)
	private String operadora;
	@Column(nullable = false, length = 30)
	private String descricao;
	@Column(nullable = false, length = 15)
	private String numero;
	
	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

}
