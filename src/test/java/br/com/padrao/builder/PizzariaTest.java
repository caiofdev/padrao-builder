package br.com.padrao.builder;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzariaTest {

    private final Pizzaria pizzaria = new Pizzaria();

    @Test
    void prepararMargheritaDeveMontarPizzaMargherita() {
        Pizza pizza = pizzaria.prepararMargherita(new PizzaArtesanalBuilder());

        assertEquals(Tamanho.MEDIA, pizza.getTamanho());
        assertEquals("tradicional", pizza.getMassa());
        assertFalse(pizza.isBordaRecheada());
        assertEquals(List.of("molho de tomate", "mussarela", "manjericão"), pizza.getIngredientes());
    }

    @Test
    void prepararCalabresaDeveMontarPizzaCalabresa() {
        Pizza pizza = pizzaria.prepararCalabresa(new PizzaArtesanalBuilder());

        assertEquals(Tamanho.GRANDE, pizza.getTamanho());
        assertEquals("fina", pizza.getMassa());
        assertTrue(pizza.isBordaRecheada());
        assertEquals(List.of("calabresa", "cebola"), pizza.getIngredientes());
    }
}
