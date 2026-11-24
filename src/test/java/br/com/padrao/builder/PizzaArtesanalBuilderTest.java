package br.com.padrao.builder;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PizzaArtesanalBuilderTest {

    private PizzaArtesanalBuilder builder;

    @BeforeEach
    void setUp() {
        builder = new PizzaArtesanalBuilder();
    }

    @Test
    void tamanhoDeveLancarExcecaoQuandoNulo() {
        assertThrows(IllegalArgumentException.class, () -> builder.tamanho(null));
    }

    @Test
    void tamanhoDeveDefinirValorQuandoValido() {
        Pizza pizza = builder.tamanho(Tamanho.PEQUENA).ingrediente("mussarela").build();

        assertEquals(Tamanho.PEQUENA, pizza.getTamanho());
    }

    @Test
    void massaDeveLancarExcecaoQuandoNula() {
        assertThrows(IllegalArgumentException.class, () -> builder.massa(null));
    }

    @Test
    void massaDeveLancarExcecaoQuandoEmBranco() {
        assertThrows(IllegalArgumentException.class, () -> builder.massa("   "));
    }

    @Test
    void massaDeveDefinirValorQuandoValida() {
        Pizza pizza = builder.tamanho(Tamanho.MEDIA).massa("fina").ingrediente("mussarela").build();

        assertEquals("fina", pizza.getMassa());
    }

    @Test
    void bordaRecheadaDeveDefinirValorERetornarOProprioBuilder() {
        PizzaBuilder retorno = builder.bordaRecheada(true);
        Pizza pizza = builder.tamanho(Tamanho.MEDIA).ingrediente("catupiry").build();

        assertSame(builder, retorno);
        assertTrue(pizza.isBordaRecheada());
    }

    @Test
    void ingredienteDeveLancarExcecaoQuandoNulo() {
        assertThrows(IllegalArgumentException.class, () -> builder.ingrediente(null));
    }

    @Test
    void ingredienteDeveLancarExcecaoQuandoEmBranco() {
        assertThrows(IllegalArgumentException.class, () -> builder.ingrediente(""));
    }

    @Test
    void ingredienteDeveAdicionarQuandoValido() {
        Pizza pizza = builder.tamanho(Tamanho.MEDIA).ingrediente("tomate").ingrediente("queijo").build();

        assertEquals(List.of("tomate", "queijo"), pizza.getIngredientes());
    }

    @Test
    void buildDeveLancarExcecaoQuandoTamanhoNaoDefinido() {
        builder.ingrediente("mussarela");

        assertThrows(IllegalStateException.class, () -> builder.build());
    }

    @Test
    void buildDeveLancarExcecaoQuandoSemIngredientes() {
        builder.tamanho(Tamanho.GRANDE);

        assertThrows(IllegalStateException.class, () -> builder.build());
    }

    @Test
    void buildDeveCriarPizzaComValoresPadrao() {
        Pizza pizza = builder.tamanho(Tamanho.GRANDE).ingrediente("calabresa").build();

        assertEquals(Tamanho.GRANDE, pizza.getTamanho());
        assertEquals("tradicional", pizza.getMassa());
        assertFalse(pizza.isBordaRecheada());
        assertEquals(List.of("calabresa"), pizza.getIngredientes());
    }
}
