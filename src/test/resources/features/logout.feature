#language: pt

Funcionalidade: Logout

  Cenario: Realizar logout com sucesso e validar redirecionamento para login
    Dado que o usuario esta logado no sistema
    Quando o usuario acessa o menu e clica em logout
    Entao o usuario e redirecionado para a tela de login
