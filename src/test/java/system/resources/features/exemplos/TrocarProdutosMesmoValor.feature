#language: pt

  @ts2020 @trocarProdutos
  Funcionalidade: Trocar produto
	Como cliente da loja
	Eu quero trocar produtos por outros do mesmo valor
	Para que eu tenha os produtos certos no final

	@automated @trocaSimples
	Cenario: Realizar troca com nota fiscal válida
	  Dado o cliente compra um produto
	  E tem uma nota fiscal válida
	  Quando o funcionário inicia um pedido de troca 
	  E seleciona um novo item para troca
	  Entao o sistema registra a devolução do produto à loja
	  E emite uma nova nota fiscal