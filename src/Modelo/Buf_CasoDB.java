
package Modelo;

import InterfaceDAO.Buf_CasoDAO;
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
public class Buf_CasoDB implements Buf_CasoDAO {

    @Override
    public boolean Register(Buf_Caso caso) {
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso VALUES (?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, caso.getId_caso());
            pst.setString(2, caso.getCedula());
            pst.setString(3, caso.getCaso());
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
    public List<Buf_Caso> Getter() {
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso";

        List<Buf_Caso> Lista_caso = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso A = new Buf_Caso();
                A.setId_caso(rs.getInt("id_caso"));
                A.setCedula(rs.getString("cedula"));
                A.setCaso(rs.getString("caso"));

                Lista_caso.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_caso;

        } catch (SQLException e) {

            Logger.getLogger(Buf_CasoDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso caso) {
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso SET caso=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);
            
            pst.setString(1, caso.getCaso());
            pst.setInt(2, caso.getId_caso());

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
    public boolean Delete(Buf_Caso caso) {
        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, caso.getId_caso());

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
