package br.com.zup.gerenciador_de_contas.contas.dtos;

import br.com.zup.gerenciador_de_contas.contas.models.Status;

public class AtualizarDto {

    private Status status;

    public AtualizarDto(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
