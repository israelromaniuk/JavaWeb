<%-- 
    Document   : ListaP
    Created on : 20/09/2016, 11:05:00
    Author     : Administrador
--%>

<%@page import="br.com.alldirect.model.ModelProduct"%>
<%@page import="java.util.List"%>
<%@page import="br.com.alldirect.dao.ControllerProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="ListaP.css">
<!-- CSS do Bootstrap -->
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- Biblioteca jQuery-->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- JavaScript do Bootstrap -->
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
    </head>
    <body>
        <div>
            <table class="table table-bordered">
                <tr>
                    <td class="codigo">Código</td>
                    <td class="alinhaCentro">Nome</td>
                    <td class="alinhaCentro">Descrição</td>
                    <td class="alinhaCentro">Preço</td>
                </tr>
                <%
                    ControllerProduct controllerProduct = new ControllerProduct();
                    List<ModelProduct> produtos = controllerProduct.listaProdutos();

                    for (ModelProduct p : produtos) {
                %>
                <tr>
                    <td class="codigo"><%=p.getId()%></td>
                    <td><%=p.getNome()%> -</td>
                    <td><%=p.getDescricao()%></td>
                    <td class="alinhaEsquerda"><%=p.getPreco()%></td>
                </tr>
                <%}%>
            </table>
        </div>
        <div>
            <a class="btn btn-default" href="http://localhost:49492/JavaWeb/" role="button">Back</a>
        </div>
    </body>
</html>
