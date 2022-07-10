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
		usuario.setNome("marilia");
		usuario.setSobrenome("janeiro brasil");
		usuario.setCpf("22222222222");
		usuario.setEmail("marilia@gmail.com");
		usuario.setLogin("mari");
		usuario.setSenha("sa45a5s");
		
		Usuario usuario2 = new Usuario();
		usuario2.setNome("eduardo");
		usuario2.setSobrenome("bones ceza");
		usuario2.setCpf("33355566655");
		usuario2.setEmail("eduardo@hotmail.com");
		usuario2.setLogin("eduardo");
		usuario2.setSenha("555ssd");
		
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
	
	@Test
	@Ignore
	public void excluir() throws Excecoes {
		
		Long codigo = 7L;
		UsuarioDao usuarioDao = new UsuarioDao();
		Usuario usuario = usuarioDao.buscarPorId(codigo);
		
		if (usuario == null) {
			System.out.println("Usuário não encontrado com o ID informado!");
		} else {
			usuarioDao.excluir(usuario);
			System.out.println("Registro removido : " + usuario.getId());
			System.out.println("ID : " + usuario.getId()
			+ " Nome : " + usuario.getNome()
			+ " CPF : " + usuario.getCpf());
		}
	}
	
}
