#language: pt

Funcionalidade: Checkout.

        Cenário: Checkout com dados válidos
                Dado que abro o navegador
                E que o usuario possui ao menos um produto no carrinho
                E esta na pagina de checkout 
                Quando preencher os dados de checkout
                E clicar em continue
                Então deve ser direcionado para a pagina de overview do pedido

        Cenário: Cancelar checkout
                Dado que abre o navegador
                E que o usuario possui pelo menos um produto no carrinho
                E esteja na pagina de checkout 
                Quando clicar no botão Cancel 
                Então deve ser direcionado para a pagina do carrinho