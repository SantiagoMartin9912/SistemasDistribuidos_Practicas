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

public class UDPcliente {
  
    public static void main(String[] args) throws Exception{
        // instancio de un datagramsocket
        DatagramSocket socket = new DatagramSocket();
        //Buffer con info a enviar
        byte[] bEnviar = "Julio Esteban".getBytes();
        //ip server
        byte[] ip = {127,0,0,1};
        InetAddress address = InetAddress.getByAddress(ip);
        
        //paquete de informacion a enviar, ip = port(5432)
        DatagramPacket packet = new DatagramPacket(bEnviar,bEnviar.length,address,5432);
        
        //Envio el paquete
        socket.send(packet);
        
        //buffer para recibir la respuesta
        byte[] bRecibe = new byte [256];
        packet = new DatagramPacket(bRecibe,bRecibe.length,address,5432);
        
        //Recibo de el saludo 
        socket.receive(packet);
        
        //muetre el resultado 
        String saludo = new String(packet.getData(),0,packet.getLength());
        System.out.println(saludo);
        
        socket.close();
    }
    
}
