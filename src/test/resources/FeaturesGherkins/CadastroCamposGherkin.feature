Feature: Cadastro

Background: 
	Given estou na pagina de login
	When clicar no botao cadastro

Scenario: Validar o campo cpf
	And preencher o campo nome
	And preencher o campo sobrenome
	And preencher o campo cpf com dados invalidos
	And preencher o campo email
	And clicar no botao enviar
	Then validar mensagem de erro cpf
	
Scenario: Validar o campo email
	When clicar no botao cadastro
	And preencher o campo nome
	And preencher o campo sobrenome
	And preencher o campo cpf
	And preencher o campo email com dados invalidos
	And clicar no botao enviar
	Then validar mensagem de erro email
	
	


