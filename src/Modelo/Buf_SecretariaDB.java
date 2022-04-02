/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import InterfaceDAO.Buf_SecretariaDAO;
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
public class Buf_SecretariaDB implements Buf_SecretariaDAO {

    @Override
    public boolean Register(Buf_Secretaria secre) {
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Secretarias VALUES (?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, secre.getId_secretaria());
            pst.setInt(2, secre.getId_abg());
            pst.setString(3, secre.getCedula());
            pst.setString(4, secre.getHorario());
            pst.setBytes(5, secre.getFoto());

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
    public List<Buf_Secretaria> Getter() {
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Secretarias";

        List<Buf_Secretaria> Lista_secre = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Secretaria A = new Buf_Secretaria();
                A.setId_secretaria(rs.getInt("id_secretaria"));
                A.setId_abg(rs.getInt("id_abg"));
                A.setCedula(rs.getString("ci_secre"));
                A.setHorario(rs.getString("horario"));
                A.setFoto(rs.getBytes("foto"));

                Lista_secre.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_secre;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Secretaria secre) {
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Secretarias SET horario=?,foto=? WHERE id_secretaria=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, secre.getHorario());
            pst.setBytes(2, secre.getFoto());
            pst.setInt(3, secre.getId_abg());

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
    public boolean Delete(Buf_Secretaria secre) {
        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Secretarias WHERE id_secretaria=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, secre.getId_abg());

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
