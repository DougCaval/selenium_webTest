#language: pt

Funcionalidade: Checkout.
        
        Cenário: Voltar do overview para carrinho – botão “Cancel” ou “Back to cart”.
                Dado que estou na página de checkout
                Quando eu clicar no botão "Cancel"
                Então devo ser redirecionado para a página do carrinho.

        Cenário: Checkout com usuário problemático – possíveis erros de imagem ou
cálculo.
                Dado que estou logado com o usuário com problemas visuais
                E houver produtos no carrinho
                E eu estiver na página do carrinho
                Quando eu clicar no botão de prosseguir para página de checkout
                Então os ícones visuais devem estar nos lugares programados.

        Cenário: Verificar se ao voltar sem finalizar a compra, os produtos que estavam no
carrinho permanecem da mesma forma.
                Dado que estou na página de checkout
                Quando eu clicar no botão "Cancel"
                Então devo ser redirecionado para a página do carrinho
                E devem haver os mesmos produtos que selecionei.

