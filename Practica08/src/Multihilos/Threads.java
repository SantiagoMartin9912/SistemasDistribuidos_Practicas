/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Multihilos;

import static java.lang.Thread.yield;

/**
 *
 * @author santi
 */
public class Threads {
    
    public static void main(String[] args){
        MiThred t1 = new MiThred("Pablo");
        MiThred t2 = new MiThred("Pedro");
    
        t1.start();
        t2.start();
    }
    
    static class MiThred extends Thread{
            String nom;
    
            public MiThred(String nom){
                this.nom = nom;
            }
    
            public void run(){
                for(int i=0;i<5; i++){
                    System.out.println(nom+" - "+i); 
                }
            }
        }
}