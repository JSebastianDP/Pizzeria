/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

/**
 *
 * @author Sebastian Diaz
 */
public class DetaleVO {
    String id_detalle, id_venta_fk, id_producto_fk, id_ingrediente_fk;
    int cantidad;
    double precio_venta;

    public DetaleVO() {
    }

    public DetaleVO(String id_detalle, String id_venta_fk, String id_producto_fk, String id_ingrediente_fk, int cantidad, double precio_venta) {
        this.id_detalle = id_detalle;
        this.id_venta_fk = id_venta_fk;
        this.id_producto_fk = id_producto_fk;
        this.id_ingrediente_fk = id_ingrediente_fk;
        this.cantidad = cantidad;
        this.precio_venta = precio_venta;
    }

    public String getId_detalle() {
        return id_detalle;
    }

    public void setId_detalle(String id_detalle) {
        this.id_detalle = id_detalle;
    }

    public String getId_venta_fk() {
        return id_venta_fk;
    }

    public void setId_venta_fk(String id_venta_fk) {
        this.id_venta_fk = id_venta_fk;
    }

    public String getId_producto_fk() {
        return id_producto_fk;
    }

    public void setId_producto_fk(String id_producto_fk) {
        this.id_producto_fk = id_producto_fk;
    }

    public String getId_ingrediente_fk() {
        return id_ingrediente_fk;
    }

    public void setId_ingrediente_fk(String id_ingrediente_fk) {
        this.id_ingrediente_fk = id_ingrediente_fk;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio_venta() {
        return precio_venta;
    }

    public void setPrecio_venta(double precio_venta) {
        this.precio_venta = precio_venta;
    }
    
    
}
