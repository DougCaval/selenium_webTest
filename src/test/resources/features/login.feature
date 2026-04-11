#language: pt

Funcionalidade: Login na Swag Labs

  Cenario: Login com usuario valido
    Dado que o usuario abre o site de login
    Quando insere usuario "standard_user" e senha "secret_sauce"
    Entao deve ser redirecionado para a pagina de produtos

  Cenario: Login com senha invalida
    Dado que o usuario abre o site de login
    Quando insere usuario "standard_user" e senha "senha_errada"
    Entao deve aparecer mensagem de erro de credenciais

  Cenario: Login com usuario bloqueado
    Dado que o usuario abre o site de login
    Quando insere usuario "locked_out_user" e senha "secret_sauce"
    Entao deve aparecer mensagem de usuario bloqueado

  Cenario: Login com campos vazios
    Dado que o usuario abre o site de login
    Quando clica em entrar sem preencher nada
    Entao deve aparecer mensagem de campo obrigatorio