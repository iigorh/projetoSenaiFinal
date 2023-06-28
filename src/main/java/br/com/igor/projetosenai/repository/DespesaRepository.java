package br.com.igor.projetosenai.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.igor.projetosenai.model.Despesas;

//AQUI ESTÁ O REPOSITÓRIO PARA PODER SER FEITO AS OPERAÕES DO CRUD


//HERANÇA DO JPA PASSANDO O TIPO DA ENTIDADE E O TIPO DO IDENTIFICADOR
public interface DespesaRepository extends JpaRepository<Despesas, Long>{
	
}
