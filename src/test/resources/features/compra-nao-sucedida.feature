#language: pt

Funcionalidade: compras não sucedidas

  Cenário: Inconformidades no processo de compras
    Dado que abro o navegador
    Quando o usuario adiciona um produto no carrinho
    E validar os produtos no carrinho e realizar o checkout
    E clique em continue
    Entao devo visualizar a mensagem de erro "Error: First Name is required"

