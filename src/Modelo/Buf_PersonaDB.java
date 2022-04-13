package Modelo;

import InterfaceDAO.Buf_PersonaDAO;
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
public class Buf_PersonaDB implements Buf_PersonaDAO {

    @Override
    public boolean Register(Buf_Persona persona) {

        boolean Register = false;

        PreparedStatement pst = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            con.setAutoCommit(false);

            String sql = "INSERT INTO Buf_Persona VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

            pst = con.prepareStatement(sql);

            pst.setString(1, persona.getCedula());
            pst.setString(2, persona.getNombre());
            pst.setString(3, persona.getApellido());
            pst.setString(4, persona.getCorreo());
            pst.setString(5, persona.getDireccion());
            pst.setString(6, persona.getNum_celular());
            pst.setString(7, persona.getEstado_civil());
            pst.setString(8, persona.getFecha_Nacimiento());

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
    public List<Buf_Persona> Getter() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Buf_Persona";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("ci"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("Num_Celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));

                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public boolean Update(Buf_Persona persona) {

        boolean Update = false;

        Connection con = null;
        PreparedStatement pst = null;

        try {

            Statement st = null;
            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "UPDATE Buf_Persona SET nombre=?,apellido=?,correo=?,direccion=?,num_celular=?,estado=? WHERE ci=?";
            pst = con.prepareStatement(sql);

            pst.setString(1, persona.getNombre());
            pst.setString(2, persona.getApellido());
            pst.setString(3, persona.getCorreo());
            pst.setString(4, persona.getDireccion());
            pst.setString(5, persona.getNum_celular());
            pst.setString(6, persona.getEstado_civil());
            pst.setString(7, persona.getCedula());

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
    public boolean Delete(Buf_Persona persona) {

        boolean Delete = false;

        PreparedStatement pst = null;
        Statement st = null;
        Connection con = null;

        try {

            con = DB_Connect.Connect();

            st = con.createStatement();

            con.setAutoCommit(false);

            String sql = "DELETE FROM Buf_Persona WHERE ci=?";

            pst = con.prepareStatement(sql);
            pst.setString(1, persona.getCedula());

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

    @Override
    public List<Buf_Persona> Search_Abg(String Identificador) {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT P.Ci, P.Nombre, P.Apellido, P.Correo, P.Direccion, P.Num_Celular, P.Estado, P.Fecha_Nacimiento FROM Buf_Persona P JOIN Buf_Abogados A ON P.Ci = A.Ci_Abg WHERE ci LIKE '" + Identificador + "%'";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("ci"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("Num_Celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));

                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<Buf_Persona> Search_Secre(String Identificador) {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT P.Ci, P.Nombre, P.Apellido, P.Correo, P.Direccion, P.Num_Celular, P.Estado, P.Fecha_Nacimiento FROM Buf_Persona P JOIN Buf_Secretarias S ON P.Ci = S.Ci_Secre WHERE ci LIKE '" + Identificador + "%'";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("ci"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("Num_Celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));

                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<Buf_Persona> Getter_Secre() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT P.Ci, P.Nombre, P.Apellido, P.Correo, P.Direccion, P.Num_Celular, P.Estado, P.Fecha_Nacimiento FROM Buf_Persona P JOIN Buf_Secretarias S ON P.Ci = S.Ci_Secre";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("ci"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("Num_Celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));

                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<Buf_Persona> Getter_Abg() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT P.Ci, P.Nombre, P.Apellido, P.Correo, P.Direccion, P.Num_Celular, P.Estado, P.Fecha_Nacimiento FROM Buf_Persona P JOIN Buf_Abogados A ON P.Ci = A.Ci_Abg";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("ci"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("Num_Celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));

                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<Buf_Persona> Getter_Cliente() {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT P.Ci, P.Nombre, P.Apellido, P.Correo, P.Direccion, P.Num_Celular, P.Estado, P.Fecha_Nacimiento FROM Buf_Persona P JOIN Buf_Clientes C ON P.Ci = C.ci";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("ci"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("Num_Celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));

                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    @Override
    public List<Buf_Persona> Search_Cliente(String Identificador) {

        Statement st = null;
        Connection con = null;
        ResultSet rs = null;

        String sql = "SELECT P.Ci, P.Nombre, P.Apellido, P.Correo, P.Direccion, P.Num_Celular, P.Estado, P.Fecha_Nacimiento FROM Buf_Persona P JOIN Buf_Clientes C ON P.Ci = C.ci WHERE P.ci LIKE '" + Identificador + "%'";

        List<Buf_Persona> Lista_Per = new ArrayList<>();

        try {

            con = DB_Connect.Connect();
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {

                Buf_Persona P = new Buf_Persona();
                P.setCedula(rs.getString("ci"));
                P.setNombre(rs.getString("nombre"));
                P.setApellido(rs.getString("apellido"));
                P.setCorreo(rs.getString("correo"));
                P.setDireccion(rs.getString("direccion"));
                P.setNum_celular(rs.getString("Num_Celular"));
                P.setEstado_civil(rs.getString("estado"));
                P.setFecha_Nacimiento(rs.getString("fecha_nacimiento"));

                Lista_Per.add(P);
            }
            st.close();
            con.close();
            rs.close();
            return Lista_Per;

        } catch (SQLException e) {

            Logger.getLogger(Buf_PersonaDB.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
