<%@include file = "header.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- 
    Document   : listarPizzas
    Created on : 16/07/2023, 02:03:15 PM
    Author     : Sebastian Diaz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sistema de Pizzas</title>
    </head>
    <body>
    <center>        
        <%-- Codigo para Listar las Pizzas --%>
          <h1 class="Cata">Catálogo</h1>
        <div class="container mt-4" id="Catalogo">
            <div class="row">
                <c:forEach var="p" items="${productos}">
                    <div class="col-sm-4">
                        <div class="form-group">
                            <div class="card">
                                <div class="card-header">
                                    <label class="col-sm-13">${p.getNombre_producto()}</label>                                    
                                </div>
                                <div class="card-body ">
                                    <img src="${p.getImagen()}" width="300" height="170">
                                </div>
                                <div class="card-body2 text-center">
                                    <label><i class="fas fa-dollar-sign" id="precio">${p.getPrecio_producto()}</i></label>                                       
                                </div>
                                <div class="card-footer">
                                    <div class="col-sm-12" >
                                        <div class="modal fade" id="product${p.getId()}" tabindex="-1" role="dialog">
                                            <div class="modal-dialog modal-dialog-centered" role="document">         
                                                <div class="modal-content">                   
                                                    <div class="modal-header text-center" id="Colorheader"> 
                                                        <h5 class="NombrePro">${p.getNombre_producto()}</h5>
                                                        <button type="button" class="close" data-dismiss="modal">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>  
                                                    </div>                                               
                                                </div>
                                            </div>
                                        </div>                                 
                                    </div>
                                    <div class=" col-sm-12 text-center">              
                                        <a href="ControladorProductos?accion=AgregarCarrito&id=${p.getId()}" class="btn btn-danger">Agregar<i class="fas fa-cart-plus"></i></a>
                                        <a href="ControladorProductos?accion=Comprar&id=${p.getId()}" class="btn btn-primary">Comprar</a>
                                        <br>
                                        <br>
                                    </div>                          
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
          
          </center>
                    
                  <%-- Fin codigo para listar pizzas--%>          
          
    </body>
</html>
