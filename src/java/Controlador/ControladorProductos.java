/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import ModeloDAO.ProductoDAO;
import ModeloDAO.VentaDAO;
import ModeloVO.CarritoVO;
import ModeloVO.ProductoVO;
import ModeloVO.UsuarioVO;
import ModeloVO.VentaVO;
import Util.Fecha;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sebastian Diaz
 */
@WebServlet(name = "ControladorProductos", urlPatterns = {"/ControladorProductos"})
public class ControladorProductos extends HttpServlet {

    UsuarioVO u = new UsuarioVO();
    ProductoDAO pdao = new ProductoDAO();
    ProductoVO proVO = new ProductoVO();
    int item = 0;
    int cantidad = 1;
    double subtotal = 0.0;
    double totalPagar = 0.0;

    List<CarritoVO> listaProductos = new ArrayList<>();
    List productos = new ArrayList();

    int idcompra;
    int idpago;
    double montopagar;
    int id_producto = 0;
    CarritoVO car = new CarritoVO();
    Fecha fechaSistem = new Fecha();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        productos = pdao.Listar();
        String accion = request.getParameter("accion");
        switch (accion) {
            case "Pagar":
                totalPagar = 0.0;
                item = 0;
                subtotal = 0;
                request.setAttribute("Carrito", listaProductos);
                for (int i = 0; i < listaProductos.size(); i++) {
                    subtotal = subtotal + listaProductos.get(i).getSubTotal();
                    totalPagar = totalPagar + listaProductos.get(i).getSubTotal();
                    listaProductos.get(i).setItem(item + i + 1);
                    if (listaProductos.get(i).getItem() >= 10 || listaProductos.get(i).getCantidad() >= 10) {
                        totalPagar = totalPagar - totalPagar;
                    }
                }
                request.setAttribute("subtotal", subtotal);
                request.setAttribute("totalPagar", totalPagar);
                request.getRequestDispatcher("Pagar.jsp").forward(request, response);
                break;
                
                  case "Comprar":
                agregarCarrito(request);
                request.getRequestDispatcher("ControladorProductos?accion=carrito").forward(request, response);
                break;
            case "AgregarCarrito":
                agregarCarrito(request);
                request.setAttribute("cont", listaProductos.size());
                request.getRequestDispatcher("ControladorProductos?accion=home").forward(request, response);
                break;
            case "deleteProducto":
                id_producto = Integer.parseInt(request.getParameter("id"));
                if (listaProductos != null) {
                    for (int j = 0; j < listaProductos.size(); j++) {
                        if (listaProductos.get(j).getIdProducto() == id_producto) {
                            listaProductos.remove(j);
                        }
                    }
                }
                break;
            case "updateCantidad":
                int idpro = Integer.parseInt(request.getParameter("idp"));
                int cant = Integer.parseInt(request.getParameter("Cantidad"));
                for (int j = 0; j < listaProductos.size(); j++) {
                    if (listaProductos.get(j).getIdProducto() == idpro) {
                        listaProductos.get(j).setCantidad(cant);
                        double st = listaProductos.get(j).getPrecioCompra() * cant;
                        listaProductos.get(j).setSubTotal(st);
                    }
                }
                break;
            case "Nuevo":
                request.getRequestDispatcher("ControladorProductos?accion=Pizzas").forward(request, response);
                break;
            default:
                request.setAttribute("cont", listaProductos.size());
                request.setAttribute("productos", productos);
                request.getRequestDispatcher("listarPizzas.jsp").forward(request, response);
                
                case "GenerarVenta":
                HttpSession sesion = request.getSession();
                UsuarioVO usuario = (UsuarioVO) sesion.getAttribute("UsuarioVO");
                if (usuario != null) {
                    VentaDAO venDAO = new VentaDAO();
                    VentaVO venVO = new VentaVO(fechaSistem.FechaBD(), totalPagar,  usuario, listaProductos);
                    int res = venDAO.GenerarVenta(venVO);
                } 
                break;
    }
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
    
    public void agregarCarrito(HttpServletRequest request) {
        cantidad = 1;
        int pos = 0;
        int idpp = Integer.parseInt(request.getParameter("id"));
        if (listaProductos.size() > 0) {
            for (int i = 0; i < listaProductos.size(); i++) {
                if (listaProductos.get(i).getIdProducto() == idpp) {
                    pos = i;
                }
            }
            if (idpp == listaProductos.get(pos).getIdProducto()) {
                cantidad = listaProductos.get(pos).getCantidad() + cantidad;
                subtotal = listaProductos.get(pos).getPrecioCompra() * cantidad;
                listaProductos.get(pos).setCantidad(cantidad);
                listaProductos.get(pos).setSubTotal(subtotal);
            } else {
                car = new CarritoVO();
                proVO = pdao.listarId(idpp);
                car.setIdProducto(proVO.getId());
                car.setNombres(proVO.getNombre_producto());
                car.setPrecioCompra(proVO.getPrecio_producto());
                car.setCantidad(cantidad);
                car.setImagen(proVO.getImagen());
                subtotal = cantidad * proVO.getPrecio_producto();
                car.setSubTotal(subtotal);
                listaProductos.add(car);
            }
        } else {
            car = new CarritoVO();
            proVO = pdao.listarId(idpp);
            car.setIdProducto(proVO.getId());
            car.setNombres(proVO.getNombre_producto());
            car.setPrecioCompra(proVO.getPrecio_producto());
            car.setCantidad(cantidad);
            car.setImagen(proVO.getImagen());
            car.setSubTotal(cantidad * proVO.getPrecio_producto());
            car.setSubTotal(subtotal);
            listaProductos.add(car);

        }
    }

}
