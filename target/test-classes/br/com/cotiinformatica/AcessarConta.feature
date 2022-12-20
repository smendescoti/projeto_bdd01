#language: pt

Funcionalidade: Acessar Conta
	como um usuário cadastrado no sistema
	eu quero acessar minha conta de usuário
	para que eu possa entrar na área restrita do sistema
	
	Cenário: Acessar conta com sucesso
		Dado Acessar a página de autenticação de usuário
		E Informar meu email de acesso
		E Informar minha senha de acesso
		Quando Solicitar a realização do acesso
		Então Sistema autentica o usuário com sucesso
		
	Cenário: Acesso negado
		Dado Acessar a página de autenticação de usuário
		E Informar um email inválido
		E Informar uma senha inválida
		Quando Solicitar a realização do acesso
		Então Sistema informa que o acesso é negado	