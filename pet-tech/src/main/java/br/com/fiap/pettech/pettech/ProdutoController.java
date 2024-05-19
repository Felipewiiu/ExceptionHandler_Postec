package br.com.fiap.pettech.pettech;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ResponseEntity<Collection<Produto>> findAll(){
        var produtos = service.findAll();

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    ResponseEntity<Produto> findById(@PathVariable UUID id){
        var produtos = service.findById(id);

        return  ResponseEntity.ok(produtos);
    }

    @PostMapping
    public ResponseEntity<Produto> save(@RequestBody Produto produto){
        produto = service.save(produto);

        return ResponseEntity.status(HttpStatusCode.valueOf(201)).body(produto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable UUID id, @RequestBody Produto produto){
        produto = service.update(id, produto);

        return ResponseEntity.ok(produto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        service.delete(id);

        return ResponseEntity.noContent().build();
    }
}
