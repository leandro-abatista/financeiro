package br.com.ats.financeiro.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.transaction.SystemException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	
	@SuppressWarnings("unchecked")
	public ObjetoEntidade merge(ObjetoEntidade objetoEntidade) throws Excecoes {

		sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			transacao = sessao.beginTransaction();
			ObjetoEntidade retorno = (ObjetoEntidade) sessao.merge(objetoEntidade);
			transacao.commit();
			return retorno;
		} catch (RuntimeException erro) {
			if (transacao != null) {
				transacao.rollback();
			}
			throw new Excecoes(erro.getMessage());
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<ObjetoEntidade> listar() throws Excecoes{
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {
			
			Criteria consulta = sessao.createCriteria(classeObjeto);
			List<ObjetoEntidade> resultado = consulta.list();
			return resultado;
			
		} catch (RuntimeException erro) {
			throw new Excecoes(erro.getMessage());
		} finally {
			sessao.close();
		}
	}
	
	@SuppressWarnings("unchecked")
	public ObjetoEntidade buscarPorId(Long id) throws Excecoes {
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();
		
		try {

			Criteria consulta = sessao.createCriteria(classeObjeto);
			ObjetoEntidade objetoEntidade = (ObjetoEntidade) consulta.add(Restrictions.idEq(id)).uniqueResult();;
			return objetoEntidade;

		} catch (RuntimeException erro) {
			throw new Excecoes(erro.getMessage());
		} finally {
			sessao.close();
		}
	}
	
	public void excluir(ObjetoEntidade objetoEntidade) throws Excecoes {
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {
			
			transacao = sessao.beginTransaction();
			sessao.delete(objetoEntidade);
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
	
	public void editar(ObjetoEntidade objetoEntidade) throws Excecoes {
		
		sessao = HibernateUtil.getFabricaDeSessoes().openSession();

		try {

			transacao = sessao.beginTransaction();
			sessao.update(objetoEntidade);
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
