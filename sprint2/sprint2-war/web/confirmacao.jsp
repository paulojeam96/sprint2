<%-- 
    Document   : confirmacao
    Created on : Nov 1, 2016, 1:46:41 PM
    Author     : paulo.lima
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmação do Pagamento</title>
    </head>
    <body>
        
        <h1>Confirmação do Pagamento</h1>
        
        <p>${confirmacao.getUsuario()}</p>
        <p>${confirmacao.getValor()}</p>
        <p>${confirmacao.getDiahora()}</p>
        
    </body>
</html>
