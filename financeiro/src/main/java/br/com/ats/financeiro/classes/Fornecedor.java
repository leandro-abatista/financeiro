package br.com.ats.financeiro.classes;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tb_fornecedor")
public class Fornecedor extends GenericDomain {

	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false, length = 150)
	private String razaoSocial;
	@Column(nullable = false, length = 150)
	private String nomeFantasia;
	@Column(nullable = false, length = 20)
	private String cnpj;
	@Column(nullable = false, length = 10)
	private String inscEstadual;
	@Column(nullable = false, length = 10)
	private String inscMunicipal;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastrado = new Date();
	@Temporal(TemporalType.DATE)
	private Date dataFundacao;
	@Column(nullable = false, length = 150)
	private String email;
//	@Column(nullable = false, length = )
//	private String status;/* Se estar ativa ou inativa */

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public Date getDataCadastrado() {
		return dataCadastrado;
	}

	public void setDataCadastrado(Date dataCadastrado) {
		this.dataCadastrado = dataCadastrado;
	}
	
	public Date getDataFundacao() {
		return dataFundacao;
	}
	
	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


}
