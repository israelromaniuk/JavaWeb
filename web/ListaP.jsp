<%-- 
    Document   : ListaP
    Created on : 20/09/2016, 11:05:00
    Author     : Administrador
--%>

<%@page import="br.com.alldirect.model.ModelProduct"%>
<%@page import="java.util.List"%>
<%@page import="br.com.alldirect.dao.ControllerProduct"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Produtos</title>
    </head>
    <body>
        <%
            ControllerProduct controllerProduct = new ControllerProduct();
            List<ModelProduct> produtos = controllerProduct.listaProdutos();

            for (ModelProduct p : produtos) {
        %>
    <li>
        <%=p.getNome()%> -
        <%=p.getDescricao()%> -
        <%=p.getPreco()%> -
    </li>
    <%}%>
</body>
</html>
