<%@include file = "Sesion/cache.jsp" %>
<%-- 
    Document   : header
    Created on : 12/07/2023, 02:21:49 PM
    Author     : Sebastian Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
  <title>Title</title>
  <!-- Required meta tags -->
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

  <!-- Bootstrap CSS v5.2.1 -->
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.1/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-iYQeCzEYFbKjA/T2uDLTpkwGzCiq6soy8tYaI1GyVh/UjpbCx/TYkiZhlZB6+fzT" crossorigin="anonymous">

<script
  src="https://code.jquery.com/jquery-3.7.0.min.js"
  integrity="sha256-2Pmvv0kuTBOenSvLm6bvfBSSHrUJ+3A7x6P5Ebd07/g="
  crossorigin="anonymous"></script>

<link rel="stylesheet" href="https://cdn.datatables.net/1.13.5/css/jquery.dataTables.css"/>
<script src="https://cdn.datatables.net/1.13.5/js/jquery.dataTables.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>

<body>
  <header>
    <!-- place navbar here -->
  </header>


  <!--Barra de navegacion  -->
<nav class="navbar navbar-expand navbar-dark bg-dark">
    <ul class="nav navbar-nav">
        <li class="nav-item">
            <a class="nav-link active" href="#" aria-current="page">Sistema Pizzas<span class="visually-hidden"></span></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="">Usuarios</a>
        </li>
        <li class="nav-item">
            <a class="nav-link" href="./ControladorProductos?accion=Nuevo">Pizzas </a>
        </li>
        <li class="nav-item">
            <form method="POST" action="${pageContext.request.contextPath}/Sesiones">
                            <li class="nav-item">
                                <input type="submit" class="nav-link btn btn-primary ms-1" value="Cerrar sesi&#243;n">  
                            </li>
            </form> 
        </li>
    </ul>
</nav>
    </body>
</html>


