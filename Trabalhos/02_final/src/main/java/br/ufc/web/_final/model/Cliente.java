package br.ufc.web._final.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @NotBlank(message = "Preencha o campo nome")
    private String nome;
    @NotBlank(message = "Preencha o campo cpf")
    private String cpf;

    @NotNull(message = "Preencha o campo endereço")
    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;

    @NotNull(message = "Preencha o campo data de nascimento")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Temporal(TemporalType.DATE)
    private Date dataNascimento;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Pedido> pedidoList;


    public Long getIdCliente() { return idCliente; }

    public void setIdCliente(Long idCliente) { this.idCliente = idCliente; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    public Date getDataNascimento() { return dataNascimento; }

    public void setDataNascimento(Date dataNascimento) { this.dataNascimento = dataNascimento; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

}
