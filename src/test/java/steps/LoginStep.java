package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import pages.LoginPage2;
import util.DriverFactory;

public class LoginStep {

    private LoginPage2 loginPage;

    @Before
    public void iniciar() {
        loginPage = new LoginPage2();
    }

    @Dado("que o usuario abre o site de login")
    public void que_o_usuario_abre_o_site_de_login() throws InterruptedException {
        loginPage.abrirSite();
    }

    @Quando("insere usuario {string} e senha {string}")
    public void insere_usuario_e_senha(String usuario, String senha) throws InterruptedException {
        loginPage.inserirCredenciais(usuario, senha);
    }

    @Quando("clica em entrar sem preencher nada")
    public void clica_em_entrar_sem_preencher_nada() throws InterruptedException {
        loginPage.clicarLoginSemPreencher();
    }

    @Entao("deve ser redirecionado para a pagina de produtos")
    public void deve_ser_redirecionado_para_a_pagina_de_produtos() {
        Assert.assertEquals("https://www.saucedemo.com/inventory.html", loginPage.obterUrlAtual());
    }

    @Entao("deve aparecer mensagem de erro de credenciais")
    public void deve_aparecer_mensagem_de_erro_de_credenciais() {
        Assert.assertTrue(loginPage.obterMensagemErro().contains("Username and password do not match"));
    }

    @Entao("deve aparecer mensagem de usuario bloqueado")
    public void deve_aparecer_mensagem_de_usuario_bloqueado() {
        Assert.assertTrue(loginPage.obterMensagemErro().contains("Sorry, this user has been locked out"));
    }

    @Entao("deve aparecer mensagem de campo obrigatorio")
    public void deve_aparecer_mensagem_de_campo_obrigatorio() {
        Assert.assertTrue(loginPage.obterMensagemErro().contains("Username is required"));
    }

    @After
    public void fechar() {
        DriverFactory.quit();
    }
}