package br.com.alldirect.dao;

import br.com.alldirect.connection.ConnectionFactory;
import br.com.alldirect.model.ModelProduct;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControllerProduct {

    Connection connection;

    public ControllerProduct() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void cadastraProduto(ModelProduct produto) throws SQLException {
        String sql = "INSERT INTO PRODUTOS(NOME, DESCRICAO, PRECO) VALUES(?,?,?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPreco());
            stmt.execute();
        }
    }

    public List<ModelProduct> listaProdutos() throws SQLException {
        String sql = "SELECT * FROM PRODUTOS";
        List<ModelProduct> produtos = new ArrayList<ModelProduct>();
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            while (resultSet.next()) {
                ModelProduct produto = new ModelProduct();
                produto.setNome(resultSet.getString("nome"));
                produto.setDescricao(resultSet.getString("descricao"));
                produto.setPreco(resultSet.getDouble("preco"));
                produtos.add(produto);

            }
            return produtos;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return produtos;
    }
}
