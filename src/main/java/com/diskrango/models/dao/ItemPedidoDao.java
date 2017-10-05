package com.diskrango.models.dao;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.diskrango.models.ItemPedido;
/**
 * 
 * @author Zeky and Maurício
 *
 */
@Repository
@Transactional
public class ItemPedidoDao {
  
  @Autowired
  private SessionFactory _sessionFactory;
  
  private Session getSession() {
    return _sessionFactory.getCurrentSession();
  }

  public void salvar(ItemPedido itemPedido) {
    getSession().save(itemPedido);
  }
  
  public void salvar (List<ItemPedido> itensPedido){
  	for(ItemPedido item: itensPedido){
  		salvar(item);
  	}
  }

 
  public void apagar(ItemPedido itemPedido) {
    getSession().delete(itemPedido);
  }
  
  public void apagar(Long id_itenspedido) {
	  
	    apagar(getById(id_itenspedido));
	  }
  
  @SuppressWarnings("unchecked")
  public List<ItemPedido> getAll() {
	  List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	  itensPedido = getSession().createQuery("from Pedido").list();
    return itensPedido;
  }
  
  @SuppressWarnings("unchecked")
  public List<ItemPedido> getByPedido(Long idPedido) {
	  List<ItemPedido> itensPedido = new ArrayList<ItemPedido>();
	  itensPedido = getSession().createQuery("from ItemPedido where pedido =:idPedido")
			  .setParameter("idPedido", idPedido).list();
    return itensPedido;
  }
  
  public ItemPedido getById(Long idItemPedido) {
    return (ItemPedido) getSession().load(ItemPedido.class, idItemPedido);
  }

  public void update(ItemPedido itemPedido) {
    getSession().update(itemPedido);
  }

}