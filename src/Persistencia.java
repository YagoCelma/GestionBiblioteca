
import java.io.*;

public class Persistencia {

    
    public void escribirLibros(Libro libro){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("libros.txt"))){

            writer.write(libro.getTitulo() + ";" + libro.getAutor() + ";" + libro.getISBN() + ";" + libro.getAñoPublicacion());
            writer.newLine();
            
        }catch(IOException e){
            System.err.println("Error al escribir el fichero: " + e.getMessage());
        }
    }

    public void leerFichero(Libro libro){

        try(BufferedReader reader = new BufferedReader(new FileReader("libros.txt"))){

            String linea;
            while((linea = reader.readLine()) != null){
                String[] partes = linea.split(";");

                String titulo = partes[0];
                String autor = partes[1];
                int isbn = Integer.parseInt(partes[2]);
                int añoPublicacion = Integer.parseInt(partes[3]);
            }
        }catch(IOException e){
            System.err.println("Error al leer el fichero: " + e.getMessage());
        }
    }
}
