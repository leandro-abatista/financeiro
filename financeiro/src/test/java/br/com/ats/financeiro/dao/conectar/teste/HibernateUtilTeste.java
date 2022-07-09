package br.com.ats.financeiro.dao.conectar.teste;

import org.hibernate.Session;
import org.junit.Test;

import br.com.ats.financeiro.util.HibernateUtil;

public class HibernateUtilTeste {

	@Test
	public void conectar() {
		Session session = HibernateUtil.getFabricaDeSessoes().openSession();
		session.close();
		HibernateUtil.getFabricaDeSessoes().close();
		System.out.println("Realizado a conexão");
	}
}
