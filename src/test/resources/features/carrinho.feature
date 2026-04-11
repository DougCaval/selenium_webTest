# language: pt

Funcionalidade: Carrinho de compras no SauceDemo

  Cenario: Adicionar um produto ao carrinho
    Quando o usuario adiciona o produto ao carrinho
    Entao o produto deve estar no carrinho

  Cenario: Remover produto do carrinho
    Quando o usuario remove o produto do carrinho
    Entao o carrinho deve estar vazio

  Cenario: Validar contador do carrinho (badge)
    Quando o usuario adiciona o produto ao carrinho
    Entao o badge do carrinho deve exibir "1"

  Cenario: Acessar carrinho e validar itens adicionados
    Quando o usuario acessa o carrinho
    Entao deve exibir o produto "Sauce Labs Backpack" na lista