package br.com.zup.gerenciador_de_contas.contas.services;

import br.com.zup.gerenciador_de_contas.contas.models.Conta;
import br.com.zup.gerenciador_de_contas.contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        return contaRepository.save(conta);
    }

}
