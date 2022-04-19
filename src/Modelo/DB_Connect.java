package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/*
 * @author BRYAN_CABRERA
 */
public class DB_Connect {

    public static Connection Connect() {

        Connection con = null;

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = (Connection) DriverManager.getConnection("jdbc:oracle:thin:@bryancabrera.ddns.net:1521:XE", "BRYAN", "0150269900");

            if (con != null) {
            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "ERROR DE CONEXION", "ERROR", JOptionPane.ERROR_MESSAGE);
            System.out.println(e.getMessage());;
        }
        return con;
    }

}
