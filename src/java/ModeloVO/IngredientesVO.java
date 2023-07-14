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
public class IngredientesVO {
    String id_ingredientes, nombre_ingredientes;

    public IngredientesVO() {
    }

    public IngredientesVO(String id_ingredientes, String nombre_ingredientes) {
        this.id_ingredientes = id_ingredientes;
        this.nombre_ingredientes = nombre_ingredientes;
    }

    public String getId_ingredientes() {
        return id_ingredientes;
    }

    public void setId_ingredientes(String id_ingredientes) {
        this.id_ingredientes = id_ingredientes;
    }

    public String getNombre_ingredientes() {
        return nombre_ingredientes;
    }

    public void setNombre_ingredientes(String nombre_ingredientes) {
        this.nombre_ingredientes = nombre_ingredientes;
    }
    
}
