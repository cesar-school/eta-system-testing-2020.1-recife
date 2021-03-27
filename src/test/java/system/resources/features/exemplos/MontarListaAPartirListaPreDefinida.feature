#language: en

  @ts2020 @montarLista @listaPreDefinida
  Feature: Montar lista
	Como usuário da aplicação
	Eu quero montar a minha lista de compras a partir de uma lista pré definida
	De modo a facilitar a montagem da minha lista

#	Background:
#	  Given o usuário está logado na aplicação
#	  And escolhe montar uma lista de compras a partir de uma lista pré definida

	@automated @simple @inProgress
	Scenario: Escolher alguns itens de uma lista de compras pré definida
	  Given o usuário escolhe a lista pré definida chamada "frutas"
	  When o usuário escolhe o item uva
	  * escolhe o item morango
	  * escolhe o item kiwi
	  And o usuário finaliza a seleção
	  Then o item uva é adicionado à lista de compras
	  * o item morango é adicionado à lista de compras
	  * o item kiwi é adicionado à lista de compras

	@automated @dataTable
	Scenario: Escolher itens de uma lista de compras pré definida
	  Given o usuário escolhe a lista de compras frutas
	  Then o usuário seleciona os seguintes itens:
		| uva     | chocolate |
		| morango | torta     |
		| kiwi    | biscoito  |
	  And o cliente seleciona 1
	  When o cliente seleciona o seguinte produto:
		| uva     |
	  	| blu     |
#	  When o usuário seleciona o seguinte produto:
#		| uva     | uva2 |
#		| blu     | blu2 |
#	  And o usuário finaliza a seleção
#	  Then os seguintes itens são adicionados à lista de compras:
#		| uva     |
#		| morango |
#		| kiwi    |