# language: pt

Funcionalidade: Checkout

  Cenario: Checkout com dados validos
    Dado que o usuario acessa a etapa de checkout
    Quando ele preenche nome "Joao" sobrenome "Silva" e cep "12345"
    E clica em continuar no checkout
    Entao deve acessar a tela de overview

  Cenario: Checkout sem nome
    Dado que o usuario acessa a etapa de checkout
    Quando ele preenche nome "" sobrenome "Silva" e cep "12345"
    E clica em continuar no checkout
    Entao deve exibir erro "Error: First Name is required"

  Cenario: Checkout sem sobrenome
    Dado que o usuario acessa a etapa de checkout
    Quando ele preenche nome "Joao" sobrenome "" e cep "12345"
    E clica em continuar no checkout
    Entao deve exibir erro "Error: Last Name is required"

  Cenario: Checkout sem cep
    Dado que o usuario acessa a etapa de checkout
    Quando ele preenche nome "Joao" sobrenome "Silva" e cep ""
    E clica em continuar no checkout
    Entao deve exibir erro "Error: Postal Code is required"

  Cenario: Finalizar compra com sucesso
    Dado que o usuario acessa a etapa de checkout
    Quando ele preenche nome "Joao" sobrenome "Silva" e cep "12345"
    E clica em continuar no checkout
    E clica em finalizar compra
    Entao deve exibir mensagem de sucesso da compra
