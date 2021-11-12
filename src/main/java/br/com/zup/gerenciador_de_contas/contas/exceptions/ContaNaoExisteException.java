package br.com.zup.gerenciador_de_contas.contas.exceptions;

public class ContaNaoExisteException extends RuntimeException{
    public ContaNaoExisteException(String message) {
        super(message);
    }
}
