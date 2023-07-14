/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

import ModeloVO.UsuarioVO;
import Util.ConexionBD;
import Util.Validar;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sebastian Diaz
 */
public class UsuarioDAO extends ConexionBD implements Validar{
 
    private Connection conexion;
    private ResultSet mensajero;
    private PreparedStatement puente;
    private boolean operacion = false;
    private String sql;
    ConexionBD con = new ConexionBD();
    int r=0;

    public int validar(UsuarioVO usuVO) {
        sql = "Select * from usuario where correo_usuario = ? AND password = ?";
        try {
            conexion = this.obtenerConexion();
            puente = conexion.prepareStatement(sql);
            puente.setString(1, usuVO.getCorreo_usuario());
            puente.setString(2, usuVO.getPassword());
            mensajero = puente.executeQuery();
            while(mensajero.next()){
             r=r+1;
             usuVO.setCorreo_usuario(mensajero.getString("correo_usuario"));    
             usuVO.setPassword(mensajero.getString("password"));
            }
            if(r==1){
                return 1;
            }
            else {
                return 0;
            }

        } catch (SQLException e) {
            return 0;
        }
        
    }

}
