#language: pt

Funcionalidade: Checkout no sistema da Swag Labs

  Cenario: Iniciar checkout com carrinho vazio
    Dado que abro o navegador
    Quando acesso o carrinho sem produtos
    Entao devo ver o carrinho vazio

  Cenario: Preencher dados obrigatorios corretamente
    Dado que abro o navegador
    E adiciono um produto ao carrinho
    Quando acesso o checkout e preencho os dados corretamente
    Entao devo ver a tela de resumo da compra

  Cenario: Validar erro ao nao preencher campos obrigatorios
    Dado que abro o navegador
    E adiciono um produto ao carrinho
    Quando acesso o checkout e clico em continuar sem preencher os dados
    Entao devo ver uma mensagem de erro

  Cenario: Finalizar compra com sucesso
    Dado que abro o navegador
    E adiciono um produto ao carrinho
    Quando acesso o checkout preencho os dados e finalizo a compra
    Entao devo ver a mensagem de pedido confirmado

  Cenario: Validar resumo da compra
    Dado que abro o navegador
    E adiciono um produto ao carrinho
    Quando acesso o checkout e preencho os dados corretamente
    Entao devo ver o nome do produto o preco e as taxas