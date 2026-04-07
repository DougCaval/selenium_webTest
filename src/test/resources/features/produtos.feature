#language: pt

Funcionalidade: Pagina de Produtos

  Cenario: Verificar se os produtos sao exibidos na pagina home
    Dado que o usuario esta logado na pagina de produtos
    Entao ele deve ver 6 produtos na tela

  Cenario: Ordenar produtos de menor para maior preco
    Dado que o usuario esta logado na pagina de produtos
    Quando ele ordena por menor preco
    Entao o primeiro produto deve ser o mais barato

  Cenario: Ordenar produtos de A a Z
    Dado que o usuario esta logado na pagina de produtos
    Quando ele ordena de A a Z
    Entao o primeiro produto deve comecar com a letra A

  Cenario: Verificar se todos os produtos tem nome preco e imagem
    Dado que o usuario esta logado na pagina de produtos
    Entao todos os produtos devem ter nome preco e imagem