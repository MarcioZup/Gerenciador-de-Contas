package br.com.zup.gerenciador_de_contas.contas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContaService {
    @Autowired
    private ContaRepository contaRepository;

}
