package saludoservidorudp;

import java.net.*;
import java.io.*;

public class ServidorSaludoUDP {

    private static byte[] buffer;
    private static byte[] datos;

    public static void main(String args[]) {
        try {
            DatagramSocket socket = new DatagramSocket(9000);
            buffer = new byte[1024];
            while (true) {
                DatagramPacket datagrama = new DatagramPacket(buffer,
                         buffer.length);

                socket.receive(datagrama);

                InetAddress hostDestino = datagrama.getAddress();

                int puertoDestino = datagrama.getPort();

                datos = datagrama.getData();

                String cadena = new String(datos, 0, datos.length);

                System.out.println("Bienvenido al servidor. Envío por el puerto "
                        + puertoDestino + " el mensaje: " + cadena);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
