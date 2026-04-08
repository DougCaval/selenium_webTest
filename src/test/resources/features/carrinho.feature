#language:pt
Funcionalidade: Carrinho na Swag Labs

  Cenario: Adicionar um produto ao carrinho
    Dado que o usuario fez login no site
    Quando o usuario adiciona um produto ao carrinho
    Entao o contador do carrinho deve ser 1

  Cenario: Remover produto do carrinho
    Dado que o usuario fez login no site
    Quando o usuario adiciona um produto ao carrinho
    E o usuario remove o produto do carrinho
    Entao o carrinho deve estar vazio

  Cenario: Validar contador do carrinho
    Dado que o usuario fez login no site
    Quando o usuario adiciona um produto ao carrinho
    Entao o contador do carrinho deve ser 1

  Cenario: Acessar carrinho e validar itens adicionados
    Dado que o usuario fez login no site
    Quando o usuario adiciona um produto ao carrinho
    E o usuario acessa o carrinho
    Entao o produto deve estar listado no carrinho