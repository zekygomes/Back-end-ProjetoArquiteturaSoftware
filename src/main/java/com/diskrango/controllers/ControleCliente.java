package com.diskrango.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Cliente;
import com.diskrango.models.dao.ClienteDao;
import com.fasterxml.jackson.annotation.JsonIgnore;

@RestController
@RequestMapping(value="/api/cliente")
public class ControleCliente {
	
  @Autowired
  private ClienteDao _clienteDao;
  
  @RequestMapping(value="/salvar")
  public String salvar(Long id, 
		  String nome, 
		  String email,
		  String endereco,
		  String telefone, 
		  String pontoDeReferencia, 
		  String situacao,
		  Integer devolucao) {
    try {
    	Cliente cliente = new Cliente(id, nome, email, endereco, telefone, pontoDeReferencia, situacao, devolucao);
      _clienteDao.salvar(cliente);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Cliente salvo com sucesso!";
  }

  @RequestMapping(value="/pegar-todos")
  public List<Cliente> getAll() {
 
	  List<Cliente> clientes = _clienteDao.getAll();

    return clientes;
  }
  
  @RequestMapping(value="/apagar")
  public String delete(@RequestParam (value="id",required=true)Long id) {
    try {
      Cliente cliente = getById(id);
      _clienteDao.apagar(cliente);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Cliente apagado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-por-nome")
  public Cliente getByName(@RequestParam (value="nome",required=true) String nome) {    
	  try {
		  return _clienteDao.getByName(nome);
	  }
    catch(Exception ex) {
    	System.out.println(ex.getMessage());
        return null;
      }
  }
  
  @RequestMapping(value="/pegar-por-id")
  public Cliente getById(@RequestParam (value="id",required=true) Long id) {    
	
    try {
    	return _clienteDao.getById(id);
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }

  }

}