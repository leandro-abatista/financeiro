package br.com.ats.financeiro.dao.testes;

import javax.transaction.SystemException;

import org.junit.Test;

import br.com.ats.financeiro.classes.Fornecedor;
import br.com.ats.financeiro.classes.Telefone;
import br.com.ats.financeiro.dao.FornecedorDao;
import br.com.ats.financeiro.dao.TelefoneDao;
import br.com.ats.financeiro.exceptions.Excecoes;

public class FoneDaoTeste {

	@Test
	public void salvar() throws Excecoes, IllegalStateException, SystemException {
		
		Long codigo = 3L;
		FornecedorDao fornecedorDao = new FornecedorDao();
		Fornecedor fornecedor = fornecedorDao.buscarPorId(codigo);
		
		if (fornecedor == null) {
			System.out.println("Nenhum fornecedor encontrado com o código " + codigo + "!");
		} else {
			Telefone telefone = new Telefone();
			telefone.setOperadora("OI");
			telefone.setDescricao("telefone fixo de vanessa");
			telefone.setNumero("(88) 3255-5588");
			
			TelefoneDao telefoneDao = new TelefoneDao();
			telefoneDao.salvar(telefone);
			System.out.println("Telefone salvo com sucesso!");
		}
	}
}
