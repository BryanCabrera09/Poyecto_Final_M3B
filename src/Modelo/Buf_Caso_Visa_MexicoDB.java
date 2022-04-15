
package Modelo;

import InterfaceDAO.Buf_Caso_Visa_MexicoDAO;
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
public class Buf_Caso_Visa_MexicoDB implements Buf_Caso_Visa_MexicoDAO{

    @Override
    public boolean Register(Buf_Caso_Visa_Mexico casvisamex) {
        
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Visa_Mexico VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casvisamex.getId_caso());
            pst.setString(2, casvisamex.getCedula());
            pst.setBytes(3, casvisamex.getReq_1());
            pst.setBytes(4, casvisamex.getReq_2());
            pst.setBytes(5, casvisamex.getReq_3());
            pst.setBytes(6, casvisamex.getReq_4());
            pst.setBytes(7, casvisamex.getReq_5());
            pst.setDouble(8, casvisamex.getHonorarios());
            pst.setInt(9, casvisamex.getNum_beneficiarios());
            pst.setString(10, casvisamex.getObservacion());

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
    public List<Buf_Caso_Visa_Mexico> Getter() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Visa_Mexico";

        List<Buf_Caso_Visa_Mexico> Lista_Casvism = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Visa_Mexico C = new Buf_Caso_Visa_Mexico();
                C.setId_caso(rs.getInt("id_caso"));
                C.setCedula(rs.getString("cedula"));
                C.setReq_1(rs.getBytes("req_1"));
                C.setReq_2(rs.getBytes("req_2"));
                C.setReq_3(rs.getBytes("req_3"));
                C.setReq_4(rs.getBytes("req_4"));
                C.setReq_5(rs.getBytes("req_5"));
                C.setHonorarios(rs.getDouble("honorarios"));
                C.setNum_beneficiarios(rs.getInt("num_beneficiarios"));
                C.setObservacion(rs.getString("observacion"));
                Lista_Casvism.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casvism;

        } catch (SQLException e) {

            Logger.getLogger(Buf_Caso_Visa_MexicoDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Visa_Mexico casvisamex) {
        
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Visa_Mexico SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casvisamex.getReq_1());
            pst.setBytes(2, casvisamex.getReq_2());
            pst.setBytes(3, casvisamex.getReq_3());
            pst.setBytes(4, casvisamex.getReq_4());
            pst.setBytes(5, casvisamex.getReq_5());
            pst.setString(6, casvisamex.getObservacion());
            pst.setInt(7, casvisamex.getId_caso());

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
    public boolean Delete(Buf_Caso_Visa_Mexico casvisamex) {
        
        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Visa_Mexico WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casvisamex.getId_caso());

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
