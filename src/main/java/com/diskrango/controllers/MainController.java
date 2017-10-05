package com.diskrango.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
	
  @RequestMapping("/api/")
  @ResponseBody
  public TesteRest index(String nome, String sobrenome) {
    return new TesteRest(nome, sobrenome);
  }

}

class TesteRest{
	private String nome;
	private String sobrenome;
	
	TesteRest(String nome, String sobrenome){
		this.setNome(nome);
		this.setSobrenome(sobrenome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
}