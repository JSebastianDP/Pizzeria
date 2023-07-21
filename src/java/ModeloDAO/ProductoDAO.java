/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.IngredientesVO;
import ModeloVO.ProductoVO;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Sebastian Diaz
 */
public class ProductoDAO extends ConexionBD{
    
    ConexionBD con = new ConexionBD();
    Connection conexion;
    PreparedStatement puente;
    ResultSet mensajero;
    private String sql;
    int r=0;
    
    public List Listar() {
        ArrayList<ProductoVO> productos = new ArrayList<>();
        sql = "select * from producto";
        try {
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                ProductoVO proVO = new ProductoVO();
                proVO.setId(mensajero.getInt(1));
                proVO.setNombre_producto(mensajero.getString(2));
                proVO.setPrecio_producto(mensajero.getDouble(3));
                proVO.setCantidad_producto(mensajero.getInt(4));
                proVO.setImagen(mensajero.getString(5));
//                proVO.setFoto(mensajero.getString(5));
                productos.add(proVO);
            }
        } catch (SQLException e) {
        }
        return productos;
    }
       public ProductoVO listarId(int id) {
        ProductoVO p = new ProductoVO();
        String sql = "select * from producto where id_producto=" + id;
        try {
            conexion = con.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();
            while (mensajero.next()) {
                p.setId(mensajero.getInt(1));
                p.setNombre_producto(mensajero.getString(2));
                p.setPrecio_producto(mensajero.getDouble(3));
                p.setCantidad_producto(mensajero.getInt(4));
                p.setImagen(mensajero.getString(5));
//                p.setFoto(rs.getBinaryStream(5));
                             
            }
        } catch (Exception e) {
        }
        return p;
    }

}
