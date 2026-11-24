package br.com.padrao.builder;

public class Pizzaria {

    public Pizza prepararMargherita(PizzaBuilder builder) {
        return builder
                .tamanho(Tamanho.MEDIA)
                .ingrediente("molho de tomate")
                .ingrediente("mussarela")
                .ingrediente("manjericão")
                .build();
    }

    public Pizza prepararCalabresa(PizzaBuilder builder) {
        return builder
                .tamanho(Tamanho.GRANDE)
                .massa("fina")
                .bordaRecheada(true)
                .ingrediente("calabresa")
                .ingrediente("cebola")
                .build();
    }
}
