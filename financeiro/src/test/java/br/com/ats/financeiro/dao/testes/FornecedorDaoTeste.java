package br.com.ats.financeiro.dao.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

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
		fornecedor.setRazaoSocial("Explore ArfaxTech desenvolvimento de sistemas ltda");
		fornecedor.setNomeFantasia("Explore ArfaxTech");
		fornecedor.setCnpj("014.014.123/0001-25");
		fornecedor.setEmail("explore_arfax@gmail.com");
		fornecedor.setInscEstadual("333333");
		fornecedor.setInscMunicipal("333333");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		fornecedor.setDataFundacao(sdf.parse("30-12-1999"));
		
		FornecedorDao dao = new FornecedorDao();
		dao.salvar(fornecedor);
		System.out.println("Fornecedor salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void merge() throws ParseException, IllegalStateException, Excecoes, SystemException {
		
//		Telefone telefone = new Telefone();
//		telefone.setOperadora("TIM");
//		telefone.setDescricao("Telefone fixo");
//		telefone.setNumero("(88) 3421-5555");
//		TelefoneDao telefoneDao = new TelefoneDao();
//		telefoneDao.merge(telefone);
		
		Fornecedor fornecedor = new Fornecedor();
		fornecedor.setRazaoSocial("best distribuidora distribuidora de plásticos ltda");
		fornecedor.setNomeFantasia("best");
		fornecedor.setCnpj("033.325.101/0001-77");
		fornecedor.setEmail("bets@gmail.com");
		fornecedor.setInscEstadual("000111");
		fornecedor.setInscMunicipal("1112222");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		fornecedor.setDataFundacao(sdf.parse("05-02-2010"));
		
		FornecedorDao dao = new FornecedorDao();
		dao.merge(fornecedor);
		
		
		System.out.println("Fornecedor salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void listarFornecedor() throws Excecoes {
		
		FornecedorDao dao = new FornecedorDao();
		List<Fornecedor> fornecedores = dao.listar();
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println("Total de registros encontrados : " + fornecedores.size());
		
		for (Fornecedor fornecedor : fornecedores) {
			System.out.println("\nRazão Social : " + fornecedor.getRazaoSocial()
							  +"\nNome Fantasia : " + fornecedor.getNomeFantasia()
							  +"\nCNPJ : " +fornecedor.getCnpj()
							  +"\nEmail : " + fornecedor.getEmail()
							  +"\nInsc. Estadual : " + fornecedor.getInscEstadual()
							  +"\nInsc. Municipal : " + fornecedor.getInscMunicipal()
							  +"\nData Cadastro : " + data.format(fornecedor.getDataCadastrado())
							  +"\nData Fundação  : " + dataEHora.format(fornecedor.getDataFundacao()));
			System.out.println("-----------------------------------------------------------------");
		}  
	}
	
	@Test
	@Ignore
	public void buscarPorId() throws Excecoes {

		Long codigo = 1L;
		FornecedorDao dao = new FornecedorDao();
		Fornecedor fornecedor = dao.buscarPorId(codigo);

		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (fornecedor == null) {
			System.out.println("Nenhum fornecedor encontrado com código " + codigo + "!");
		} else {
			System.out.println(
					"\nRazão Social : " + fornecedor.getRazaoSocial() 
					+ "\nNome Fantasia : " + fornecedor.getNomeFantasia() 
					+ "\nCNPJ : " + fornecedor.getCnpj() 
					+ "\nEmail : " + fornecedor.getEmail() 
					+ "\nInsc. Estadual : " + fornecedor.getInscEstadual()
					+ "\nInsc. Municipal : " + fornecedor.getInscMunicipal() 
					+ "\nData Cadastro : " + dataEHora.format(fornecedor.getDataCadastrado()) 
					+ "\nData Fundação  : " + data.format(fornecedor.getDataFundacao()));
			System.out.println("-----------------------------------------------------------------");
		}
	}
	
	@Test
	@Ignore
	public void editar() throws Excecoes {
		
		Long codigo = 1L;
		FornecedorDao dao = new FornecedorDao();
		Fornecedor fornecedor = dao.buscarPorId(codigo);
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (fornecedor == null) {
			System.out.println("Nenhum fornecedor encontrado com código " + codigo + "!");
		} else {
			System.out.println("Antes de atualizar");
			System.out.println(
					"\nRazão Social : " + fornecedor.getRazaoSocial() 
					+ "\nNome Fantasia : " + fornecedor.getNomeFantasia() 
					+ "\nCNPJ : " + fornecedor.getCnpj() 
					+ "\nEmail : " + fornecedor.getEmail() 
					+ "\nInsc. Estadual : " + fornecedor.getInscEstadual()
					+ "\nInsc. Municipal : " + fornecedor.getInscMunicipal() 
					+ "\nData Cadastro : " + dataEHora.format(fornecedor.getDataCadastrado()) 
					+ "\nData Fundação  : " + data.format(fornecedor.getDataFundacao()));
			System.out.println("-----------------------------------------------------------------");
			
			fornecedor.setRazaoSocial("arfaxtechsoft prestadora de serviços e desenvolvimento de sistemas ltda");
			fornecedor.setNomeFantasia("arfaxtechsoft");
			dao.editar(fornecedor);
			
			System.out.println("Depois de atualizar");
			System.out.println(
					"\nRazão Social : " + fornecedor.getRazaoSocial() 
					+ "\nNome Fantasia : " + fornecedor.getNomeFantasia() 
					+ "\nCNPJ : " + fornecedor.getCnpj() 
					+ "\nEmail : " + fornecedor.getEmail() 
					+ "\nInsc. Estadual : " + fornecedor.getInscEstadual()
					+ "\nInsc. Municipal : " + fornecedor.getInscMunicipal() 
					+ "\nData Cadastro : " + dataEHora.format(fornecedor.getDataCadastrado()) 
					+ "\nData Fundação  : " + data.format(fornecedor.getDataFundacao()));
			System.out.println("-----------------------------------------------------------------");
		}
	}
	
	@Test
	@Ignore
	public void excluir() throws Excecoes{
		
		Long codigo = 1L;
		FornecedorDao dao = new FornecedorDao();
		Fornecedor fornecedor = dao.buscarPorId(codigo);
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (fornecedor == null) {
			System.out.println("Nenhum fornecedor encontrado com código " + codigo + "!");
		} else {
			dao.excluir(fornecedor);
			System.out.println("Fornecedor excluído com sucesso!");
			System.out.println(
					"\nRazão Social : " + fornecedor.getRazaoSocial() 
					+ "\nNome Fantasia : " + fornecedor.getNomeFantasia() 
					+ "\nCNPJ : " + fornecedor.getCnpj() 
					+ "\nEmail : " + fornecedor.getEmail() 
					+ "\nInsc. Estadual : " + fornecedor.getInscEstadual()
					+ "\nInsc. Municipal : " + fornecedor.getInscMunicipal() 
					+ "\nData Cadastro : " + dataEHora.format(fornecedor.getDataCadastrado()) 
					+ "\nData Fundação  : " + data.format(fornecedor.getDataFundacao()));
			System.out.println("-----------------------------------------------------------------");
		}
	}
	
}
