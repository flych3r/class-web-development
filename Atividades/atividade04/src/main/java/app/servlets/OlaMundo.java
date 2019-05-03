package app.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/oi")
public class OlaMundo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang='br'>");

        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>");
        out.println("Ola Mundo");
        out.println("</title>");
        out.println("</head>");

        out.println("<body>");
        out.println("!Olá Mundo!");
        out.println("</body>");

        out.println("</html>");

    }

}