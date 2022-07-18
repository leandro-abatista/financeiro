package br.com.ats.financeiro.util;

import java.sql.Connection;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

	private static final SessionFactory SESSION_FACTORY = criarFabricaDeSessoes();

	private static SessionFactory criarFabricaDeSessoes() {
		try {
			Configuration configuracao = new Configuration().configure();
			ServiceRegistry servicoDeRegistro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties())
					.build();
			SessionFactory sessionFactory = configuracao.buildSessionFactory(servicoDeRegistro);
			
			return sessionFactory;
		} catch (Throwable erro) {
			throw new ExceptionInInitializerError("Erro ao tentar criar a fábrica de sessão! "
					+ "\nNão foi possível criar conexão com o banco de dados." + erro.getMessage());
		}
	}
	
	public static SessionFactory getFabricaDeSessoes() {
		return SESSION_FACTORY;
	}
	
	public static Connection getConexao() {
		Session sessao = SESSION_FACTORY.openSession();
		Connection conexao = sessao.doReturningWork(new ReturningWork<Connection>() {

			public Connection execute(Connection connection) throws SQLException {
				return connection;
			}

			
		});
		return conexao;
	}
	
}
