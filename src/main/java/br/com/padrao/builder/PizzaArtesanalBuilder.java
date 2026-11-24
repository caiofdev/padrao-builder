package br.com.padrao.builder;

import java.util.ArrayList;
import java.util.List;

public class PizzaArtesanalBuilder implements PizzaBuilder {

    private Tamanho tamanho;
    private String massa = "tradicional";
    private boolean bordaRecheada;
    private final List<String> ingredientes = new ArrayList<>();

    @Override
    public PizzaBuilder tamanho(Tamanho tamanho) {
        if (tamanho == null) {
            throw new IllegalArgumentException("Tamanho é obrigatório");
        }
        this.tamanho = tamanho;
        return this;
    }

    @Override
    public PizzaBuilder massa(String massa) {
        if (massa == null || massa.isBlank()) {
            throw new IllegalArgumentException("Massa inválida");
        }
        this.massa = massa;
        return this;
    }

    @Override
    public PizzaBuilder bordaRecheada(boolean bordaRecheada) {
        this.bordaRecheada = bordaRecheada;
        return this;
    }

    @Override
    public PizzaBuilder ingrediente(String ingrediente) {
        if (ingrediente == null || ingrediente.isBlank()) {
            throw new IllegalArgumentException("Ingrediente inválido");
        }
        ingredientes.add(ingrediente);
        return this;
    }

    @Override
    public Pizza build() {
        if (tamanho == null) {
            throw new IllegalStateException("Defina o tamanho da pizza");
        }
        if (ingredientes.isEmpty()) {
            throw new IllegalStateException("A pizza precisa de pelo menos um ingrediente");
        }
        return new Pizza(tamanho, massa, bordaRecheada, ingredientes);
    }
}
