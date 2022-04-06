package Modelo;

import InterfaceDAO.Buf_UsuarioDAO;
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
public class Buf_UsuariosDB implements Buf_UsuarioDAO {

    @Override
    public boolean Register(Buf_Usuarios user) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Usuarios VALUES (?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, user.getId_User());
            pst.setString(2, user.getCedula());
            pst.setString(3, user.getUsuario());
            pst.setString(4, user.getContrasenia());

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
    public List<Buf_Usuarios> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Usuarios";

        List<Buf_Usuarios> Lista_user = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Usuarios A = new Buf_Usuarios();
                A.setId_User(rs.getInt("id_user"));
                A.setCedula(rs.getString("ci_user"));
                A.setUsuario(rs.getString("usuario"));
                A.setContrasenia(rs.getString("Contraseña"));

                Lista_user.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_user;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Usuarios user) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Usuarios SET usuario=?,contraseña=? WHERE id_user=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, user.getUsuario());
            pst.setString(2, user.getContrasenia());
            pst.setInt(3, user.getId_User());

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
    public boolean Delete(Buf_Usuarios user) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Usuarios WHERE id_user=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, user.getId_User());

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
