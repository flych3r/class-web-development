package br.ufc.web._final.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Prato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPrato;

    @NotBlank(message = "Preencha o campo nome")
    private String nome;

    @NotBlank(message = "Preencha o campo descrição")
    private String descricao;

    @NotBlank(message = "Preencha o campo preço")
    private Double preco;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private List<Item> itemList;

    public Long getIdPrato() {
        return idPrato;
    }

    public void setIdPrato(Long idPrato) {
        this.idPrato = idPrato;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descrição) {
        this.descricao = descrição;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }
}
