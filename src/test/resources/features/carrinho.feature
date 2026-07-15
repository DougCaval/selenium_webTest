Cenário 1 — Visualizar lista de produtos
Dado que o usuário realizou login com sucesso

Quando acessar a página de inventário

Então o sistema deve exibir a lista de produtos disponíveis


Cenário 2 — Adicionar produto ao carrinho a partir do inventário
Dado que o usuário está na página de inventário

Quando clicar em "Add to cart" de um produto

Então o produto deve ser adicionado ao carrinho

E o ícone do carrinho deve atualizar a quantidade


Cenário 3 — Remover produto do carrinho a partir do inventário

Dado que um produto foi adicionado ao carrinho

Quando clicar em "Remove" na página de inventário

Então o produto deve ser removido do carrinho


Cenário 4 — Ordenar produtos por preço crescente

Dado que o usuário está na página de inventário

Quando selecionar a opção de ordenação por preço crescente

Então os produtos devem ser exibidos do menor para o maior preço



Cenário 5 — Visualizar detalhes de um produto
Dado que o usuário está na página de inventário

Quando clicar no nome ou imagem de um produto

Então o sistema deve exibir a página de detalhes do produto selecionado


