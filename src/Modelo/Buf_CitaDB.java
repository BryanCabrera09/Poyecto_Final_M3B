/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import InterfaceDAO.Buf_CitaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Myrian
 */
public class Buf_CitaDB implements Buf_CitaDAO {

    @Override
    public boolean Register(Buf_Cita cita) {
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Citas VALUES (?, ?, ?, ?, ?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setInt(1, cita.getId_cita());
            pst.setString(2, cita.getCedula());
            pst.setString(3, cita.getNum_celular());
            pst.setString(4, cita.getDescripcion());
            pst.setString(5, cita.getNom_caso());
            pst.setInt(6, cita.getId_caso());
            pst.setString(7, cita.getHora());

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
    public List<Buf_Cita> Getter() {
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Citas";

        List<Buf_Cita> Lista_cita = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Cita C = new Buf_Cita();
                C.setId_cita(rs.getInt("id_cita"));
                C.setCedula(rs.getString("cedula"));
                C.setNum_celular(rs.getString("num_celular"));
                C.setDescripcion(rs.getString("descripcion"));
                C.setNom_caso(rs.getString("nom_caso"));
                C.setId_caso(rs.getInt("id_caso"));
                C.setHora(rs.getString("hora"));
                Lista_cita.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_cita;

        } catch (SQLException e) {

            Logger.getLogger(Buf_CitaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override//Pendiente
    public boolean Update(Buf_Cita cita) {
         boolean Update = false;
        return Update;
    }

    @Override
    public boolean Delete(Buf_Cita cita) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Citas WHERE id_cita=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, cita.getId_cita());

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
        return Delete;    }

}
