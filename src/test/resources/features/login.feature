#language: pt

Funcionalidade: Login.

    Cenário: Login com sucesso – usuário padrão (standard_user) e senha correta
        Dado que o usuario esta em na tela de login
        E informa usuario e senha valido Quando clicar no botão ''Entrar''
        Então o sistema deve permitir o acesso do usuario.

    Cenário: Login com senha incorreta – mensagem de erro “Username and password do not
match any user in this service"
        Dado que o usuário acessou a tela de login
        E informa um usuário válido
        E informa uma senha incorreta Quando clicar no botão "Entrar"
        Então o sistema não deve permitir o acesso
        E deve exibir a mensagem "Usuário ou senha inválidos"

    Cenário: Tentativa de login com apenas a senha preenchida
        Dado que o usuário está na tela de login
        E informa uma senha válida
        E deixa o campo usuário em branco
        Quando clicar no botão "Entrar"
        Então o sistema não deve permitir o acesso
        E deve exibir uma mensagem informando que o campo usuário é obrigatório
        E deve permanecer na tela de login.

       Cenário:
 