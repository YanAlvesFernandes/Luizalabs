package com.luizalabs.api.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.luizalabs.api.documents.Produto;
import com.luizalabs.api.repositories.ProdutoRepository;
import com.luizalabs.api.services.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
	
	//Implementação dos métodos da interface ProdutoService
	@Autowired
	private ProdutoRepository produtoRepository;

	@Override
	public List<Produto> listarTodos() {
		return this.produtoRepository.findAll();
	}

	@Override
	public Produto listaPorID(String id) {
		return this.produtoRepository.findOne(id);
	}

	@Override
	public Produto cadastrar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	@Override
	public Produto atualizar(Produto produto) {
		return this.produtoRepository.save(produto);
	}

	@Override
	public void remover(String id) {
		this.produtoRepository.delete(id);

	}
}
