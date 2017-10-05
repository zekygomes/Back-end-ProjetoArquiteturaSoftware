package com.diskrango.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Cliente;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * <h1>Cliente DAO</h1>
 * Classe que representa o Objeto de Acesso a Dados (DAO em inglês) da entidade Cliente.
 * 
 * <p>
 * Executa os métodos Salvar; getAll; delete; getByName; getById; update.
 * 
 * @author Zeky and Maurício
 *
 */
@Repository
@Transactional
public class ClienteDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Cliente cliente) {
    getSession().save(cliente);
  }
  
  public void delete(Cliente cliente) {
    getSession().delete(cliente);
  }

  @SuppressWarnings("unchecked")
  public List<Cliente> getAll() {
	  List<Cliente> clientes = new ArrayList<Cliente>();
	  clientes = getSession().createQuery("from Cliente").list();
    return clientes;
  }
  
  public Cliente getByName(String nome) {
	Cliente cliente = (Cliente) getSession().createQuery(
	        "from Cliente where nome = :nome")
	        .setParameter("nome", nome)
	        .uniqueResult();
    return cliente;
  }

  public Cliente getById(Long id) {
    return (Cliente) getSession().get(Cliente.class, id);
  }

  public void update(Cliente cliente) {
    getSession().update(cliente);
  }

}
