package br.com.padrao.builder;

public interface PizzaBuilder {

    PizzaBuilder tamanho(Tamanho tamanho);

    PizzaBuilder massa(String massa);

    PizzaBuilder bordaRecheada(boolean bordaRecheada);

    PizzaBuilder ingrediente(String ingrediente);

    Pizza build();
}
