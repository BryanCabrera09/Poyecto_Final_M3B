package Modelo;

import InterfaceDAO.Buf_Caso_Retornante_InmigranteDAO;
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
public class Buf_Caso_Retornante_InmigranteDB implements Buf_Caso_Retornante_InmigranteDAO {

    @Override
    public boolean Register(Buf_Caso_Retornante_Inmigrante casretinmi) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Retornante_Inmigrante VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casretinmi.getId_caso());
            pst.setString(2, casretinmi.getCedula());
            pst.setBytes(3, casretinmi.getReq_1());
            pst.setBytes(4, casretinmi.getReq_2());
            pst.setBytes(5, casretinmi.getReq_3());
            pst.setBytes(6, casretinmi.getReq_4());
            pst.setBytes(7, casretinmi.getReq_5());
            pst.setBytes(8, casretinmi.getReq_6());
            pst.setDouble(9, casretinmi.getHonorarios());
            pst.setInt(10, casretinmi.getNum_beneficiarios());
            pst.setString(11, casretinmi.getObservacion());

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
    public List<Buf_Caso_Retornante_Inmigrante> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Retornante_Inmigrante";

        List<Buf_Caso_Retornante_Inmigrante> Lista_Casretinmi = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Retornante_Inmigrante C = new Buf_Caso_Retornante_Inmigrante();
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
                Lista_Casretinmi.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casretinmi;

        } catch (SQLException e) {

            Logger.getLogger(Buf_CitaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Retornante_Inmigrante casretinmi) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Retornante_Inmigrante SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,honorarios=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casretinmi.getReq_1());
            pst.setBytes(2, casretinmi.getReq_2());
            pst.setBytes(3, casretinmi.getReq_3());
            pst.setBytes(4, casretinmi.getReq_4());
            pst.setBytes(5, casretinmi.getReq_5());
            pst.setBytes(6, casretinmi.getReq_6());
            pst.setDouble(7, casretinmi.getHonorarios());
            pst.setString(8, casretinmi.getObservacion());
            pst.setInt(9, casretinmi.getId_caso());

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
    public boolean Delete(Buf_Caso_Retornante_Inmigrante casretinmi) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Retornante_Inmigrante WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casretinmi.getId_caso());

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
