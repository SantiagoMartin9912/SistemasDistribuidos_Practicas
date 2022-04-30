package conexion;

import java.net.*;
import java.io.*;

public class ServidorSaludo {

    public static void main(String args[]) throws IOException {
        Socket socketCliente = null;
        try {
            ServerSocket socketServidor = new ServerSocket(9000);
            while (true) {
                socketCliente = socketServidor.accept();
                Conexion con = new Conexion(socketCliente);
                con.start();
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                socketCliente.close();
            } catch (IOException e2) {
            }
        }
    }

}

class Conexion extends Thread {

    private Socket socketCliente;
    private PrintWriter salida;

    public Conexion(Socket socketCliente) {
        this.socketCliente = socketCliente;
    }

    public void run() {
        try {
            salida = new PrintWriter(socketCliente.getOutputStream(), true);
            salida.println("Bienvenido al servidor");
            socketCliente.close();
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                socketCliente.close();
            } catch (IOException e2) {
            }
        }
    }

}
