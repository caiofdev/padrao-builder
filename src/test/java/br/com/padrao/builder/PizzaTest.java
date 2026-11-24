package br.com.padrao.builder;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzaTest {

    @Test
    void construtorDeveCopiarListaDeIngredientes() {
        List<String> ingredientes = new ArrayList<>(List.of("mussarela"));
        Pizza pizza = new Pizza(Tamanho.MEDIA, "tradicional", false, ingredientes);

        ingredientes.add("tomate");

        assertEquals(List.of("mussarela"), pizza.getIngredientes());
    }

    @Test
    void getTamanhoDeveRetornarTamanhoInformado() {
        Pizza pizza = new Pizza(Tamanho.GRANDE, "fina", false, List.of("calabresa"));

        assertEquals(Tamanho.GRANDE, pizza.getTamanho());
    }

    @Test
    void getMassaDeveRetornarMassaInformada() {
        Pizza pizza = new Pizza(Tamanho.PEQUENA, "integral", false, List.of("rúcula"));

        assertEquals("integral", pizza.getMassa());
    }

    @Test
    void isBordaRecheadaDeveRetornarValorInformado() {
        Pizza pizza = new Pizza(Tamanho.MEDIA, "tradicional", true, List.of("catupiry"));

        assertTrue(pizza.isBordaRecheada());
    }

    @Test
    void getIngredientesDeveRetornarListaImutavel() {
        Pizza pizza = new Pizza(Tamanho.MEDIA, "tradicional", false, List.of("mussarela"));

        assertThrows(UnsupportedOperationException.class, () -> pizza.getIngredientes().add("bacon"));
    }
}
