package br.com.padrao.builder;

import java.util.List;

public class Pizza {

    private final Tamanho tamanho;
    private final String massa;
    private final boolean bordaRecheada;
    private final List<String> ingredientes;

    Pizza(Tamanho tamanho, String massa, boolean bordaRecheada, List<String> ingredientes) {
        this.tamanho = tamanho;
        this.massa = massa;
        this.bordaRecheada = bordaRecheada;
        this.ingredientes = List.copyOf(ingredientes);
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public String getMassa() {
        return massa;
    }

    public boolean isBordaRecheada() {
        return bordaRecheada;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }
}
