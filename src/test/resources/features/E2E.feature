#language: pt

Funcionalidade: Extra - E2E.

    Cenario:  E2E – Fluxo completo feliz
        Dado que estou na página de login
        Quando eu inserir dados válidos de login
        E clicar no botão "Login"
        E adicionar dois produtos ao carrinho
        E clicar no botão "Checkout"
        E preencher os dados de entrega válidos
        E clicar no botão "Continue"
        E clicar no botão "Finish"
        Então devo ver a página de confirmação de pedido
        E deve haver uma mensagem de sucesso
        E não devem haver produtos no carrinho.

    Cenario: E2E – Checkout com campos obrigatórios faltando
        Dado que estou na página de login
        Quando eu inserir dados válidos de login
        E clicar no botão "Login"
        E adicionar um produto ao carrinho
        E clicar no botão "Checkout"
        E deixar o campo "Postal Code" em branco
        E clicar no botão "Continue"
        E ver uma mensagem de erro de campo obrigatório
        E preencher o campo "Postal Code" corretamente
        E clicar no botão "Continue"
        E clicar no botão "Finish"
        Então devo ver a página de confirmação de pedido
        E deve haver uma mensagem de sucesso
        E não devem haver produtos no carrinho

   Cenario: E2E – Remoção de item durante o fluxo
        Dado que estou na página de login
        Quando eu inserir dados válidos de login
        E clicar no botão "Login"
        E adicionar dois produtos ao carrinho
        E clicar no botão "Checkout"
        E preencher os dados de entrega válidos
        E clicar no botão "Continue"
        E os valores apresentados devem estar compatíveis com os produtos
        Então devo clicar no botão "Finish"
        E ver a página de confirmação de pedido
        E deve haver uma mensagem de sucesso
        E não devem haver produtos no carrinho.







