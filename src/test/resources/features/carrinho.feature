#language: pt

Funcionalidade: Carrinho.

Cenario: Acessar carrinho pelo icone com itens adicionados
Dado que eu adicionei Sauce Labs Backpack ao carrinho
E estou na pagina de inventario
Quando eu clicar no icone do carrinho
Entao devo ser redirecionado para cart.html
E o produto Sauce Labs Backpack deve estar listado no carrinho

Cenario: Validar atualizacao do contador do carrinho apos inclusao do produto
Dado que estou na pagina de inventario
Quando eu adicionar um produto ao carrinho
Entao o contador do carrinho deve exibir 1


