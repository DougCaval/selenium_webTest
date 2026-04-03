#language: pt

Funcionalidade: Fluxo completo de compra na Swag Labs

    Cenario: Fluxo completo de login adicionar produto checkout e sucesso
        Dado que o usuario realiza login com sucesso
        Quando adiciona um produto ao carrinho
        E acessa o carrinho e inicia o checkout
        E preenche os dados de entrega
        Entao a compra e finalizada com sucesso

    Cenario: Fluxo com multiplos produtos no carrinho 
        Dado que o usuario realiza login com sucesso 
        Quando adiciona multiplos produtos ao carrinho
        E acessa o carrinho e inicia o checkout
        E preenche os dados de entrega
        Entao a compra e finalizada com sucesso

