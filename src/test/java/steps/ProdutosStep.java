package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.ProdutosPage;
import util.DriverFactory;

public class ProdutosStep {

    private ProdutosPage produtosPage;

    @Before
    public void iniciar() {
        DriverFactory.getDriver();
        produtosPage = new ProdutosPage();
    }

    @After
    public void encerrar() {
        DriverFactory.quit();
    }

    @Dado("que o usuario esta logado na pagina de produtos")
    public void que_o_usuario_esta_logado_na_pagina_de_produtos() throws InterruptedException {
        produtosPage.fazerLogin();
    }

    @Entao("ele deve ver {int} produtos na tela")
    public void ele_deve_ver_produtos_na_tela(int quantidade) {
        Assert.assertEquals(quantidade, produtosPage.contarProdutos());
    }

    @Quando("ele ordena por menor preco")
    public void ele_ordena_por_menor_preco() throws InterruptedException {
        produtosPage.ordenarPorMenorPreco();
    }

    @Entao("o primeiro produto deve ser o mais barato")
    public void o_primeiro_produto_deve_ser_o_mais_barato() throws InterruptedException {
        produtosPage.ordenarPorMenorPreco();
        double primeiroPreco = produtosPage.obterPrecoPrimeiroProduto();
        Assert.assertTrue(primeiroPreco <= 10.0);
    }

    @Quando("ele ordena de A a Z")
    public void ele_ordena_de_A_a_Z() throws InterruptedException {
        produtosPage.ordenarDeAaZ();
    }

    @Entao("o primeiro produto deve comecar com a letra A")
    public void o_primeiro_produto_deve_comecar_com_a_letra_A() {
        String nome = produtosPage.obterNomePrimeiroProduto();
        Assert.assertTrue(nome.startsWith("A") || nome.startsWith("a"));
    }

    @Entao("todos os produtos devem ter nome preco e imagem")
    public void todos_os_produtos_devem_ter_nome_preco_e_imagem() {
        Assert.assertTrue(produtosPage.todosProdutosTemNomePrecoEImagem());
    }
}