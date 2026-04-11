# language: pt

Funcionalidade: Home / Listagem de Produtos

  Cenario: Validar exibição de todos os produtos
    Dado que o usuário está logado na página de produtos
    Entao deve exibir todos os produtos

  Cenario: Ordenar produtos por preço (menor → maior)
    Dado que o usuário está logado na página de produtos
    Quando ordenar produtos por preço menor a maior
    Entao os produtos devem ser exibidos por preço em ordem crescente

  Cenario: Ordenar produtos por nome (A → Z)
    Dado que o usuário está logado na página de produtos
    Quando ordenar produtos por nome de A a Z
    Entao os produtos devem ser exibidos em ordem alfabética A a Z

  Cenario: Validar exibição de imagem, nome e preço de cada item
    Dado que o usuário está logado na página de produtos
    Entao cada item deve exibir imagem, nome e preço
