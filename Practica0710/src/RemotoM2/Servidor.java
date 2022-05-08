/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemotoM2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Observable;

/**
 *
 * @author santi
 */
public class Servidor extends Observable implements Runnable{

    private int puerto;
    
    public Servidor(int puerto){
        this.puerto = puerto;
    }
    
    @Override
    public void run() {
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        
        try{
            //Puerto del Servidor
            servidor = new ServerSocket(puerto);
            System.out.println("Servidor iniciado...");
            
            while(true){
                sc = servidor.accept();
                
                System.out.println("Cliente conectado...");
                in = new DataInputStream(sc.getInputStream());
                
                //Mensaje que se envia
                String mensaje = in.readUTF();
                System.out.println(mensaje);
                
                this.setChanged();
                this.notifyObservers(mensaje);
                this.clearChanged();
                
                //Cierre del Socket
                sc.close();
                System.out.println("Cliente desconectado...");
            }
        }catch(IOException ex){
            Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
