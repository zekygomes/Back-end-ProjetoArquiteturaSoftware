package com.diskrango.models.dao;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Entregador;
/**
 * 
 * @author Zeky and Maurício
 *
 */
@Repository
@Transactional
public class EntregadorDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Entregador entregador) {
    getSession().save(entregador);
  }
  
  public void apagar(Entregador entregador) {
    getSession().delete(entregador);
  }
  
  public void apagar(Long idEntregador) {
	    getSession().delete(idEntregador);
	  }
  
  @SuppressWarnings("unchecked")
  public List<Entregador> getAll() {
    return getSession().createQuery("from entregador").list();
  }
  
  public Entregador getByPlacaVeiculo(String placaVeiculo) {
    return (Entregador) getSession().createQuery(
        "from entregador where placaVeiculo = :placaVeiculo")
        .setParameter("placaVeiculo", placaVeiculo)
        .uniqueResult();
  }

  public Entregador getById(Long id) {
    return getSession().load(Entregador.class, id);
  }

  public void update(Entregador entregador) {
    getSession().update(entregador);
  }

}
