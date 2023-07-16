/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloVO;

import java.io.InputStream;

/**
 *
 * @author Sebastian Diaz
 */
public class ProductoVO {
    
    int id;
    String nombre_producto;
    double precio_producto;
    int cantidad_producto;
    InputStream foto;
    String id_producto;
    String imagen;

    public ProductoVO() {
    }

    public ProductoVO(int id, String nombre_producto, double precio_producto, int cantidad_producto, InputStream foto, String id_producto, String imagen) {
        this.id = id;
        this.nombre_producto = nombre_producto;
        this.precio_producto = precio_producto;
        this.cantidad_producto = cantidad_producto;
        this.foto = foto;
        this.id_producto = id_producto;
        this.imagen = imagen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre_producto() {
        return nombre_producto;
    }

    public void setNombre_producto(String nombre_producto) {
        this.nombre_producto = nombre_producto;
    }

    public double getPrecio_producto() {
        return precio_producto;
    }

    public void setPrecio_producto(double precio_producto) {
        this.precio_producto = precio_producto;
    }

    public int getCantidad_producto() {
        return cantidad_producto;
    }

    public void setCantidad_producto(int cantidad_producto) {
        this.cantidad_producto = cantidad_producto;
    }

    public InputStream getFoto() {
        return foto;
    }

    public void setFoto(InputStream foto) {
        this.foto = foto;
    }

    public String getId_producto() {
        return id_producto;
    }

    public void setId_producto(String id_producto) {
        this.id_producto = id_producto;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
}
