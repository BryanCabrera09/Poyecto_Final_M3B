
package Modelo;

import InterfaceDAO.Buf_Admin_UserDAO;
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
public class Buf_Admin_UserDB implements Buf_Admin_UserDAO{

    @Override
    public boolean Register(Buf_Admin_User useradmin) {
        
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Admin_User VALUES (?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setString(1, useradmin.getCedula());
            pst.setString(2, useradmin.getUsuario());
            pst.setString(3, useradmin.getContrasenia());

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

                System.out.println("Error > " + ex.getMessage());
            }
        }
        return Register;
    }

    @Override
    public List<Buf_Admin_User> Getter() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Admin_User";

        List<Buf_Admin_User> Lista_Admins = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Admin_User P = new Buf_Admin_User();
                P.setCedula(rs.getString("cedula"));
                P.setUsuario(rs.getString("usuario"));
                P.setContrasenia(rs.getString("contraseña"));

                Lista_Admins.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Admins;

        } catch (SQLException e) {

            Logger.getLogger(Buf_Admin_UserDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Admin_User useradmin) {
        
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Admin_User SET usuario=?,contraseña=? WHERE cedula=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, useradmin.getUsuario());
            pst.setString(2, useradmin.getContrasenia());
            pst.setString(3, useradmin.getCedula());

            int act_2 = pst.executeUpdate();
            Update = true;

            pst.close();
            con.commit();

        } catch (SQLException e) {

            System.out.println("Error > " + e.getMessage());

            try {

                con.rollback();
            } catch (SQLException ex) {

                System.out.println("Error > " + ex.getMessage());
            }
        }

        return Update;
    }

    @Override
    public boolean Delete(Buf_Admin_User useradmin) {
        
         boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Admin_User WHERE cedula=?";

            pst = con.prepareStatement(sql);
            pst.setString(1, useradmin.getCedula());

            int elim = pst.executeUpdate();
            Delete = true;

            con.commit();

        } catch (SQLException e) {

            System.out.println("Error > " + e.getMessage());

            try {

                con.rollback();
            } catch (SQLException ex) {

                System.out.println("Error > " + ex.getMessage());
            }
        }
        return Delete;
    }
    
    
}
