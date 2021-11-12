package br.com.zup.gerenciador_de_contas.contas.repository;

import br.com.zup.gerenciador_de_contas.contas.models.Conta;
import br.com.zup.gerenciador_de_contas.contas.models.Status;
import br.com.zup.gerenciador_de_contas.contas.models.Tipo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ContaRepository extends CrudRepository<Conta, Integer> {

    List<Conta> findAllByStatus(Status status);

    List<Conta> findAllByTipo(Tipo tipo);
}
