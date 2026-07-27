#language: pt

Funcionalidade: Login.

    Cenário: Login com sucesso – usuário padrão (standard_user) e senha correta
        Dado que o usuario esta em na tela de login
        E informa usuario e senha valido Quando clicar no botão ''Entrar''
        Então o sistema deve permitir o acesso do usuario.
