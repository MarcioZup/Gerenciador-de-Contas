package br.com.zup.gerenciador_de_contas.contas.services;

import br.com.zup.gerenciador_de_contas.contas.models.Conta;
import br.com.zup.gerenciador_de_contas.contas.models.Status;
import br.com.zup.gerenciador_de_contas.contas.repository.ContaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

    public Conta salvarConta(Conta conta) {
        if (conta.getDataDeVencimento().isBefore(LocalDate.now())){
            conta.setStatus(Status.VENCIDA);
            contaRepository.save(conta);
        }else{
            conta.setStatus(Status.AGUARDANDO);
            contaRepository.save(conta);
        }
        return conta;
    }

}
