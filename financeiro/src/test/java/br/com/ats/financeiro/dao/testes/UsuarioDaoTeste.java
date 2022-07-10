package br.com.ats.financeiro.dao.testes;

import java.util.List;

import javax.transaction.SystemException;

import org.junit.Ignore;
import org.junit.Test;

import br.com.ats.financeiro.classes.Usuario;
import br.com.ats.financeiro.dao.UsuarioDao;
import br.com.ats.financeiro.exceptions.Excecoes;

public class UsuarioDaoTeste {

	@Test
	@Ignore
	public void salvarUsuario() throws Exception, Excecoes, SystemException {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Alexandre");
		usuario.setSobrenome("neto teste");
		usuario.setCpf("456123789");
		usuario.setEmail("alexandre@teste.com");
		usuario.setLogin("alexandre");
		usuario.setSenha("456");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);
		System.out.println("Usuário salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void merge() throws Excecoes {
		
		Usuario usuario = new Usuario();
		usuario.setNome("marcos");
		usuario.setSobrenome("outubro franco");
		usuario.setCpf("13245679812");
		usuario.setEmail("marcos@teste.com");
		usuario.setLogin("marcos");
		usuario.setSenha("4d5s5s");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("leticia");
		usuario2.setSobrenome("fidelis nobre");
		usuario2.setCpf("55544411111");
		usuario2.setEmail("leticia@teste.com");
		usuario2.setLogin("leticia");
		usuario2.setSenha("asa121");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.merge(usuario);
		usuarioDao.merge(usuario2);
		System.out.println("Usuário salvo com sucesso!");
	}
	
	@Test
	@Ignore
	public void lista() throws Excecoes{
		
		UsuarioDao usuarioDao = new UsuarioDao();
		List<Usuario> usuarios = usuarioDao.listar();
		System.out.println("Total de registros encontrados :: " + usuarios.size());
		
		for (Usuario usuario : usuarios) {
			System.out.println("ID : " + usuario.getId()
								+ " Nome : " + usuario.getNome()
								+ " CPF : " + usuario.getCpf());
		}
	}
}
