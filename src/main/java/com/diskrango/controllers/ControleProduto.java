package com.diskrango.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diskrango.models.Cliente;
import com.diskrango.models.Produto;
import com.diskrango.models.dao.ItemPedidoDao;
import com.diskrango.models.dao.ProdutoDao;
import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 
 * @author Zeky and Maurício
 *
 */
@RestController
@RequestMapping(value="/api/produto")
public class ControleProduto {
	
  @Autowired
  private ProdutoDao _produtoDao;
  @Autowired
  private ItemPedidoDao _itemPedidoDao;

  @RequestMapping(value="/salvar")
  public String salvar(Long codProduto, String nome, String precoProduto,String qntEstoque, String tipoProduto) {
    try {
    	Produto produto = new Produto(codProduto, nome, precoProduto, qntEstoque, tipoProduto);
      _produtoDao.salvar(produto);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Produto salvo com sucesso!";
  }
  @JsonIgnore
  @RequestMapping(value="/pegar-todos")
  public List<Produto> getAll() {
 
	  List<Produto> produtos = _produtoDao.getAll();

    return produtos;
  }
  
  @RequestMapping(value="/pegar-refeicoes")
  public List<Produto> getRefeicoes() {
	  List<Produto> produtos =_produtoDao.getAll();
	  List<Produto> result = new ArrayList<Produto>();
	  for(Produto produto: produtos){
		  if(produto.getTipo_produto().equals("Refeição")){
			  result.add(produto);
		  }
	  }
    return result;
  }
  
  @RequestMapping(value="/pegar-sobremesas")
  public List<Produto> getSobremesas() {
	  List<Produto> produtos =_produtoDao.getAll();
	  List<Produto> result = new ArrayList<Produto>();
	  for(Produto produto: produtos){
		  if(produto.getTipo_produto().equals("Sobremesa")){
			  result.add(produto);
		  }
	  }
    return result;
  }
  
  @RequestMapping(value="/pegar-bebidas")
  public List<Produto> getBebidas() {
	  List<Produto> produtos =_produtoDao.getAll();
	  List<Produto> result = new ArrayList<Produto>();
	  for(Produto produto: produtos){
		  if(produto.getTipo_produto().equals("Bebida")){
			  result.add(produto);
		  }
	  }
    return result;
  }

  
  @RequestMapping(value="/apagar")
  public String delete(@RequestParam (value="codProduto",required=true)Long codProduto) {
    try {
      Produto produto = getById(codProduto);
      _produtoDao.apagar(produto);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Produto apagado com sucesso!";
  }
  
  @RequestMapping(value="/pegar-por-nome")
  public Produto getByName(@RequestParam (value="nome",required=true) String nome) {    
	  try {
		  return _produtoDao.getByName(nome);
	  }
    catch(Exception ex) {
    	System.out.println(ex.getMessage());
        return null;
      }
  }
  
  @RequestMapping(value="/pegar-por-id")
  public Produto getById(@RequestParam (value="codProduto",required=true) Long codProduto) {    
	
    try {
    	return _produtoDao.getById(codProduto);
    }
    catch(Exception ex) {
      System.out.println(ex.getMessage());
      return null;
    }
  }
  
  @RequestMapping(value="/atualizarEstoque")
  public String atualizar(@RequestParam (value="codProduto",required=true)Long codProduto, @RequestParam (value="qntEstoque",required=true)String qntEstoque) {
    try {
    	Produto produto = getById(codProduto);
    	produto.atualizarEstoque(produto, qntEstoque);
      _produtoDao.update(produto);
    }
    catch(Exception ex) {
      return ex.getMessage();
    }
    return "Produto atualizado com sucesso!";
  }
  

}