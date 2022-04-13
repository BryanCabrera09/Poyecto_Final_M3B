package Modelo;

import InterfaceDAO.Buf_Caso_DivorcioDAO;
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
public class Buf_Caso_DivorcioDB implements Buf_Caso_DivorcioDAO {

    @Override
    public boolean Register(Buf_Caso_Divorcio casdivor) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Divorcio VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casdivor.getId_caso());
            pst.setString(2, casdivor.getCedula());
            pst.setBytes(3, casdivor.getReq_1());
            pst.setBytes(4, casdivor.getReq_2());
            pst.setBytes(5, casdivor.getReq_3());
            pst.setBytes(6, casdivor.getReq_4());
            pst.setBytes(7, casdivor.getReq_5());
            pst.setBytes(8, casdivor.getReq_6());
            pst.setDouble(9, casdivor.getHonorarios());
            pst.setString(10, casdivor.getObservacion());

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
    public List<Buf_Caso_Divorcio> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Divorcio";

        List<Buf_Caso_Divorcio> Lista_Casdir = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Divorcio C = new Buf_Caso_Divorcio();
                C.setId_caso(rs.getInt("id_caso"));
                C.setCedula(rs.getString("cedula"));
                C.setReq_1(rs.getBytes("req_1"));
                C.setReq_2(rs.getBytes("req_2"));
                C.setReq_3(rs.getBytes("req_3"));
                C.setReq_4(rs.getBytes("req_4"));
                C.setReq_5(rs.getBytes("req_5"));
                C.setReq_6(rs.getBytes("req_6"));
                C.setHonorarios(rs.getDouble("honorarios"));
                C.setObservacion(rs.getString("observacion"));
                Lista_Casdir.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casdir;

        } catch (SQLException e) {

            Logger.getLogger(Buf_Caso_DivorcioDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Divorcio casdivor) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Divorcio SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,honorarios=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casdivor.getReq_1());
            pst.setBytes(2, casdivor.getReq_2());
            pst.setBytes(3, casdivor.getReq_3());
            pst.setBytes(4, casdivor.getReq_4());
            pst.setBytes(5, casdivor.getReq_5());
            pst.setBytes(6, casdivor.getReq_6());
            pst.setDouble(7, casdivor.getHonorarios());
            pst.setString(8, casdivor.getObservacion());
            pst.setInt(9, casdivor.getId_caso());

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
    public boolean Delete(Buf_Caso_Divorcio casdivor) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Divorcio WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casdivor.getId_caso());

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
