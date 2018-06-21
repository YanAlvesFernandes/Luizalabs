Desenvolvimento de API para cadastro e manutenção de produtos

Foi utilizado a versão v3.6.5 do MongoDB para persistência dos dados,
Utilização do framework Spring Tools V3.9.4
Dependências: DevTools, Web(Disponibilização do Tomcat), MongoDB, Security

O server irá escutar em: http://localhost:8080/api/produtos (endpoint)
database = luizalabs


user: user 
password: Gerado ao executar a API pela classe com.luizalabs.api / LuizalabsApplication.java

Para os testes foi utilizado o Postman, 


Exemplo de Json a ser enviado para persistência
{
	"ean" : "8456451555454.",
	"title" : "Desc do produto",
	"brand" : "Marca do produto",
	"price" : "Valor do produto",
	"stock" : "Qtd em estoque"
}

Exemplo do Json após o cadastro
{
	data: [
		{
		id: "5b244c2ab809311079d9dfd6",
		ean: "8456451555454",
		title: "Desc do produto",
		brand: "Marca do produto",
		price: "55.2",
		stock: "10"
		}
	],
	erros: null
}
