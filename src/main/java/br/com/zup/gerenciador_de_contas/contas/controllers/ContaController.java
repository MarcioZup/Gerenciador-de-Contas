package br.com.zup.gerenciador_de_contas.contas.controllers;

import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDto;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDtoResposta;
import br.com.zup.gerenciador_de_contas.contas.models.Conta;
import br.com.zup.gerenciador_de_contas.contas.services.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;


@PostMapping
@ResponseStatus(HttpStatus.CREATED)
public ContaDtoResposta criarCadastro(@RequestBody ContaDto contaDto){
    Conta conta = modelMapper.map(contaDto, Conta.class);
    contaService.salvarConta(conta);
    ContaDtoResposta contaDtoResposta = modelMapper.map(conta, ContaDtoResposta.class);
    return contaDtoResposta;
}

}
