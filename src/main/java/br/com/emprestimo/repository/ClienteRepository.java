package br.com.emprestimo.repository;


import org.springframework.data.repository.CrudRepository;

import br.com.emprestimo.model.ClienteModel;

public interface ClienteRepository extends CrudRepository<ClienteModel, Integer> {

}
