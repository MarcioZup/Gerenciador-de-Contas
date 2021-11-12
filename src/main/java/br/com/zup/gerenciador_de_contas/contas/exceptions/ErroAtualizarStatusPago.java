package br.com.zup.gerenciador_de_contas.contas.exceptions;

public class ErroAtualizarStatusPago extends RuntimeException {

    public ErroAtualizarStatusPago(String message) {
        super(message);
    }
}
