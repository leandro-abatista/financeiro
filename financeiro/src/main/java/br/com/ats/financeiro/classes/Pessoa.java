package br.com.ats.financeiro.classes;

import javax.persistence.MappedSuperclass;

@MappedSuperclass // notação para falar que não é uma tabela, porém que vai ser usada por outras// tabela//herança
public class Pessoa extends GenericDomain {

	private static final long serialVersionUID = 1L;
	
	protected String nome;
	protected String sobrenome;
	protected String cpf;
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
