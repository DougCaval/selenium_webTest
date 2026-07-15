#language: pt

Funcionalidade: Adicionar produtos ao carrinho na Swag Labs

  Cenario: Adicionar um item com sucesso
    Dado que estou logado no sistema Swag Labs
    Quando eu adiciono o produto "Sauce Labs Backpack" ao carrinho
    Então o ícone do carrinho deve exibir o número "1"