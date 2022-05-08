/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MultihilosTCP;

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

    private int puerto;
    private String mensaje;
    
    public Cliente(int puerto, String mensaje){
        this.puerto = puerto;
        this.mensaje = mensaje;
    }
    
    @Override
    public void run() {
        //Host del Servidor
        final String HOST = "10.0.0.12"; //Cambiar por tu IP
        //Puerto del Servidor
        DataOutputStream out;
        
        try{
            //Creación del socket para la conexion con el Cliente
            Socket sc = new Socket(HOST, puerto);
            
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
