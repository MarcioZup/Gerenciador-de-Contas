package br.com.zup.gerenciador_de_contas.contas.repository;

import br.com.zup.gerenciador_de_contas.contas.models.Conta;
import org.springframework.data.repository.CrudRepository;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

}
