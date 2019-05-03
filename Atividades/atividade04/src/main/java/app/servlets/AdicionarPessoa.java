package app.servlets;

import app.entities.Pessoa;
import app.model.PessoaDAO;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/adiciona")
public class AdicionarPessoa extends HttpServlet {

    private PessoaDAO pessoaDAO = new PessoaDAO();
    private List<Pessoa> listaPessoas = new ArrayList<Pessoa>();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String nome = request.getParameter("nome");
        String time = request.getParameter("time");
        String[] hobbies = request.getParameterValues("hobby");

        Pessoa pessoa = new Pessoa();
        pessoa.setNome(nome);
        pessoa.setTime(time);
        pessoa.setHobbies(hobbies);

        pessoaDAO.cadastrarPessoa(pessoa);
        listaPessoas = pessoaDAO.retornarLista();

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='pt-br'>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>");
        out.println("Adicionar");
        out.println("</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("Pessoa com o nome " + pessoa.getNome() + " foi cadastrada com sucesso!");
        out.println("<br>Pessoas Cadastradas<br>");
        for(Pessoa p: listaPessoas) {
            out.println("Nome: " + p.getNome());
            out.println("Time: " + p.getTime());
            out.println("Hobbies: ");
            for(String h: p.getHobbies())
                out.println(h + ", ");
            out.println("<br>");
        }
        out.println("</body>");

        out.println("</html>");

    }

}