#language: pt

Funcionalidade: Logar no sistema da Swag Labs


Cenário: Logout do sistema
        Dado que o usuario esta na tela de login
        E informa o usuario "standard_user" e a senha "secret_sauce"
        Quando clicar no botao "botaoLogin"
        E tambem clicar no botao "botaoLogout"
        Então o sistema deve encerrar a sessao do usuario
        E redirecionar para a tela de login

    Cenário: Login apenas com usuário preenchido
        Dado que o usuario esta na tela de login
        E informa o usuario "standard_user" e a senha ""
        Quando clicar no botao "botaoLogin"
        Então o sistema não deve permitir o acesso
        E deve exibir a mensagem 'Password is required'

    Cenário: Login sem usuario e senha preenchidos
        Dado que o usuario esta na tela de login
        E informa o usuario "" e a senha ""
        Quando clicar no botao "botaoLogin"
        Então o sistema não deve permitir o acesso
        E deve exibir a mensagem 'Username is required'

    #  pages(elementos mapeados) > steps ( usar os elementos em açoes) > feature ( vincular steps aos cenarios)