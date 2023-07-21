<%@page import="ModeloVO.IngredientesVO"%>
<%@page import="ModeloDAO.IngredientesDAO"%>
<%@page import="Util.Fecha"%>
<%@include file = "header.jsp" %>
<%-- 
    Document   : Pagar
    Created on : 18/07/2023, 06:37:34 PM
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
        <div class="container mt-4">                    
            <div class="row">             
                <div class="col-lg-9">                 
                    <table class="table">
                        <thead class="thead">
                            <tr class="text-center">
                                <th>Item</th>                               
                                <th>Articulo</th>
                                <th>Descripcion</th>
                                <th>Precio</th>
                                <th>Cantidad</th>                       
                                <th>Precio Pizza x cantidad</th>  
                                <th>Ingredientes</th>
                                <th class="accion">Acciones</th>                       
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="c" items="${Carrito}"> 
                                <tr class="text-center tr">
                                    <td>${c.getItem()}</td>                                   
                                    <td>
                                        <img src="${c.getImagen()}" width="130" height="110">
                                    </td>
                                    <td>${c.getNombres()}</td>
                                    <td>${c.getPrecioCompra()}</td>
                                    <td>        
                                        <input type="hidden" id="idpro" value="${c.getIdProducto()}">
                                        <input type="number" min="1"   id="Cantidad" class=" form-control text-center" value="${c.getCantidad()}">
                                    </td>
                                    <td>${c.getSubTotal()}</td> 
                                    <td>
                                          <form method="post" action="ControladorIngredientes">
                                            <table>
                                                <select name="rol"  class="controls">
                                                    <option>Seleccione</option>
                                                    <% IngredientesDAO ingdao = new IngredientesDAO();
                                                        for (IngredientesVO ingvo : ingdao.Ingredientes()) {
                                                    %>


                                                    <option value="<%=ingvo.getId_ingredientes()%>"><%=ingvo.getNombre_ingredientes()%></option>
                                                    <%
                                                        }
                                                    %>
                                                </select>
                                                </tr>
                                            </table>
                                        </form>
                                    </td>
                                    <td class="text-center">                                         
                                        <input type="hidden" id="item2" value="${c.getIdProducto()}">
                                        <a id="deleteItem" href="#" class="btn">Borrar</a>                                            
                                    </td> 
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>                    
                </div>
                <div class="col-lg-3">                  
                    <div class="card">
                        <div class="card-header">
                            Datos de compra
                        </div>
                        <div class="card-body">
                            <label>Total a Pagar:</label>
                            <a class="form-control text-center"><i class="fas fa-dollar-sign h4 primary"> ${totalPagar}0</i></a>
                        </div>
                        <div class="card-footer">
                            <a href="ControladorProductos?accion=GenerarVenta" class="btn btn-danger btn-block">Realizar Compra</a>
                            <a href="#" data-toggle="modal" data-target="#myModalPago" class="btn btn-info btn-block">Datos Pago</a>
                        </div>
                    </div>
                </div>
            </div>          
        </div>
        <div class="modal fade" id="myModalPago" tabindex="-1" role="dialog">
            <div class="modal-dialog modal-dialog-centered" role="document">         
                <div class="modal-content">                   
                    <div class="modal-header text-center"> 
                        <label><i class="fa-dollar-sign"></i>Realizar Pago</label>
                        <button type="button" class="close" data-dismiss="modal">
                            <span aria-hidden="true">&times;</span>
                        </button>  
                    </div>
                    <div class="modal-body"> 
                        <div class="tab-content" id="pills-tabContent">
                            <!-- Metodo Pago -->
                            <div class="tab-pane fade show active" id="pills-iniciar" role="tabpanel">
                                <form action="Controlador">
                                    <div class="form-group">
                                        <label>Card address</label>
                                        <input type="text" class="form-control" placeholder="9999-9999-9999-9999">
                                    </div>
                                    <div class="form-group">
                                        <label>Codigo Seguridad</label>
                                        <input type="text" class="form-control" placeholder="xxxx">
                                    </div>
                                    <div class="form-group">
                                        <label>Monto</label>
                                        <input type="text"  name="txtmonto"  value="$${totalPagar}" class="form-control h1" readonly>
                                    </div>
                                    <div class="card-footer">
                                        <a href="ControladorProductos?accion=GenerarVenta" class="btn btn-danger btn-block">Realizar Compra</a>
                                    </div>
                                </form>
                            </div>

                        </div> 
                    </div>
                </div>
            </div>
        </div>

        <script src="js/funciones.js" type="text/javascript"></script>
        <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>

    </body>
</html>
