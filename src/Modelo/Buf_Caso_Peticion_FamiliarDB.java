package Modelo;

import InterfaceDAO.Buf_Caso_Peticion_FamiliarDAO;
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
public class Buf_Caso_Peticion_FamiliarDB implements Buf_Caso_Peticion_FamiliarDAO {

    @Override
    public boolean Register(Buf_Caso_Peticion_Familiar caspetfami) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Caso_Peticion_Familiar VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setInt(1, caspetfami.getId_caso());
            pst.setString(2, caspetfami.getCedula());
            pst.setBytes(3, caspetfami.getReq_1());
            pst.setBytes(4, caspetfami.getReq_2());
            pst.setBytes(5, caspetfami.getReq_3());
            pst.setBytes(6, caspetfami.getReq_4());
            pst.setBytes(7, caspetfami.getReq_5());
            pst.setBytes(8, caspetfami.getReq_6());
            pst.setBytes(9, caspetfami.getReq_7());
            pst.setBytes(10, caspetfami.getReq_8());
            pst.setBytes(11, caspetfami.getReq_9());
            pst.setDouble(12, caspetfami.getHonorarios());
            pst.setInt(13, caspetfami.getNum_beneficiarios());
            pst.setString(14, caspetfami.getObservacion());

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
    public List<Buf_Caso_Peticion_Familiar> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Caso_Peticion_Familiar";

        List<Buf_Caso_Peticion_Familiar> Lista_Caspetfam = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Caso_Peticion_Familiar C = new Buf_Caso_Peticion_Familiar();
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
                Lista_Caspetfam.add(C);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Caspetfam;

        } catch (SQLException e) {

            Logger.getLogger(Buf_Caso_Peticion_FamiliarDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Caso_Peticion_Familiar caspetfami) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Caso_Peticion_Familiar SET req_1=?,req_2=?,req_3=?,req_4=?,req_5=?,req_6=?,req_7=?,req_8=?,req_9=?,observacion=? WHERE id_caso=?";
            pst = con.prepareStatement(sql);

            pst.setBytes(1, caspetfami.getReq_1());
            pst.setBytes(2, caspetfami.getReq_2());
            pst.setBytes(3, caspetfami.getReq_3());
            pst.setBytes(4, caspetfami.getReq_4());
            pst.setBytes(5, caspetfami.getReq_5());
            pst.setBytes(6, caspetfami.getReq_6());
            pst.setBytes(7, caspetfami.getReq_7());
            pst.setBytes(8, caspetfami.getReq_8());
            pst.setBytes(9, caspetfami.getReq_9());
            pst.setString(10, caspetfami.getObservacion());
            pst.setInt(11, caspetfami.getId_caso());

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
    public boolean Delete(Buf_Caso_Peticion_Familiar caspetfami) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Caso_Peticion_Familiar WHERE id_caso=?";

            pst = con.prepareStatement(sql);
            pst.setInt(1, caspetfami.getId_caso());

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
