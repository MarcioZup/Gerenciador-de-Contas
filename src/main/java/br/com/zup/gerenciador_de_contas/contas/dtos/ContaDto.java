package br.com.zup.gerenciador_de_contas.contas.dtos;

import br.com.zup.gerenciador_de_contas.contas.models.Tipo;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

public class ContaDto {

    @NotBlank
    @Size(min = 2, max = 200, message = "Minimo de dois e máximo de duzentos caracteres no nome")
    private String nome;
    @DecimalMin(value = "0.01", message = "Valor tem que ser maior que zero" )
    private double valor;
    private Tipo tipo;
    @NotNull(message = "Campo não pode ser nulo")
    private LocalDate dataDeVencimento;


    public ContaDto() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public LocalDate getDataDeVencimento() {
        return dataDeVencimento;
    }

    public void setDataDeVencimento(LocalDate dataDeVencimento) {
        this.dataDeVencimento = dataDeVencimento;
    }
}
