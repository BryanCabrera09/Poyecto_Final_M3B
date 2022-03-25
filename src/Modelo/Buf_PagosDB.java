/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import InterfaceDAO.Buf_PagosDAO;
import java.sql.Connection;
import java.sql.Date;
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
public class Buf_PagosDB implements Buf_PagosDAO {

    @Override
    public boolean Register(Buf_Pagos pagos) {
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Pagos VALUES (?, ?, ?, ?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setInt(1, pagos.getId_pago());
            pst.setInt(2, pagos.getId_caso());
            pst.setString(3, pagos.getCedula());
            pst.setDate(4, (Date) pagos.getFecha_Pago());
            pst.setDouble(5, pagos.getAbono());
            pst.setDouble(6, pagos.getSaldo());

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
    public List<Buf_Pagos> Getter() {
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Pagos";

        List<Buf_Pagos> Lista_pagos = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Pagos A = new Buf_Pagos();
                A.setId_pago(rs.getInt("id_pago"));
                A.setId_caso(rs.getInt("id_caso"));
                A.setCedula(rs.getString("cedula"));
                A.setFecha_Pago(rs.getDate("fecha_pago"));
                A.setAbono(rs.getDouble("abono"));
                A.setSaldo(rs.getDouble("saldo"));

                Lista_pagos.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_pagos;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Pagos pagos) {
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Pagos SET fecha_pago=?,abono=?,saldo=? WHERE id_pago=?";
            pst = con.prepareStatement(sql);

            pst.setDate(1, (Date) pagos.getFecha_Pago());
            pst.setDouble(2, pagos.getAbono());
            pst.setDouble(3, pagos.getSaldo());
            pst.setInt(4, pagos.getId_pago());

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
    public boolean Delete(Buf_Pagos pagos) {
        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Pagos WHERE id_pago=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, pagos.getId_pago());

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
