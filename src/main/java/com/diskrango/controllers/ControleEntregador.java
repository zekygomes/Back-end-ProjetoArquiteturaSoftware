package com.diskrango.controllers;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Entregador;
import com.diskrango.models.dao.EntregadorDao;
/**
 * 
 * @author Zeky and Maurício
 *
 */
@RestController
@RequestMapping(value="/api/entregador")
public class ControleEntregador {

	
  @Autowired
  private EntregadorDao _entregadorDao;
  

  @RequestMapping(value="/salvar")
  public String salvar(Long idEntregador, String nome, String placaVeiculo) {
    try {
    	Entregador entregador = new Entregador(idEntregador, nome, placaVeiculo);
      _entregadorDao.salvar(entregador);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Entregador salvo com sucesso!";
  }
  

  @RequestMapping(value="/atualizar")
  public String salvar(Entregador entregador) {
    try {
      _entregadorDao.update(entregador);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Entregador atualizador com sucesso!";
  }
  
  @RequestMapping(value="/pegar-todos")
  public ArrayList<Entregador> getAll() {
 
	  List<Entregador> entregador = new ArrayList<Entregador>();
    try {
    	entregador = _entregadorDao.getAll();
    	//result.toJSONString(clientes);
    }
    catch(Exception ex) {
      ex.getMessage();
    }
    return (ArrayList<Entregador>) entregador;
  }

  
  @RequestMapping(value="/apagar")
  public String delete(Long idEntregador) {
    try {
    	//Entregador entregador = new Entregador(id);
      _entregadorDao.apagar(idEntregador);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Entregador apagado com sucesso!";
  }


}