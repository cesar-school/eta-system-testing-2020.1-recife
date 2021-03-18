#language: en

  @ts2021
  Feature: lorem ipsum

	Background: lorem
	  Given lorem
	  And lorem

	@scenario01 @sanity
	Scenario: lorem ipsum
	  Given lorem
	  When lorem
	  And lorem:
	  | uva |
	  | kiwi |
	  But lorem
	  * lorem
	  Then lorem
	  #comentario

	@cadastroUsuario @automated
	Scenario: lorem ipsum
	  Given lorem
	  When lorem lorem 2 lorem
	  And lorem "lorem"
	  But lorem
	  * lorem
	  Then lorem


	Scenario Outline: lorem ipsum
	  Given lorem
	  When lorem "<variavel1>"
	  Then lorem <variavel2>
	  Examples:
	  | variavel1 | variavel2 |
	  |   Maria   |    2      |
	  |   Joao    |     4     |