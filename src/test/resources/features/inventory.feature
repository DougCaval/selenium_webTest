#language: pt

Funcionalidade: Inventário.

    Cenario:  Exibir corretamente as informações dos produtos na listagem
        Dado que o usuário está autenticado no sistema
        E acessa a página de listagem de produtos
        Quando a página for carregada
        Então todos os produtos disponíveis devem ser exibidos
        E cada produto deve apresentar o título
        E cada produto deve apresentar o preço
        E cada produto deve apresentar a imagem correspondente
        E cada produto deve apresentar o botão de ação disponível