package clienteudp;

import java.net.*;
import java.io.*;
import java.util.*;

public class ClienteUDP {

    private byte[] buffer;
    private static String cadena = "Enviando datagrama en la fecha: " + new Date();

    public static void main(String args[]) {
        try {
            byte[] buffer = cadena.getBytes();
            InetAddress destino = InetAddress.getByName("localhost");
            DatagramPacket datagrama = new DatagramPacket(buffer, buffer.length,
                    destino, 9000);
            DatagramSocket socket = new DatagramSocket();
            socket.send(datagrama);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
