package Modelo;

import InterfaceDAO.Buf_Caso_Reporte_ConsularDAO;
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
public class Buf_Caso_Reporte_ConsularDB implements Buf_Caso_Reporte_ConsularDAO {

    @Override
    public boolean Register(Buf_Caso_Reporte_Consular casrepcons) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Reporte_Consular VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";

            pst = con.prepareStatement(sql);

            pst.setInt(1, casrepcons.getId_caso());
            pst.setString(2, casrepcons.getCedula());
            pst.setBytes(3, casrepcons.getReq_1());
            pst.setBytes(4, casrepcons.getReq_2());
            pst.setBytes(5, casrepcons.getReq_3());
            pst.setBytes(6, casrepcons.getReq_4());
            pst.setBytes(7, casrepcons.getReq_5());
            pst.setBytes(8, casrepcons.getReq_6());
            pst.setBytes(9, casrepcons.getReq_7());
            pst.setBytes(10, casrepcons.getReq_8());
            pst.setDouble(11, casrepcons.getHonorarios());
            pst.setInt(12, casrepcons.getNum_beneficiarios());
            pst.setString(13, casrepcons.getObservacion());

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
    public List<Buf_Caso_Reporte_Consular> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Reporte_Consular";

        List<Buf_Caso_Reporte_Consular> Lista_Casrepcos = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Reporte_Consular C = new Buf_Caso_Reporte_Consular();
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
                C.setHonorarios(rs.getDouble("honorarios"));
                C.setNum_beneficiarios(rs.getInt("num_beneficiarios"));
                C.setObservacion(rs.getString("observacion"));
                Lista_Casrepcos.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Casrepcos;

        } catch (SQLException e) {

            Logger.getLogger(Buf_CitaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Reporte_Consular casrepcons) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Reporte_Consular SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,req_7=?,req_8=?,honorarios=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, casrepcons.getReq_1());
            pst.setBytes(2, casrepcons.getReq_2());
            pst.setBytes(3, casrepcons.getReq_3());
            pst.setBytes(4, casrepcons.getReq_4());
            pst.setBytes(5, casrepcons.getReq_5());
            pst.setBytes(6, casrepcons.getReq_6());
            pst.setBytes(7, casrepcons.getReq_7());
            pst.setBytes(8, casrepcons.getReq_8());
            pst.setDouble(9, casrepcons.getHonorarios());
            pst.setString(10, casrepcons.getObservacion());
            pst.setInt(11, casrepcons.getId_caso());

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
    public boolean Delete(Buf_Caso_Reporte_Consular casrepcons) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Reporte_Consular WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, casrepcons.getId_caso());

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
