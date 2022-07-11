package br.com.ats.financeiro.classes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_cliente")
public class Cliente extends Pessoa {

	private static final long serialVersionUID = 1L;

	@Column(nullable = false, length = 8, unique = true)
	private String rg;
	@Column(nullable = false, length = 8)
	private String orgaoExpeditor;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new Date();
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

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

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
