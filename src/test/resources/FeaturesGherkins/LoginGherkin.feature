Feature: Login

Background: 
	Given estou na tela de login
	

Scenario: Login com sucesso 
	When preencher o campo Usuario 
	And preencher o campo Senha
	And clicar no botao Login
	Then validar Login com sucesso
	
Scenario: Login sem sucesso 
	When preencher o campo Usuario com dados invalidos
	And preencher o campo Senha com dados invalidos
	And clicar no botao Login
	Then validar mensagem de usuario ou senha invalidos