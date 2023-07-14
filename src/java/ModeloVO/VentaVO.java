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
public class VentaVO {
    String id_venta, fecha_venta, id_usuario_fk;
    Double total_Venta;

    public VentaVO() {
    }

    public VentaVO(String id_venta, String fecha_venta, String id_usuario_fk, Double total_Venta) {
        this.id_venta = id_venta;
        this.fecha_venta = fecha_venta;
        this.id_usuario_fk = id_usuario_fk;
        this.total_Venta = total_Venta;
    }

    public String getId_venta() {
        return id_venta;
    }

    public void setId_venta(String id_venta) {
        this.id_venta = id_venta;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(String id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public Double getTotal_Venta() {
        return total_Venta;
    }

    public void setTotal_Venta(Double total_Venta) {
        this.total_Venta = total_Venta;
    }
    
}
