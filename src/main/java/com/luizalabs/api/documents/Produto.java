package com.luizalabs.api.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
//Classe responsável por criar o documento Produto e seus atributos
@Document
public class Produto {
	
	//Id gerado pelo mongo
	@Id
	private String id;
	private String ean, title, brand, price, stock;
	
	//Construtor
	public Produto() {
		
	}
	
	//Getters and setters
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	@NotEmpty(message = "Nao pode ser vazio")
	public String getEan() {
		return ean;
	}

	public void setEan(String ean) {
		this.ean = ean;
	}
	@NotEmpty(message = "Nao pode ser vazio")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	@NotEmpty(message = "Nao pode ser vazio")
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	@NotEmpty(message = "Nao pode ser vazio")
	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}
	@NotEmpty(message = "Nao pode ser vazio") 
	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}


}
