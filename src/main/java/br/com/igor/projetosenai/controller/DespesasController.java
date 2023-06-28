package br.com.igor.projetosenai.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import br.com.igor.projetosenai.model.Despesas;
import br.com.igor.projetosenai.repository.DespesaRepository;


//ESTA CLASSE É A RESPONSÁVEL POR GERENCIAR AS REQUISIÇÕES


@Controller
public class DespesasController {
	
//OBJETO C OPERAÇÕES PARA MANIPULAR OS DADOS NO BD
	
	//essa anotação cria o objeto e injeta no atributo e cuida dele 'repositorio'
	@Autowired
	private DespesaRepository repositorio;
	
	//metodo listar
	

	
	
	
	
	
	
	@GetMapping("/")
	public String paginaInicial() {
		return "index.html";
	}
	
	@GetMapping("/cadastro")
	public String cadastrar() {
		return "cadastro.html";
	}

	@PostMapping("/cadastro")
	public void cadastraProduto (Despesas despesas) {
		System.out.println("Dinheiro gasto com: " + despesas.getNome());
		
	}
	
	
}




