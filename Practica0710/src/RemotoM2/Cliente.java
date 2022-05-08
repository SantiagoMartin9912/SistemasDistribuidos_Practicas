/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package RemotoM2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author santi
 */
public class Cliente implements Runnable{

    private String host; 
    private int puerto;
    private String mensaje;
    
    public Cliente(String host, int puerto, String mensaje){
        this.host = host;
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run() {
        //Host del Servidor
        
        //Puerto del Servidor
        DataOutputStream out;
        
        try{
            //Creación del socket para la conexion con el Cliente
            Socket sc = new Socket(host, puerto);
            
            out = new DataOutputStream(sc.getOutputStream());
            //Mensaje del Cliente
            out.writeUTF(mensaje);
            
            //Cierre del socket
            sc.close();
        }catch(IOException ex){
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
