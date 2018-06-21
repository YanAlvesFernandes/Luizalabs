package com.luizalabs.api.services;

import java.util.List;

import com.luizalabs.api.documents.Produto;

public interface ProdutoService {
	
	List<Produto> listarTodos();
	//Busca por id 
	Produto listaPorID(String id);
	//Produto a ser persistido
	Produto cadastrar(Produto produto); 
	Produto atualizar(Produto produto);
	//Método não trás retorno
	void remover(String id);
	

}
