package br.com.ats.financeiro.classes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_usuario")
public class Usuario extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 30)
	private String login;
	
	@Column(nullable = false, length = 8)
	private String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
