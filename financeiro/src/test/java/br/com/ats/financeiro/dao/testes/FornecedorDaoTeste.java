package br.com.ats.financeiro.dao.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.transaction.SystemException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ats.financeiro.classes.Fornecedor;
import br.com.ats.financeiro.dao.FornecedorDao;
import br.com.ats.financeiro.exceptions.Excecoes;

public class FornecedorDaoTeste {

	@Test
	@Ignore
	public void salvar() throws ParseException, IllegalStateException, Excecoes, SystemException {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setRazaoSocial("ArfaxTechSoft ltda");
		fornecedor.setNomeFantasia("ArfaxTechSoft");
		fornecedor.setCnpj("012.111.111/0001-12");
		fornecedor.setEmail("ats@gmail.com");
		fornecedor.setInscEstadual("132456");
		fornecedor.setInscMunicipal("123456");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		fornecedor.setDataFundacao(sdf.parse("25-05-2000"));
		
		FornecedorDao dao = new FornecedorDao();
		dao.salvar(fornecedor);
		System.out.println("Fornecedor salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void merge() throws ParseException, IllegalStateException, Excecoes, SystemException {
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setRazaoSocial("patlog distribuidora de alimentos ltda");
		fornecedor.setNomeFantasia("patlog");
		fornecedor.setCnpj("033.325.222/0001-99");
		fornecedor.setEmail("patlog@gmail.com");
		fornecedor.setInscEstadual("123");
		fornecedor.setInscMunicipal("1322");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		fornecedor.setDataFundacao(sdf.parse("30-02-2005"));
		
		FornecedorDao dao = new FornecedorDao();
		dao.merge(fornecedor);
		System.out.println("Fornecedor salvo com sucesso!");
	}
}
