package br.com.ats.financeiro.dao.testes;

import javax.transaction.SystemException;

import org.junit.Test;

import br.com.ats.financeiro.classes.Usuario;
import br.com.ats.financeiro.dao.UsuarioDao;
import br.com.ats.financeiro.exceptions.Excecoes;

public class UsuarioDaoTeste {

	@Test
	public void salvarUsuario() throws Exception, Excecoes, SystemException {
		
		Usuario usuario = new Usuario();
		usuario.setNome("Leandro");
		usuario.setSobrenome("teste rufino");
		usuario.setCpf("123");
		usuario.setEmail("leandro@teste.com");
		usuario.setLogin("leandro");
		usuario.setSenha("123");
		
		UsuarioDao usuarioDao = new UsuarioDao();
		usuarioDao.salvar(usuario);
		System.out.println("Usuário salvo com sucesso!");
	}
}
