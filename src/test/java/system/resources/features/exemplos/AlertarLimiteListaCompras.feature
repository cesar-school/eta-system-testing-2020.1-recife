#language: en

  @ts2020 @listaCompras @alerta
  Feature: Alertar limite
	Como usuário do aplicativo
	Eu quero ser alertado sobre o valor total da minha lista de compras
	Para que eu saber quando o limite do valor que eu havia planejado for alcançado

	@automated @stepData @chrome
	Scenario: Alertar sobre o limite de valor da lista de
	compras quando itens avulsos são adicionados
	  Given o limite de valor definido pelo usuário é 50.0
	  And o valor da lista de compras atual é 42.91
	  When o usuário adiciona 1 item avulso que custa 11.99
	  Then o valor da lista de compras atual é 54.90
	  And o usuário visualiza o alerta "A lista de compras ultrapassou o valor limite!"