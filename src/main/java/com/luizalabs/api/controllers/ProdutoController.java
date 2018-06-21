package com.luizalabs.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luizalabs.api.documents.Produto;
import com.luizalabs.api.responses.Response;
import com.luizalabs.api.services.ProdutoService;

@RestController
@RequestMapping(path = "/api/produtos")
public class ProdutoController {
	
	@Autowired
	private ProdutoService produtoService;
	
	//Listagem de todos os produtos
	@GetMapping
	public ResponseEntity<Response<List<Produto>>> listarTodos(){
		return ResponseEntity.ok(new Response<List<Produto>>(this.produtoService.listarTodos()));
	}
	//Retornar o produto pesquisando pelo ID
	@GetMapping(path = "/{id}")
	public ResponseEntity<Response<Produto>> listarPorID(@PathVariable(name = "id") String id){
		return ResponseEntity.ok(new Response<Produto>(this.produtoService.listaPorID(id)));
	}
	
	//Cadastrar novos produtos
	@PostMapping
	public ResponseEntity<Response<Produto>> cadastrar(@Valid @RequestBody Produto produto, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Produto>(erros));
		}
		
		return ResponseEntity.ok(new Response<Produto>(this.produtoService.cadastrar(produto)));
	}
	//Atualizar o ID selecionado
	@PutMapping(path = "/{id}")
	public ResponseEntity<Response<Produto>> atualizar(@PathVariable(name = "id") String id, @Valid @RequestBody Produto produto, BindingResult result){
		if (result.hasErrors()) {
			List<String> erros =  new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Produto>(erros));
		}
		produto.setId(id);
		return ResponseEntity.ok(new Response<Produto>(this.produtoService.atualizar(produto)));
	}
	//Retorna somente a quantidade que foi modificada
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id) {
		this.produtoService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
}
