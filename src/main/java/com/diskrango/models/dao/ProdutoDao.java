package com.diskrango.models.dao;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.Cliente;
import com.diskrango.models.Produto;

@Repository
@Transactional
public class ProdutoDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(Produto produto) {
    getSession().save(produto);
  }
  
  public void apagar(Produto produto) {
    getSession().delete(produto);
  }

  @SuppressWarnings("unchecked")
  public List<Produto> getAll() {
	  List<Produto> produtos = new ArrayList<Produto>();
	  produtos = getSession().createQuery("from Produto").list();
    return produtos;
  }
  
  public Produto getByName(String nome) {
	  Produto produto = (Produto) getSession().createQuery(
	        "from Produto where nome = :nome")
	        .setParameter("nome", nome)
	        .uniqueResult();
    return produto;
  }
  
  public Produto getById(Long codProduto) {
    return (Produto) getSession().load(Produto.class, codProduto);
  }

  public void update(Produto produto) {
    getSession().update(produto);
  }

}
