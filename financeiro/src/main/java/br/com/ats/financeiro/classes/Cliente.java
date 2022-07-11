package br.com.ats.financeiro.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 8, unique = true)
	private String rg;
	@Column(nullable = false, length = 8)
	private String orgaoExpeditor;
	@Column(name = "data_cadastro", columnDefinition = "DATE")
	private LocalDateTime dataCadastro = LocalDateTime.now();
	@Column(name = "data_nascimento", columnDefinition = "DATE")
	private LocalDate dataNascimento;

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getOrgaoExpeditor() {
		return orgaoExpeditor;
	}

	public void setOrgaoExpeditor(String orgaoExpeditor) {
		this.orgaoExpeditor = orgaoExpeditor;
	}

	public LocalDateTime getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDateTime dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
