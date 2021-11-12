package br.com.zup.gerenciador_de_contas.contas.controllers;

import br.com.zup.gerenciador_de_contas.contas.exceptions.ContaNaoExisteException;
import br.com.zup.gerenciador_de_contas.contas.exceptions.ErroAtualizarStatusPago;
import br.com.zup.gerenciador_de_contas.contas.exceptions.MensagemDeErro;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public List<MensagemDeErro> manipularExcecoesDeValidacao(MethodArgumentNotValidException exception){

        List<MensagemDeErro> mensagens = new ArrayList<>();

        for (FieldError fieldError : exception.getFieldErrors()){
            mensagens.add(new MensagemDeErro(fieldError.getDefaultMessage()));
        }

        return mensagens;
    }

    @ExceptionHandler(ErroAtualizarStatusPago.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro erroAtualizarStatusPago(ErroAtualizarStatusPago erroAtualizarStatusPago){
        return new MensagemDeErro(erroAtualizarStatusPago.getMessage());
    }

    @ExceptionHandler(ContaNaoExisteException.class)
    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    public MensagemDeErro contaNaoExisteException(ContaNaoExisteException contaNaoExisteException){
        return new MensagemDeErro(contaNaoExisteException.getMessage());
    }

}
