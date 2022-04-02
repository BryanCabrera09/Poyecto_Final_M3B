/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import InterfaceDAO.Buf_ClienteDAO;
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
public class Buf_ClienteDB implements Buf_ClienteDAO {

    @Override
    public boolean Register(Buf_Cliente cliente) {
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Clientes VALUES (?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, cliente.getId_cliente());
            pst.setString(2, cliente.getCedula());
            pst.setString(3, cliente.getOcupacion());
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
    public List<Buf_Cliente> Getter() {
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Clientes";

        List<Buf_Cliente> Lista_cli = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Cliente A = new Buf_Cliente();
                A.setId_abg(rs.getInt("id_cliente"));
                A.setCedula(rs.getString("ci"));
                A.setOcupacion(rs.getString("ocupacion"));
                Lista_cli.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_cli;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Cliente cliente) {
boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Clientes SET ci=?,ocupacion=? WHERE id_cliente=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, cliente.getCedula());
            pst.setString(2, cliente.getOcupacion());
            pst.setInt(3, cliente.getId_cliente());

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

        return Update;    }

    @Override
    public boolean Delete(Buf_Cliente cliente) {
 boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Clientes WHERE id_cliente=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, cliente.getId_abg());

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
