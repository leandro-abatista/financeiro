package br.com.ats.financeiro.dao;

import java.lang.reflect.ParameterizedType;

import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.ats.financeiro.exceptions.Excecoes;
import br.com.ats.financeiro.util.HibernateUtil;

public class GenericDao<ObjetoEntidade> {

	private Session sessao = null;
	private Transaction transacao = null;
	private Class<ObjetoEntidade> classeObjeto;
	
	/**
	 * Construtor 
	 */
	@SuppressWarnings("unchecked")
	public GenericDao() {
		this.classeObjeto = 
				(Class<ObjetoEntidade>) ((ParameterizedType) 
						getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	public void salvar(ObjetoEntidade objetoEntidade) throws Excecoes, IllegalStateException, SystemException {
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			
			transacao = sessao.beginTransaction();
			sessao.save(objetoEntidade);
			transacao.commit();
			
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw new Excecoes(erro.getMessage());
		} finally {
			sessao.close();
		}
	}
}
