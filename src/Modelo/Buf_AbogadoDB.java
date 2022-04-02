package Modelo;

import InterfaceDAO.Buf_AbogadoDAO;
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
public class Buf_AbogadoDB implements Buf_AbogadoDAO {

    @Override
    public boolean Register(Buf_Abogado abg) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Abogados VALUES (?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, abg.getId_abg());
            pst.setInt(2, abg.getNum_matricula());
            pst.setString(3, abg.getCedula());
            pst.setInt(4, abg.getNum_cuenta());
            pst.setString(5, abg.getHorario());
            pst.setBytes(6, abg.getFoto());

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
    public List<Buf_Abogado> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Abogados";

        List<Buf_Abogado> Lista_Abg = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Abogado A = new Buf_Abogado();
                A.setId_abg(rs.getInt("id_abogado"));
                A.setNum_matricula(rs.getInt("num_matricula"));
                A.setCedula(rs.getString("ci_abg"));
                A.setNum_cuenta(rs.getInt("num_cuenta"));
                A.setHorario(rs.getString("horario"));
                A.setFoto(rs.getBytes("foto"));

                Lista_Abg.add(A);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Abg;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Abogado abg) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Abogados SET num_cuenta=?,horario=?,foto=? WHERE id_abogado=?";
            pst = con.prepareStatement(sql);

            pst.setInt(1, abg.getNum_cuenta());
            pst.setString(2, abg.getHorario());
            pst.setBytes(3, abg.getFoto());
            pst.setInt(4, abg.getId_abg());

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
    public boolean Delete(Buf_Abogado abg) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Abogados WHERE id_abogado=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, abg.getId_abg());

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
