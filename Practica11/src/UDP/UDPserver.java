package UDP;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author FrancisFOCA
 */
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPserver {

    public static void main(String[] args) throws Exception
    {
        //creo el socket
        DatagramSocket socket = new DatagramSocket(5432);
        
        while (true)
        {
            System.out.println("Esperando la conexion...");            
        
            //buffer para recibir el nombre del cliente
            byte[] bRecibe = new byte[256];
            
            //recibo el nombre del cliente
            DatagramPacket packet = new DatagramPacket(bRecibe, bRecibe.length);
            
            socket.receive(packet);
            
            System.out.println("conexion completa !");
            
            System.out.println("En espera del mensaje...");
            
            //preparo el saludo para enviar
            String nombre = new String(packet.getData(),0,packet.getLength());
            
            String saludo = "Bienvenido ("+nombre+") _ " + System.currentTimeMillis();
            
            System.out.println("Voy a enviar: ["+saludo+"]...");
            
            //buffer para enviar saludo
            byte[] bEnvia = saludo.getBytes();
            
            //envio el saludo
            InetAddress address = packet.getAddress();
            packet = new DatagramPacket(bEnvia,bEnvia.length,address,packet.getPort());
            
            socket.send(packet);
            
            System.out.println("Saludo enviado correctamente!!");
        }
}

}
