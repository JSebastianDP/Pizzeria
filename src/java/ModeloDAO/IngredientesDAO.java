/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.IngredientesVO;
import Util.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Diaz
 */
public class IngredientesDAO extends ConexionBD {

    public IngredientesDAO() {
    }
    
    private Connection conexion;
    private PreparedStatement puente;
    private ResultSet mensajero;
    private String sql;
    
    private String id_ingrediente="", nombre_ingrediente="";

    public IngredientesDAO(IngredientesVO ingVO) {
        super();
        try {
            conexion = this.obtenerConexion();
            id_ingrediente = ingVO.getId_ingredientes();
            nombre_ingrediente = ingVO.getNombre_ingredientes();
            
        } catch (Exception e) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, e);
        }

    }
    
    
     public ArrayList<IngredientesVO>Ingredientes() { 
        ArrayList<IngredientesVO> ListarIngredientes = new ArrayList<>();
        try {
            conexion = this.obtenerConexion();
            sql = "select * from ingredientes";
            puente = conexion.prepareStatement(sql);
            mensajero = puente.executeQuery();

            while (mensajero.next()) {
                IngredientesVO ingVO = new IngredientesVO(mensajero.getString(1), mensajero.getString(2));
                ListarIngredientes.add(ingVO);
            }
        } catch (SQLException e) {
            Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, e);
        } finally {

            try {

                this.cerrarConexion();
            } catch (SQLException e) {
                Logger.getLogger(IngredientesDAO.class.getName()).log(Level.SEVERE, null, e);

            }
        }
        return ListarIngredientes;
    }
    
}
