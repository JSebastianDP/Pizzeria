/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import java.util.List;

/**
 *
 * @author Sebastian Diaz
 */
public class VentaVO {
  
    int id;
    String fecha_venta;
    Double total_venta;
    int id_usuario_fk;
    UsuarioVO usuarioVO;
    List<CarritoVO> detalleventas;
    private String action;

    public VentaVO() {
    }

    public VentaVO(String fecha_venta, Double total_venta,UsuarioVO usuarioVO, List<CarritoVO> detalleventas) {
        this.fecha_venta = fecha_venta;
        this.total_venta = total_venta;
        this.usuarioVO = usuarioVO;
        this.detalleventas = detalleventas;
    }
   public VentaVO(int id, String action) {
        this.id = id;
        this.action = action;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(String fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public Double getTotal_venta() {
        return total_venta;
    }

    public void setTotal_venta(Double total_venta) {
        this.total_venta = total_venta;
    }

    public int getId_usuario_fk() {
        return id_usuario_fk;
    }

    public void setId_usuario_fk(int id_usuario_fk) {
        this.id_usuario_fk = id_usuario_fk;
    }

    public UsuarioVO getUsuarioVO() {
        return usuarioVO;
    }

    public void setUsuarioVO(UsuarioVO usuarioVO) {
        this.usuarioVO = usuarioVO;
    }

    public List<CarritoVO> getDetalleventas() {
        return detalleventas;
    }

    public void setDetalleventas(List<CarritoVO> detalleventas) {
        this.detalleventas = detalleventas;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
    

}
