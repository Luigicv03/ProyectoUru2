package sql;

import Buscador.Variables;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;

public class ProyectoBD extends conexionbd {

    java.sql.Statement st;
    ResultSet rs;
    Variables var = new Variables();

    public void insertar(String nombre, String apellido, String pais, String estadocivil, String trabajo, String sexo) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "Insert into usuarios(nombre,apellido,pais,estadocivil,trabajo,sexo) values('" + nombre + "','" + apellido + "','" + pais + "','" + estadocivil + "','" + trabajo + "','" + sexo + "');";
            st.execute(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se guardo correctamente", "Mensaje", JOptionPane.INFORMATION_MESSAGE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro NO se guardo correctamente" + e, "Mensaje", JOptionPane.ERROR_MESSAGE);

        }
    }

    public void mostrar(String idusuario) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "select * from usuarios where idusuario='" + idusuario + "';";
            rs = st.executeQuery(sql);
            if (rs.next()) {

                var.setIdusuario(rs.getString("idusuario"));
                var.setNombre(rs.getString("nombre"));
                var.setApellido(rs.getString("apellido"));
                var.setPais(rs.getString("pais"));
                var.setEstadocivil(rs.getString("estadocivil"));
                var.setTrabajo(rs.getString("trabajo"));
                var.setSexo(rs.getString("sexo"));

            } else {
                var.setIdusuario("");
                var.setNombre("");
                var.setApellido("");
                var.setPais("");
                var.setEstadocivil("");
                var.setTrabajo("");
                var.setSexo("");
                JOptionPane.showMessageDialog(null, "No se encontro registro", "Sin registro", JOptionPane.INFORMATION_MESSAGE);
            }
            st.close();
            conexion.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR EN EL BUSCADOR", "ERROR FATAL", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void o(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void actualizar(String nombre, String apellido, String pais, String estadocivil, String trabajo, String sexo, String idusuario) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "update usuarios set nombre='" + nombre + "',apellido='" + apellido + "',pais='" + pais + "',estadocivil='" + estadocivil + "',trabajo='" + trabajo + "',sexo='" + sexo + "' where idusuario='" + idusuario + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se actualizo correctamente", "PERFECTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro NO SE actualizo correctamente" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }

    public void eliminar(String idusuario) {
        try {
            Connection conexion = conectar();
            st = conexion.createStatement();
            String sql = "delete from usuarios where idusuario='" + idusuario + "'; ";
            st.executeUpdate(sql);
            st.close();
            conexion.close();
            JOptionPane.showMessageDialog(null, "El registro se elimino correctamente", "PERFECTO", JOptionPane.INFORMATION_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "El registro NO SE elimino correctamente" + e, "ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }
}
