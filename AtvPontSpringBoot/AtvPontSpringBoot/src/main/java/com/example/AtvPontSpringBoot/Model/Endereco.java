package com.example.AtvPontSpringBoot.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Logadouro deve ser preenchido!")
    private String logadouro;
    @NotBlank(message = "Numero deve ser preenchido!")
    private String numero;
    private String complemento;
    @NotBlank(message = "Complemento deve ser preenchido!")
    private String cidade;

    public Endereco() {
    }

    public Endereco(Long id, String logadouro, String numero, String complemento, String cidade) {
        this.id = id;
        this.logadouro = logadouro;
        this.numero = numero;
        this.complemento = complemento;
        this.cidade = cidade;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogadouro() {
        return logadouro;
    }

    public void setLogadouro(String logadouro) {
        this.logadouro = logadouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
}
