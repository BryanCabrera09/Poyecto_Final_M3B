
package Modelo;

import InterfaceDAO.Buf_Caso_Visa_LoteriaDAO;
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
public class Buf_Caso_Visa_LoteriaDB implements Buf_Caso_Visa_LoteriaDAO{

    @Override
    public boolean Register(Buf_Caso_Visa_Loteria casvislote) {
        
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Visa_Loteria VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casvislote.getId_caso());
            pst.setString(2, casvislote.getCedula());
            pst.setBytes(3, casvislote.getReq_1());
            pst.setBytes(4, casvislote.getReq_2());
            pst.setBytes(5, casvislote.getReq_3());
            pst.setBytes(6, casvislote.getReq_4());
            pst.setBytes(7, casvislote.getReq_5());
            pst.setBytes(8, casvislote.getReq_6());
            pst.setBytes(9, casvislote.getReq_7());
            pst.setBytes(10, casvislote.getReq_8());
            pst.setBytes(11, casvislote.getReq_9());
            pst.setDouble(12, casvislote.getHonorarios());
            pst.setInt(13, casvislote.getNum_beneficiarios());
            pst.setString(14, casvislote.getObservacion());

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
    public List<Buf_Caso_Visa_Loteria> Getter() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Visa_Loteria";

        List<Buf_Caso_Visa_Loteria> Lista_Casvisalot = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Visa_Loteria C = new Buf_Caso_Visa_Loteria();
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
                C.setHonorarios(rs.getDouble("honorarios"));
                C.setNum_beneficiarios(rs.getInt("num_beneficiarios"));
                C.setObservacion(rs.getString("observacion"));
                Lista_Casvisalot.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casvisalot;

        } catch (SQLException e) {

            Logger.getLogger(Buf_CitaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Visa_Loteria casvislote) {
        
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {
            
            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Visa_Loteria SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,req_7=?,req_8=?,req_9=?,honorarios=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casvislote.getReq_1());
            pst.setBytes(2, casvislote.getReq_2());
            pst.setBytes(3, casvislote.getReq_3());
            pst.setBytes(4, casvislote.getReq_4());
            pst.setBytes(5, casvislote.getReq_5());
            pst.setBytes(6, casvislote.getReq_6());
            pst.setBytes(7, casvislote.getReq_7());
            pst.setBytes(8, casvislote.getReq_8());
            pst.setBytes(9, casvislote.getReq_9());
            pst.setDouble(10, casvislote.getHonorarios());
            pst.setString(11, casvislote.getObservacion());
            pst.setInt(12, casvislote.getId_caso());

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
    public boolean Delete(Buf_Caso_Visa_Loteria casvislote) {
        
        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Visa_Loteria WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casvislote.getId_caso());

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
