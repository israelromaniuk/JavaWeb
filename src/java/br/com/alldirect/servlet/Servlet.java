package br.com.alldirect.servlet;

import br.com.alldirect.dao.ControllerProduct;
import br.com.alldirect.model.ModelProduct;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String nome = request.getParameter("nome");
        String descricao = request.getParameter("descricao");
        Double preco = Double.parseDouble(request.getParameter("preco"));

        try {
            ModelProduct produto = new ModelProduct();
            produto.setNome(nome);
            produto.setDescricao(descricao);
            produto.setPreco(preco);
            ControllerProduct contrlProduto = new ControllerProduct();

            contrlProduto.cadastraProduto(produto);
        } catch (SQLException ex) {
            Logger.getLogger(Servlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        String pagina = "http://localhost:49492/JavaWeb/";
        response.sendRedirect(pagina);
    }
}
