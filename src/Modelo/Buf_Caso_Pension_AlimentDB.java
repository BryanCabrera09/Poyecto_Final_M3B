
package Modelo;

import InterfaceDAO.Buf_Caso_Pension_AlimentDAO;
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
public class Buf_Caso_Pension_AlimentDB implements Buf_Caso_Pension_AlimentDAO{

    @Override
    public boolean Register(Buf_Caso_Pension_Aliment caspenali) {
        
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Pension_Aliment VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, caspenali.getId_caso());
            pst.setString(2, caspenali.getCedula());
            pst.setBytes(3, caspenali.getReq_1());
            pst.setBytes(4, caspenali.getReq_2());
            pst.setBytes(5, caspenali.getReq_3());
            pst.setBytes(6, caspenali.getReq_4());
            pst.setBytes(7, caspenali.getReq_5());
            pst.setBytes(8, caspenali.getReq_6());
            pst.setDouble(9, caspenali.getHonorarios());
            pst.setString(10, caspenali.getObservacion());

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
    public List<Buf_Caso_Pension_Aliment> Getter() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Pension_Aliment";

        List<Buf_Caso_Pension_Aliment> Lista_Caspension = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Pension_Aliment C = new Buf_Caso_Pension_Aliment();
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
                Lista_Caspension.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Caspension;

        } catch (SQLException e) {

            Logger.getLogger(Buf_Caso_Pension_AlimentDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Pension_Aliment caspenali) {
        
         boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Pension_Aliment SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,honorarios=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, caspenali.getReq_1());
            pst.setBytes(2, caspenali.getReq_2());
            pst.setBytes(3, caspenali.getReq_3());
            pst.setBytes(4, caspenali.getReq_4());
            pst.setBytes(5, caspenali.getReq_5());
            pst.setBytes(6, caspenali.getReq_6());
            pst.setDouble(7, caspenali.getHonorarios());
            pst.setString(8, caspenali.getObservacion());
            pst.setInt(9, caspenali.getId_caso());

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
    public boolean Delete(Buf_Caso_Pension_Aliment caspenali) {
        
        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Pension_Aliment WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, caspenali.getId_caso());

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
