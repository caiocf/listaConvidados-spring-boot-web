package br.com.caiocf.listvip.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.com.caiocf.listvip.entidades.Convidado;

public interface ConvidadoRepository extends CrudRepository<Convidado, Long> {

	// strips the prefixes find…By, read…By, and get…By
    List<Convidado> findByNomeAllIgnoreCase(String nome);
    
  //SQL => LIKE '%nome%'
    List<Convidado> findByNomeContainingAllIgnoreCase(String nome);
}
