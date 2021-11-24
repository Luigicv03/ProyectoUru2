
package sql;
import sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class conexionbd {
    Connection  conn=null;
    String url="jdbc:postgresql://localhost:5432/proyectouru";
    String usuario="postgres";
    String clave="castel99";
    
    public Connection conectar(){
        try {
            Class.forName("org.postgresql.Driver");
            conn=DriverManager.getConnection(url,usuario,clave);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Error al conectarse"+e,"Error",JOptionPane.ERROR_MESSAGE);
        }
        return conn;
        
    }
            
}
