# Observações sobre o projeto

Procurei atender os requisitos da uma forma prática, para ser possível entregar o projeto com alguns extras no prazo. Por isso, deixei o design do sistema simples.
Respeitei a assinatura dos métodos REST definidos. Se não tivessem sido especificados, eu iria definir eles usando padrão [Hateoas](https://spring.io/understanding/HATEOAS) que o Spring até facilita para desenvolver.

# Para fazer build
 - Precisa do Gradle instalado, comando `gradle build` para executar os testes e gerar uma build.
 - Para gerar uma imagem Docker (precisa ter Docker instalado) comando `gradle dockerBuild`.

# Como executar a aplicação

 Pode escolher como executar, entre as três maneiras:
 1. Fazer o comando `gradle bootRun`.
 2. Em uma IDE: A classe Main é `com.qualirede.QualiredeApplication`.
 3. Imagem Docker: Publiquei uma imagem docker em `edpichler/qualirede-java-app:latest`. Para executar esta imagem, fazer `docker run -p 8080:8080 edpichler/qualirede-java-app:latest`

# Extras desenvolvidos

 - Aplicação está hospedada no Cloud: http://qualirede-ingress.qualirede.68.183.134.88.xip.io/
 - Testes unitários foram feitos, apenas alguns, nos Resources REST e nos repositórios.
 - Documentação dos métodos REST, fiz apenas o javadoc, pois não tinha certeza se era pra ser uma documentação interativa. Mas poderia ter usado o https://swagger.io/ para fazer uma documentação interativa.
 - Segurança com JWT: Deixei apenas o método /rest/v1/beneficiario/doenca precisando do token para autenticação. Para fazer login, observar como foi está sendo feito no teste unitário `BeneficiarioControllerTest.testBeneficiarioVincularDoenca()`
 - Além dos extras requisitados, fiz o aplicativo ser empacotado em imagem Docker.

---

# Requisitos solicitados na tarefa


	Um plano de saúde busca sempre melhorar a qualidade de vida dos seus beneficiários, garantindo uma relação ganha-ganha.
	O beneficiário melhora a saúde e o plano economiza com os cuidados médicos.
	O gestor do setor de Atenção Integral à Saúde solicitiou a criação de um novo sistema para registrar as doenças e problemas de saúde de seus beneficiários.
	Segue a especificação dos serviços REST:
	
	Entrada REST 
		
	Beneficiário
		POST /rest/v1/beneficiario
		body:
		{
			"nome": "JOÃO DA SILVA"
			"dtNascimento": "01/01/2018"
		}
		
		Saída:
			- O identificador único do beneficiário cadastrado
			
		GET /rest/v1/beneficiario/{idBeneficiario}
		
		Saída:
			{
				"nome": "JOÃO DA SILVA"
				"dtNascimento": "01/01/2018"
			}
			
		GET /rest/v1/beneficiario/{idBeneficiario}/doencas
		Saída:
			[{
				"codigo": "A00"
				"descricao": "Cólera"
			},
			{
				"codigo": "A01"
				"descricao": "Febres Tifóide e Paratifóide"
			}]
			
	Doenças e problemas de saúde:
		POST /rest/v1/doenca
		body:
			{
				"codigo": "A00"
				"descricao": "Cólera"
			}
		
		Saída:
			- O identificador único da doença cadastrada
			
		GET /rest/v1/doenca/{idDoenca}
		
		Saída:
			{
				"codigo": "A00"
				"descricao": "Cólera"
			}
		
	Vincular uma doença a um beneficiário:
		
		POST /rest/v1/beneficiario/doenca
		{
			"idBeneficiario": 123456
			"idDoenca": 12
		}
		
		Saída:
		{
			"Beneficiário {nome do beneficiário} vinculado à doença {descricao da doença} com sucesso."
		}
		
		
	Usar as tecnologias a seguir:
		- Java 8
		- JAX-RS (REST)
		- Spring boot (Aplicação autossuficiente - Independente de servidor de aplicação)
		- Spring MVC
		- Hibernate (usar um embedded sql. Exemplo: H2)
		- Maven
	
	Como enviar a prova:
		- Hospedar o fonte no git e compartilhar o acesso com andre.duarte@qualirede.com.br
		- Enviar o comando Maven para executar o build
		- Enviar o comando Maven para executar a app

	Extras:
		- Hospedar a aplicação na Amazon
		- Desenvolver testes unitários
		- Utilizar JWT nos RESTs
		- Documentar os RESTs desenvolvidos
