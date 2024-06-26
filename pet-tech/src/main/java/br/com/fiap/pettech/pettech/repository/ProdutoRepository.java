package br.com.fiap.pettech.pettech.repository;

import br.com.fiap.pettech.pettech.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProdutoRepository extends JpaRepository<Produto, UUID> {
}
