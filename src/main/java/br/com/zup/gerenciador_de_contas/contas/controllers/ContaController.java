package br.com.zup.gerenciador_de_contas.contas.controllers;

import br.com.zup.gerenciador_de_contas.contas.dtos.*;
import br.com.zup.gerenciador_de_contas.contas.exceptions.ErroAtualizarStatusPago;
import br.com.zup.gerenciador_de_contas.contas.models.Conta;
import br.com.zup.gerenciador_de_contas.contas.models.Status;
import br.com.zup.gerenciador_de_contas.contas.services.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/contas")
public class ContaController {
    @Autowired
    private ContaService contaService;
    @Autowired
    private ModelMapper modelMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContaDtoResposta criarCadastro(@RequestBody ContaDto contaDto) {
        Conta conta = modelMapper.map(contaDto, Conta.class);
        contaService.salvarConta(conta);
        ContaDtoResposta contaDtoResposta = modelMapper.map(conta, ContaDtoResposta.class);
        return contaDtoResposta;
    }

    @GetMapping
    public List<ContaDtoList> mostrarTodasContas() {
        List<ContaDtoList> contasDto = new ArrayList<>();
        for (Conta contaReferencia: contaService.mostrarTodasContas()) {
            ContaDtoList contaResposta = modelMapper.map(contaReferencia, ContaDtoList.class);
            contasDto.add(contaResposta);
        }
        return contasDto;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContaDtoResposta atualizarStatus(@PathVariable int id, @RequestBody AtualizarDto atualizarDto){
        Conta conta = contaService.atualizarConta(id);
        if (atualizarDto.getStatus() == Status.PAGO){
            ContaDtoResposta contaDtoResposta = modelMapper.map(conta, ContaDtoResposta.class);
            return contaDtoResposta;
        }
        throw new ErroAtualizarStatusPago("Opção não atualiza para PAGO");
    }

    @GetMapping("/{id}")
    public ContaDtoCompleta exibirContaPorId(@PathVariable int id){
        ContaDtoCompleta contaDtoCompleta = modelMapper.map(contaService.pesquisarContaPorID(id), ContaDtoCompleta.class);
        return contaDtoCompleta;
    }

}
