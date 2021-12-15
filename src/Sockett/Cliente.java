package Sockett;
import java.io.*;
import java.net.Socket;
public class Cliente implements Runnable{

    private int puerto;
    private String mensaje;

    public Cliente(int puerto, String mensaje) {
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    
    @Override
    public void run() {
        //Para el host del servidor
        final String HOST = "127.0.0.1";
        
        //Para el puerto del servidor 
        DataOutputStream salida;
        
        try {
            Socket socket = new Socket(HOST, puerto);   
            salida = new DataOutputStream(socket.getOutputStream());
            //Para enviar el mensaje
            salida.writeUTF(mensaje);
            
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
}
