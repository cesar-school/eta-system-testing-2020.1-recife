#language: en

  @ts2020 @listaCompras @adicionarItensAvulsos
  Feature: Adicionar itens avulsos
    Como usuário da aplicação
    Eu quero adicionar itens avulsos à minha lista de compras
    Para que eu possa usá-la em outro momento

#    Background:
#      Given o usuário está logado na aplicação
#      And o usuário está montando uma lista de compras

    @automated @examples @expressions
    Scenario Outline: Visualizar a quantidade de itens de uma lista enquanto itens avulsos são adicionados
      Given a lista de compras contém <quantidade inicial> itens
#      When o usuário adiciona <quantidade adicoes> itens avulsos
#      Then a quantidades de itens da lista é atualizado para <quantidade final>
#      And a seguinte mensagem é mostrada "<mensagem>"
      Examples:
        | quantidade inicial | quantidade adicoes | quantidade final | mensagem  |
        |         2          |         1          |         3        | Foram 3!  |
        |         10         |         5          |        15        | Foram 10! |
