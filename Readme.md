# Observações sobre o projeto

Procurei atender os requisitos da uma forma prática, para ser possível entregar antes do prazo. Deixei o design do sistema simples, na solução atual, se o banco de dados for alterado, iria impactar as interfaces REST, então precisaria separar o design dessas classes, caso esta fosse uma aplicação para outro fim.
Respeitei a assinatura dos métodos REST definidos. Se não tivessem sido especificados, eu iria definir usando padrão [Hateoas](https://spring.io/understanding/HATEOAS).

# Para fazer build
 - Precisa do Gradle instalado, comando `gradle build` para executar os testes e gerar uma build.
 - Para gerar uma imagem Docker (precisa ter Docker instalado) comando `gradle dockerBuild`.

# Como executar a aplicação

 Pode escolher como executar, entre as três maneiras:
 1. Fazer o comando `gradle bootRun`.
 2. Em uma IDE: A classe Main é `com.qualirede.QualiredeApplication`.
 3. Imagem Docker: Publiquei uma imagem docker em `edpichler/qualirede-java-app:latest`. Para executar esta imagem, fazer `docker run -p 8080:8080 edpichler/qualirede-java-app:latest`

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