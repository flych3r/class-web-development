package app.model;

import app.entities.Pessoa;

import java.util.ArrayList;
import java.util.List;

public class PessoaDAO {

    private List<Pessoa> pessoas;

    public PessoaDAO() {
        pessoas = new ArrayList<Pessoa>();
    }

    public void cadastrarPessoa(Pessoa pessoa) {
        pessoas.add(pessoa);
    }

    public List<Pessoa> retornarLista() {
        return pessoas;
    }

}