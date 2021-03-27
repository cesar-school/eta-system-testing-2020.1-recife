#language: en

  @atividade30 @atividade31 @atividade32 @cadastroUsuario
  Feature: Cadastro de usuário
	Como potencial usuário
	Eu quero me cadastrar na aplicação
	Para que eu possa ter acesso às funcionalidades que requerem login

	@camposObrigatorios
	Scenario: Cadastrar usuário sem informar a idade
	  Given o usuário acessou a aplicação
	  When o usuário informa o nome "Maria"
	  And o usuário informa o email "maria@school.com.br"
	  And o usuário informa a senha 401398
	  And o usuário confirma o cadastro
	  Then o cadastro é realizado com sucesso