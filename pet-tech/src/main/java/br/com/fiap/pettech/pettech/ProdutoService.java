package br.com.fiap.pettech.pettech;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository repo;

    public Collection<Produto> findAll(){
        var produtos = repo.findAll();
        return produtos;
    }

    public Produto findById(UUID id){
        var produto = repo.findById(id).orElseThrow(() -> new ControllerNotFoundExeption("Produto não encontrado"));
        return produto;
    }

    public Produto save(Produto produto){
        produto = repo.save(produto);
        return produto;

    }

    public Produto update(UUID id, Produto produto){
        Produto buscaProduto = repo.getOne(id);

        try {
            buscaProduto.setNome(produto.getNome());
            buscaProduto.setDescricao(produto.getDescricao());
            buscaProduto.setPreco(produto.getPreco());
            buscaProduto.setUrlImagen(produto.getUrlImagen());
            buscaProduto.setPreco(produto.getPreco());
            buscaProduto = repo.save(buscaProduto);

            return buscaProduto;
        } catch (EntityNotFoundException e) {
            throw new ControllerNotFoundExeption("Produto não encontrado");
        }


    }

    public void delete(UUID id){
        repo.deleteById(id);
    }


}
