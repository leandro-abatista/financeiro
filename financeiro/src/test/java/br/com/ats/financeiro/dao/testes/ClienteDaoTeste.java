package br.com.ats.financeiro.dao.testes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.transaction.SystemException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ats.financeiro.classes.Cliente;
import br.com.ats.financeiro.dao.ClienteDao;
import br.com.ats.financeiro.exceptions.Excecoes;

public class ClienteDaoTeste {
	
	@Test
	@Ignore
	public void salvar() throws Excecoes, ParseException, IllegalStateException, SystemException {
		
		Cliente cliente = new Cliente();
		cliente.setNome("genilson");
		cliente.setSobrenome("parede");
		cliente.setCpf("545.455.244-22");
		cliente.setEmail("genilson@gamil.com");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		cliente.setDataNascimento(sdf.parse("22-07-1990"));
		cliente.setRg("12345645");
		cliente.setOrgaoExpeditor("sds/pb");
		
		ClienteDao dao = new ClienteDao();
		dao.salvar(cliente);
		System.out.println("Cliente salvo com sucesso!");
	}

	@Test
	@Ignore
	public void merge() throws Excecoes, ParseException {
		
		Cliente cliente = new Cliente();
		cliente.setNome("marlison");
		cliente.setSobrenome("candeia");
		cliente.setCpf("323.525.555-22");
		cliente.setEmail("marlison@gamil.com");
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		cliente.setDataNascimento(sdf.parse("22-07-1990"));
		cliente.setRg("22233355");
		cliente.setOrgaoExpeditor("sds/pb");
		
		ClienteDao dao = new ClienteDao();
		dao.merge(cliente);
		System.out.println("Cliente salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void listarClientes() throws Excecoes {
		
		ClienteDao dao = new ClienteDao();
		List<Cliente> clientes =  dao.listar();
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		System.out.println("Total de registros encontrados :: " + clientes.size());
		System.out.println();
		for (Cliente cliente : clientes) {
			System.out.println("\n- Nome : " + cliente.getNome() + " "+ cliente.getSobrenome()
			+ "\n- CPF : "+ cliente.getCpf()
			+ "\n- RG : "+ cliente.getRg() +  " - Org. Expeditor : "+ cliente.getOrgaoExpeditor()
			+ "\n- E-mail : "+ cliente.getEmail()
			+ "\n- Data Nascimento : "+ data.format(cliente.getDataNascimento())
			+ "\n- Data Cadastro : "+ dataEHora.format(cliente.getDataCadastro()));
			System.out.println("------------------------------------------------");
		}
	}
	
	@Test
	@Ignore
	public void buscarPorId() throws Excecoes {
		
		Long codigo = 1L;
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorId(codigo);
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (cliente == null) {
			System.out.println("Nenhum cliente encontrado com o código "+ codigo+"!");
		} else {
			System.out.println("\n- Nome : " + cliente.getNome() + " "+ cliente.getSobrenome()
			+ "\n- CPF : "+ cliente.getCpf()
			+ "\n- RG : "+ cliente.getRg() +  " - Org. Expeditor : "+ cliente.getOrgaoExpeditor()
			+ "\n- E-mail : "+ cliente.getEmail()
			+ "\n- Data Nascimento : "+ data.format(cliente.getDataNascimento())
			+ "\n- Data Cadastro : "+ dataEHora.format(cliente.getDataCadastro()));
			System.out.println("------------------------------------------------");
		}
	}
	
	@Test
	@Ignore
	public void editar() throws Excecoes {
		
		Long codigo = 1L;
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorId(codigo);
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (cliente == null) {
			System.out.println("Nenhum cliente encontrado com o código "+ codigo+"!");
		} else {
			System.out.println("Antes de ser atualizado");
			System.out.println("\n- Nome : " + cliente.getNome() + " "+ cliente.getSobrenome()
			+ "\n- CPF : "+ cliente.getCpf()
			+ "\n- RG : "+ cliente.getRg() +  " - Org. Expeditor : "+ cliente.getOrgaoExpeditor()
			+ "\n- E-mail : "+ cliente.getEmail()
			+ "\n- Data Nascimento : "+ data.format(cliente.getDataNascimento())
			+ "\n- Data Cadastro : "+ dataEHora.format(cliente.getDataCadastro()));
			System.out.println("------------------------------------------------");
			
			cliente.setNome("kessia");
			cliente.setSobrenome("montenegro rosa");
			cliente.setEmail("kessia_123@hotmail.com");
			dao.editar(cliente);
			
			System.out.println("Depois de ser atualizado");
			System.out.println("\n- Nome : " + cliente.getNome() + " "+ cliente.getSobrenome()
			+ "\n- CPF : "+ cliente.getCpf()
			+ "\n- RG : "+ cliente.getRg() +  " - Org. Expeditor : "+ cliente.getOrgaoExpeditor()
			+ "\n- E-mail : "+ cliente.getEmail()
			+ "\n- Data Nascimento : "+ data.format(cliente.getDataNascimento())
			+ "\n- Data Cadastro : "+ dataEHora.format(cliente.getDataCadastro()));
			System.out.println("------------------------------------------------");
		}
	}
	
	@Test
	@Ignore
	public void excluir() throws Excecoes {
		
		Long codigo = 5L;
		ClienteDao dao = new ClienteDao();
		Cliente cliente = dao.buscarPorId(codigo);
		
		SimpleDateFormat data = new SimpleDateFormat("dd-MM-yyyy");
		SimpleDateFormat dataEHora = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
		if (cliente == null) {
			System.out.println("Nenhum cliente encontrado com o código "+ codigo+"!");
		} else {
			dao.excluir(cliente);
			System.out.println("Cliente excluido com sucesso!");
			System.out.println("\n- Nome : " + cliente.getNome() + " "+ cliente.getSobrenome()
			+ "\n- CPF : "+ cliente.getCpf()
			+ "\n- RG : "+ cliente.getRg() +  " - Org. Expeditor : "+ cliente.getOrgaoExpeditor()
			+ "\n- E-mail : "+ cliente.getEmail()
			+ "\n- Data Nascimento : "+ data.format(cliente.getDataNascimento())
			+ "\n- Data Cadastro : "+ dataEHora.format(cliente.getDataCadastro()));
			System.out.println("------------------------------------------------");
		}
	}
}
