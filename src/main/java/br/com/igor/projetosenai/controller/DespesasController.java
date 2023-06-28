package br.com.igor.projetosenai.controller;



import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import br.com.igor.projetosenai.model.Despesas;
import br.com.igor.projetosenai.repository.DespesaRepository;





//ESTA CLASSE É A RESPONSÁVEL POR GERENCIAR AS REQUISIÇÕES


@Controller
public class DespesasController {
	
//OBJETO C OPERAÇÕES PARA MANIPULAR OS DADOS NO BD
	
	//essa anotação cria o objeto e injeta no atributo e cuida dele 'repositorio'
	@Autowired
	private DespesaRepository repositorio;
	
	
	// pagina de lista
	@GetMapping("/lista")
	public String listaDespesas() {
		return "lista.html";
	}
	
	// pagina de cadastro
	@GetMapping("/cadastroDespesa")
	public String cadastrar() {
		return "cadastro.html";
	}
	
	
//metodo para cadastrar despesa	
		@PostMapping("/cadastrarDespesa")
		public String cadastraProduto(Despesas despesas,
				BindingResult result, Model model) {
			if(result.hasErrors()) {
			return "/cadastro.html";
		}
			repositorio.save(despesas);
			return "redirect:/lista";
	}
//	
	
		
//metodo de consultar/listar despesas
	@GetMapping("/despesa")
	public String listaDesepesas(Model model) {
		List<Despesas> despesas = repositorio.findAll();
		model.addAttribute("despesas", despesas);
		return "lista";
	}
//
	
	
	
	
//metodo para salvar
	@PostMapping
	public void salvar(Despesas despesas) {
		repositorio.save(despesas);
	}
//
	
	
//metodo para editar
	@PutMapping
	public void editar(Despesas despesas) {
		if(despesas.getId()>0)
		repositorio.save(despesas);
		}
//	
	
	
	
//metodo para excluir
	@DeleteMapping
	public void excluir(Despesas despesas) {
		repositorio.delete(despesas);
		}
//
		


	
}




