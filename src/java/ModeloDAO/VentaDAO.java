/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.CarritoVO;
import ModeloVO.VentaVO;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Sebastian Diaz
 */
public class VentaDAO extends ConexionBD{
    
    
    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    ConexionBD con = new ConexionBD();
    int r = 0;
    int id_ingrediente = 10;
    
        public int GenerarVenta(VentaVO venVO) {
        int id_venta;
        sql = "insert into venta (fecha_venta, total_venta,id_usuario_fk) values(?,?,?)";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);

            puente.setString(1, venVO.getFecha_venta());
            puente.setDouble(2, venVO.getTotal_venta());
            puente.setString(3, venVO.getUsuarioVO().getId_usuario());
            r = puente.executeUpdate();

            sql = "select @@identity as id_venta";
            mensajero = puente.executeQuery(sql);
            mensajero.next();

            id_venta = mensajero.getInt("id_venta");
            mensajero.close();
            for (CarritoVO detalle : venVO.getDetalleventas()) {
                sql = "insert into detalle_venta (id_venta_fk, id_producto_fk, id_ingrediente_fk, cantidad, precio_venta) values(?,?,?,?,?)";
                puente = conexion.prepareStatement(sql);
                puente.setInt(1, id_venta);
                puente.setInt(2, detalle.getIdProducto());
                puente.setInt(3, id_ingrediente);
                puente.setInt(4, detalle.getCantidad());
                puente.setDouble(5, detalle.getPrecioCompra());

                r = puente.executeUpdate();
            }

        } catch (Exception e) {
        }
        return r;

    }
}
