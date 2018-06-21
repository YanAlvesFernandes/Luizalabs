package com.luizalabs.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.luizalabs.api.documents.Produto;

//Documento a qual se referencia (Produto)
//MongoRepository para herança de verbos http 
public interface ProdutoRepository extends MongoRepository<Produto, String> {
	
}
