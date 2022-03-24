package Modelo;

import InterfaceDAO.Buf_Caso_Visa_EuropaDAO;
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
public class Buf_Caso_Visa_EuropaDB implements Buf_Caso_Visa_EuropaDAO {

    @Override
    public boolean Register(Buf_Caso_Visa_Europa casviseuro) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Visa_Europa VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casviseuro.getId_caso());
            pst.setString(2, casviseuro.getCedula());
            pst.setBytes(3, casviseuro.getReq_1());
            pst.setBytes(4, casviseuro.getReq_2());
            pst.setBytes(5, casviseuro.getReq_3());
            pst.setBytes(6, casviseuro.getReq_4());
            pst.setBytes(7, casviseuro.getReq_5());
            pst.setBytes(8, casviseuro.getReq_6());
            pst.setBytes(9, casviseuro.getReq_7());
            pst.setBytes(10, casviseuro.getReq_8());
            pst.setBytes(11, casviseuro.getReq_9());
            pst.setBytes(12, casviseuro.getReq_10());
            pst.setBytes(13, casviseuro.getReq_11());
            pst.setBytes(14, casviseuro.getReq_12());
            pst.setBytes(15, casviseuro.getReq_13());
            pst.setBytes(16, casviseuro.getReq_14());
            pst.setBytes(17, casviseuro.getReq_15());
            pst.setBytes(18, casviseuro.getReq_16());
            pst.setBytes(19, casviseuro.getReq_17());
            pst.setDouble(20, casviseuro.getHonorarios());
            pst.setInt(21, casviseuro.getNum_beneficiarios());
            pst.setString(22, casviseuro.getObservacion());

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
    public List<Buf_Caso_Visa_Europa> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Visa_Europa";

        List<Buf_Caso_Visa_Europa> Lista_Casviseu = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Visa_Europa C = new Buf_Caso_Visa_Europa();
                C.setId_caso(rs.getInt("id_caso"));
                C.setCedula(rs.getString("cedula"));
                C.setReq_1(rs.getBytes("req_1"));
                C.setReq_2(rs.getBytes("req_2"));
                C.setReq_3(rs.getBytes("req_3"));
                C.setReq_4(rs.getBytes("req_4"));
                C.setReq_5(rs.getBytes("req_5"));
                C.setReq_6(rs.getBytes("req_6"));
                C.setReq_7(rs.getBytes("req_7"));
                C.setReq_8(rs.getBytes("req_8"));
                C.setReq_9(rs.getBytes("req_9"));
                C.setReq_10(rs.getBytes("req_10"));
                C.setReq_11(rs.getBytes("req_11"));
                C.setReq_12(rs.getBytes("req_12"));
                C.setReq_13(rs.getBytes("req_13"));
                C.setReq_14(rs.getBytes("req_14"));
                C.setReq_15(rs.getBytes("req_15"));
                C.setReq_16(rs.getBytes("req_16"));
                C.setReq_17(rs.getBytes("req_17"));
                C.setHonorarios(rs.getDouble("honorarios"));
                C.setNum_beneficiarios(rs.getInt("num_beneficiarios"));
                C.setObservacion(rs.getString("observacion"));
                Lista_Casviseu.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casviseu;

        } catch (SQLException e) {

            Logger.getLogger(Buf_CitaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Visa_Europa casviseuro) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Visa_Europa SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,req_7=?,req_8=?,req_9=?,req_10=?,req_11=?,req_12=?,req_13=?,req_14=?,req_15=?,req_16=?,req_17=?,honorarios=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casviseuro.getReq_1());
            pst.setBytes(2, casviseuro.getReq_2());
            pst.setBytes(3, casviseuro.getReq_3());
            pst.setBytes(4, casviseuro.getReq_4());
            pst.setBytes(5, casviseuro.getReq_5());
            pst.setBytes(6, casviseuro.getReq_6());
            pst.setBytes(7, casviseuro.getReq_7());
            pst.setBytes(8, casviseuro.getReq_8());
            pst.setBytes(9, casviseuro.getReq_9());
            pst.setBytes(10, casviseuro.getReq_10());
            pst.setBytes(11, casviseuro.getReq_11());
            pst.setBytes(12, casviseuro.getReq_12());
            pst.setBytes(13, casviseuro.getReq_13());
            pst.setBytes(14, casviseuro.getReq_14());
            pst.setBytes(15, casviseuro.getReq_15());
            pst.setBytes(16, casviseuro.getReq_16());
            pst.setBytes(17, casviseuro.getReq_17());
            pst.setDouble(18, casviseuro.getHonorarios());
            pst.setString(19, casviseuro.getObservacion());
            pst.setInt(20, casviseuro.getId_caso());

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
    public boolean Delete(Buf_Caso_Visa_Europa casviseuro) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Visa_Europa WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casviseuro.getId_caso());

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
