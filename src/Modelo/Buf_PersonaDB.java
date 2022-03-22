
package Modelo;

import InterfaceDAO.Buf_PersonaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * @author BRYAN_CABRERA
 */
public class Buf_PersonaDB implements Buf_PersonaDAO{

    @Override
    public boolean Register(Buf_Persona persona) {
        
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Personas VALUES (?, ?, ?, ?, ?, ?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setString(1, persona.getCedula());
            pst.setString(2, persona.getNombre());
            pst.setString(3, persona.getApellido());
            pst.setString(4, persona.getCorreo());
            pst.setString(5, persona.getDireccion());
            pst.setString(6, persona.getNum_celular());
            pst.setString(7, persona.getEstado_civil());
            pst.setDate(8, persona.getFecha_Nacimiento());

            pst.executeUpdate();

            con.commit();

            Register = true;
            pst.close();
            con.close();

        } catch (SQLException e) {

            System.out.println("Error > " + e.getMessage());

            try {

                con.rollback();
            } catch (SQLException ex) {

                System.out.println("Error > " + e.getMessage());
            }
        }
        return Register;
    }

    @Override
    public List<Buf_Persona> Getter() {
     
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM personas";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("cedula"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo_electronico"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getDate("fecha_nacimiento"));
                
                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Persona persona) {
        
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;
        
        try {
            
            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE personas SET nombre=?,apellido=?,correo_electronico=?,direccion=?,celular=?,estado=? WHERE cedula=?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getCorreo());
            pst.setString(4, persona.getDireccion());
            pst.setString(5, persona.getNum_celular());
            pst.setString(6, persona.getEstado_civil());
            pst.setString(7, persona.getCedula());

            int act_2 = pst.executeUpdate();
            Update = true;

            pst.close();
            con.commit();

        } catch (SQLException e) {

            System.out.println("Error > " + e.getMessage());

            try {

                con.rollback();
            } catch (SQLException ex) {

                System.out.println("Error > " + e.getMessage());
            }
        }

        return Update;
    }

    @Override
    public boolean Delete(Buf_Persona persona) {
        
        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM personas WHERE cedula=?";

            pst = con.prepareStatement(sql);
            pst.setString(1, persona.getCedula());

            int elim = pst.executeUpdate();
            Delete = true;

            con.commit();

        } catch (SQLException e) {

            System.out.println("Error > " + e.getMessage());

            try {

                con.rollback();
            } catch (SQLException ex) {

                System.out.println("Error > " + e.getMessage());
            }
        }
        return Delete;
    }
    
    
}
