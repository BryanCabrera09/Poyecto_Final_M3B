package Modelo;

import InterfaceDAO.Buf_Caso_Visa_EEUUDAO;
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
public class Buf_Caso_Visa_EEUUDB implements Buf_Caso_Visa_EEUUDAO {

    @Override
    public boolean Register(Buf_Caso_Visa_EEUU casviseeuu) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Visa_Eeuu VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casviseeuu.getId_caso());
            pst.setString(2, casviseeuu.getCedula());
            pst.setBytes(3, casviseeuu.getReq_1());
            pst.setBytes(4, casviseeuu.getReq_2());
            pst.setBytes(5, casviseeuu.getReq_3());
            pst.setBytes(6, casviseeuu.getReq_4());
            pst.setBytes(7, casviseeuu.getReq_5());
            pst.setBytes(8, casviseeuu.getReq_6());
            pst.setBytes(9, casviseeuu.getReq_7());
            pst.setBytes(10, casviseeuu.getReq_8());
            pst.setBytes(11, casviseeuu.getReq_9());
            pst.setBytes(12, casviseeuu.getReq_10());
            pst.setBytes(13, casviseeuu.getReq_11());
            pst.setDouble(14, casviseeuu.getHonorarios());
            pst.setInt(15, casviseeuu.getNum_beneficiarios());
            pst.setString(16, casviseeuu.getObservacion());

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
    public List<Buf_Caso_Visa_EEUU> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Visa_Eeuu";

        List<Buf_Caso_Visa_EEUU> Lista_Casvisaeeuu = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Visa_EEUU C = new Buf_Caso_Visa_EEUU();
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
                C.setHonorarios(rs.getDouble("honorarios"));
                C.setNum_beneficiarios(rs.getInt("num_beneficiarios"));
                C.setObservacion(rs.getString("observacion"));
                Lista_Casvisaeeuu.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casvisaeeuu;

        } catch (SQLException e) {

            Logger.getLogger(Buf_CitaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Visa_EEUU casviseeuu) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Visa_Eeuu SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,req_7=?,req_8=?,req_9=?,req_10=?,req_11=?,honorarios=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casviseeuu.getReq_1());
            pst.setBytes(2, casviseeuu.getReq_2());
            pst.setBytes(3, casviseeuu.getReq_3());
            pst.setBytes(4, casviseeuu.getReq_4());
            pst.setBytes(5, casviseeuu.getReq_5());
            pst.setBytes(6, casviseeuu.getReq_6());
            pst.setBytes(7, casviseeuu.getReq_7());
            pst.setBytes(8, casviseeuu.getReq_8());
            pst.setBytes(9, casviseeuu.getReq_9());
            pst.setBytes(10, casviseeuu.getReq_10());
            pst.setBytes(11, casviseeuu.getReq_11());
            pst.setDouble(12, casviseeuu.getHonorarios());
            pst.setString(13, casviseeuu.getObservacion());
            pst.setInt(14, casviseeuu.getId_caso());

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
    public boolean Delete(Buf_Caso_Visa_EEUU casviseeuu) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Visa_Eeuu WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casviseeuu.getId_caso());

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
