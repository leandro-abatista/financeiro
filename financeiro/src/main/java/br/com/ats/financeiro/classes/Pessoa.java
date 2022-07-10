package br.com.ats.financeiro.classes;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass // notação para falar que não é uma tabela, porém que vai ser usada por outras// tabela//herança
public class Pessoa extends GenericDomain {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 50)
	protected String nome;
	@Column(nullable = false, length = 100)
	protected String sobrenome;
	@Column(nullable = false, length = 14, unique = true)
	protected String cpf;
	@Column(nullable = false, length = 200)
	protected String email;
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
}
