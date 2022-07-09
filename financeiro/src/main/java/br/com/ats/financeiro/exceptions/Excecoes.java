package br.com.ats.financeiro.exceptions;

public class Excecoes extends Exception {

	
	private static final long serialVersionUID = 1L;

	public Excecoes(String mensagemErro) {
		super("Erro de conexão : " + mensagemErro);
	}
}
