package br.com.igor.projetosenai.controller;



import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

	
// pagina inicial
		@GetMapping("/inicio")
		public String paginaInicial() {
			return "index.html";
		}


//pagina da lista
		@GetMapping("/lista")
		 public String listaDespesas(Model model) {
	        List<Despesas> despesas = repositorio.findAll();
	        model.addAttribute("despesas", despesas);

	        // Calcular o valor total das despesas
	        double valorTotal = despesas.stream().mapToDouble(Despesas::getValor).sum();
	        model.addAttribute("valorTotal", valorTotal);

	        return "lista";	
		}		
	
	
	
	
// pagina de cadastro
	@GetMapping("/cadastroDespesa")
	public String cadastrar() {
		return "cadastro.html";
	}
	
	
	
//metodo para cadastrar despesa	
		@PostMapping("/cadastrarDespesa")
		public String cadastraProduto(Despesas despesas,
				BindingResult result, Model model) 
{
			if(result.hasErrors()) {
			return "/cadastro.html";
		}
			repositorio.save(despesas);
			return "redirect:/cadastroDespesa";
	}
//	
		
		
		
//metodo p EDITAR listar despesas
	@GetMapping("/editarListaDespesas")
	public String listaDesepesas(Model model) {
		List<Despesas> despesas = repositorio.findAll();
		model.addAttribute("despesas", despesas);
		return "editarLista";
	}
//
	
	
//metodo atualizar
	@PostMapping("/atualizar/{id}")
	public String atualizaDespesao(@PathVariable("id")
	 long id, @Valid Despesas despesas, BindingResult result, Model model
			) {
		if(result.hasErrors()) {
			despesas.setId(id);
			return "editar_despesa";
		}
		repositorio.save(despesas);
		return "redirect:/editarListaDespesas";
	}
//
	
	
//metodo para salvar
	@PostMapping
	public void salvar(Despesas despesas) {
		repositorio.save(despesas);
	}
//
	
	
	
//metodo para editar
	@GetMapping("/editar/{id}")
	public String editarDespesa(
			@PathVariable ("id") long id, Model model) {
		Despesas despesas = repositorio.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Identificador não é válido" + id));
			model.addAttribute("despesas", despesas);
		return "editar_despesa";
	}
//	
	
	
	
//metodo para excluir
	@GetMapping("/deletar/{id}")
	public String deletarDespesa(
			@PathVariable("id") long id, Model model) {
		Despesas despesas = repositorio.findById(id)
			.orElseThrow(() -> new IllegalArgumentException("Identificador não é válido" + id));
			repositorio.delete(despesas);
		return "redirect:/editarListaDespesas";
}
//
		


	
}




