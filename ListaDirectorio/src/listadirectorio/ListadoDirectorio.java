package listadirectorio;
import java.io.*;

public class ListadoDirectorio {

    public static void main(String args[]) throws IOException {
        File directorio = new File("C:\\Users\\itach\\Documents\\Ingenería ISC");
        if ((directorio.exists()) && (directorio.isDirectory())) {
            String[] lista = directorio.list();
            for (int i = 0; i < lista.length; i++) {
                System.out.println(lista[i]);
            }
        } else {
            System.out.println("El directorio no existe");
        }
    }
}
