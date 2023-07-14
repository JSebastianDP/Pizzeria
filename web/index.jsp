<%@include file = "header.jsp" %>
<%-- 
    Document   : index.jsp
    Created on : 12/07/2023, 02:25:27 PM
    Author     : Sebastian Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
      <div class="p-5 mb-4 bg-light rounded-3">
    <div class="container-fluid py-5">
      <h1 class="display-5 fw-bold">Bienvenido al Sistema</h1>
      <p class="col-md-8 fs-4">Usuario: ${correo}</p>
      <button class="btn btn-primary btn-lg" type="button">Comprar ahora</button>
    </div>
     </div>
    </body>
</html>
