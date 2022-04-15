
package Modelo;

import InterfaceDAO.Buf_Caso_Renovacion_PasaporteDAO;
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
public class Buf_Caso_Renovacion_PasaporteDB implements Buf_Caso_Renovacion_PasaporteDAO{

    @Override
    public boolean Register(Buf_Caso_Renovacion_Pasaporte casrenopass) {
        
        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Renovacion_Pasaporte VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casrenopass.getId_caso());
            pst.setString(2, casrenopass.getCedula());
            pst.setBytes(3, casrenopass.getReq_1());
            pst.setBytes(4, casrenopass.getReq_2());
            pst.setBytes(5, casrenopass.getReq_3());
            pst.setBytes(6, casrenopass.getReq_4());
            pst.setBytes(7, casrenopass.getReq_5());
            pst.setBytes(8, casrenopass.getReq_6());
            pst.setDouble(9, casrenopass.getHonorarios());
            pst.setInt(10, casrenopass.getNum_beneficiarios());
            pst.setString(11, casrenopass.getObservacion());

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
    public List<Buf_Caso_Renovacion_Pasaporte> Getter() {
        
        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Renovacion_Pasaporte";

        List<Buf_Caso_Renovacion_Pasaporte> Lista_Casrenopas = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Renovacion_Pasaporte C = new Buf_Caso_Renovacion_Pasaporte();
                C.setId_caso(rs.getInt("id_caso"));
                C.setCedula(rs.getString("cedula"));
                C.setReq_1(rs.getBytes("req_1"));
                C.setReq_2(rs.getBytes("req_2"));
                C.setReq_3(rs.getBytes("req_3"));
                C.setReq_4(rs.getBytes("req_4"));
                C.setReq_5(rs.getBytes("req_5"));
                C.setReq_6(rs.getBytes("req_6"));
                C.setHonorarios(rs.getDouble("honorarios"));
                C.setNum_beneficiarios(rs.getInt("num_beneficiarios"));
                C.setObservacion(rs.getString("observacion"));
                Lista_Casrenopas.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casrenopas;

        } catch (SQLException e) {

            Logger.getLogger(Buf_Caso_Renovacion_PasaporteDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Renovacion_Pasaporte casrenopass) {
        
        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Renovacion_Pasaporte SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casrenopass.getReq_1());
            pst.setBytes(2, casrenopass.getReq_2());
            pst.setBytes(3, casrenopass.getReq_3());
            pst.setBytes(4, casrenopass.getReq_4());
            pst.setBytes(5, casrenopass.getReq_5());
            pst.setBytes(6, casrenopass.getReq_6());
            pst.setString(7, casrenopass.getObservacion());
            pst.setInt(8, casrenopass.getId_caso());

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
    public boolean Delete(Buf_Caso_Renovacion_Pasaporte casrenopass) {
        
        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Renovacion_Pasaporte WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casrenopass.getId_caso());

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
