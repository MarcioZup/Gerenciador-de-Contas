package br.com.zup.gerenciador_de_contas.contas.controllers;

import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDto;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDtoList;
import br.com.zup.gerenciador_de_contas.contas.dtos.ContaDtoResposta;
import br.com.zup.gerenciador_de_contas.contas.models.Conta;
import br.com.zup.gerenciador_de_contas.contas.services.ContaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;


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
    public ContaDto atualizarStatus(@PathVariable int id, @RequestBody ContaDto contaDto){
        Conta conta = contaService.atualizarConta(id);

        return conta;
    }

}
