package br.com.fiap.pettech.pettech;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity(name = "Produto")
@Table(name = "tb_poduto")
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@ToString
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private String descricao;
    private double preco;
    private String urlImagen;

}
