package br.com.alldirect.dao;

import br.com.alldirect.connection.ConnectionFactory;
import br.com.alldirect.model.ModelProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ControllerProduct {

    Connection connection;

    public ControllerProduct() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraProduto(ModelProduct produto) throws SQLException{
        String sql = "INSERT INTO PRODUTOS(NOME, DESCRICAO, PRECO) VALUES(?,?,?)";
        try (PreparedStatement smt = connection.prepareStatement(sql)) {
            smt.setString(1, produto.getNome());
            smt.setString(2, produto.getDescricao());
            smt.setDouble(3, produto.getPreco());
            smt.execute();
        }
    }
}
