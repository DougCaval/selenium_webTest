# language: pt

Funcionalidade: Teste de Login no SauceDemo

  Cenario: Login com usuário válido
    Dado que o usuário acessa o site
    Quando ele informa usuario "standard_user" e senha "secret_sauce"
    E clica no botao login
    Entao deve acessar a pagina de produtos

  Cenario: Login com senha inválida
    Dado que o usuário acessa o site
    Quando ele informa usuario "standard_user" e senha "senha_errada"
    E clica no botao login
    Entao deve exibir mensagem de erro

  Cenario: Login com usuário bloqueado
    Dado que o usuário acessa o site
    Quando ele informa usuario "locked_out_user" e senha "secret_sauce"
    E clica no botao login
    Entao deve exibir mensagem de usuario bloqueado

  Cenario: Login com campos vazios
    Dado que o usuário acessa o site
    Quando clica no botao login
    Entao deve exibir mensagem de campos obrigatorios
