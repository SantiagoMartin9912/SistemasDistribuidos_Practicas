package leercaracter;

import java.io.*;

public class LeerCaracter {

    public static void main(String[] args) {
        BufferedInputStream entrada = null;

        try {
            // Si el archivo de texto temporal.txt no existe hay que crearlo
            // previamente o cambiar el camino para que se refiera a un archivo 
            // existente.
            File archivo = new File("temporal.txt");
            entrada = new BufferedInputStream(new FileInputStream(archivo));
            while (true) {
                int temp = entrada.read();
                if (temp == -1) {
                    System.out.println("");
                    System.out.println("Se leyó todo el archivo.");
                    break;
                }
                char caracter = (char) temp;
                System.out.print(caracter);
            }
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                entrada.close();
            } catch (Exception e2) {
                System.out.println("No pudo cerrarse el flujo.");
            }
        }
    }
}
