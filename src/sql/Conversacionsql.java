package sql;

import java.sql.Connection;
import Buscador.Variables;
import java.sql.Connection;
import javax.swing.JOptionPane;

public class Conversacionsql extends conexionbd implements Conversacion{
java.sql.Statement st;
    @Override
    public void registarconversaciona(String mensaje) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "Insert into conversaciones(conversacionb) values(?);";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro NO se guardo correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);

        }
    }

    @Override
    public void registarconversacionb(String mensaje) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "Insert into conversaciones(conversacionb) values(?);";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro NO se guardo correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);

        }
    }
    
    
}
