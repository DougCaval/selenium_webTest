#language: pt 

Funcionalidade: inventário

  Cenário: exibir lista de produtos 
    Dado que o usuário acessou a pagina de inventário
    Quando a pagina for carregada
    Entao a lista de produtos deve ser exibida

    Cenário: adicionar produto ao carrinho
    Dado que o usuário acessou a pagina de inventário   
    Quando clicar no botão "Adicionar ao carrinho" de um produto escolhido
    Entao o produto deve ser adicionado ao carrinho de compras

    Cenário: ordenar produtos de a-z
    Dado que o usuário acessou a pagina de inventário
    E se direcionar ao botão de filtragem a direita 
    Quando selecionar a opção "Nome (A-Z)"
    Entao os produtos devem ser exibidos em ordem alfabética crescente



