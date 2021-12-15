package Sockett;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

public class Servidor extends Observable implements Runnable {

    private int puerto;

    public Servidor(int puerto) {
        this.puerto = puerto;
    }

    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket socket = null;
        DataInputStream entrada;

        try {
            //Para crear el servidor
            servidor = new ServerSocket(puerto);
            System.out.println("El servidor arranco");

            //bucle infinido para peticiones
            while (true) {
                //Aceptar al cliente cuando se conecte  
                socket = servidor.accept();
                System.out.println("Cliente aceptado");
                entrada = new DataInputStream(socket.getInputStream());

                //Para leer el mensaje
                String mensaje = entrada.readUTF();
                System.out.println(mensaje);

                //Para cambiar, notificar y limpiar
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();

                socket.close();
                System.out.println("Se desconecto");
            } 

        } catch (IOException e) {
            System.out.println(e);
        }

    }

}
