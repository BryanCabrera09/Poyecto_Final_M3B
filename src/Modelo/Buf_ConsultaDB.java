/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import InterfaceDAO.Buf_ConsultaDAO;
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
public class Buf_ConsultaDB implements Buf_ConsultaDAO {

    @Override
    public boolean Register(Buf_Consulta consulta) {
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Consultas VALUES (?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, consulta.getId_consulta());
            pst.setString(2, consulta.getNombre());
            pst.setString(3, consulta.getApellido());
            pst.setString(4, consulta.getNum_celular());
            pst.setString(5, consulta.getDescripcion());
            pst.setString(6, consulta.getCaso());
            pst.setString(7, consulta.getHora());

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
    public List<Buf_Consulta> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Consultas";

        List<Buf_Consulta> Lista_consulta = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Consulta A = new Buf_Consulta();
                A.setId_consulta(rs.getInt("id_consulta"));
                A.setNombre(rs.getString("nombre"));
                A.setApellido(rs.getString("apellido"));
                A.setNum_celular(rs.getString("celular"));
                A.setDescripcion(rs.getString("descripcion"));
                A.setCaso(rs.getString("caso"));
                A.setHora(rs.getString("hora"));

                Lista_consulta.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_consulta;

        } catch (SQLException e) {

            Logger.getLogger(Buf_ConsultaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Consulta consulta) {
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Consultas SET nombre=?,apellido=?,celular=?,descripcion=?,hora=? WHERE id_consulta=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, consulta.getNombre());
            pst.setString(2, consulta.getApellido());
            pst.setString(3, consulta.getNum_celular());
            pst.setString(4, consulta.getDescripcion());
            pst.setString(5, consulta.getHora());
            pst.setInt(6, consulta.getId_consulta());

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
    public boolean Delete(Buf_Consulta consulta) {
        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Consultas WHERE id_consulta=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, consulta.getId_consulta());

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

    @Override
    public List<Buf_Consulta> Search(String Identificador) {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Consultas WHERE apellido LIKE '%" + Identificador + "%'";

        List<Buf_Consulta> Lista_consulta = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Consulta A = new Buf_Consulta();
                A.setId_consulta(rs.getInt("id_consulta"));
                A.setNombre(rs.getString("nombre"));
                A.setApellido(rs.getString("apellido"));
                A.setNum_celular(rs.getString("celular"));
                A.setDescripcion(rs.getString("descripcion"));
                A.setCaso(rs.getString("caso"));
                A.setHora(rs.getString("hora"));

                Lista_consulta.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_consulta;

        } catch (SQLException e) {

            Logger.getLogger(Buf_ConsultaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
