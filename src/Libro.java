
import java.util.*;

public class Libro {


    private String titulo;
    private String autor;
    private int isbn;
    private int añoPublicacion;

    public Libro(String titulo, String autor, int isbn, int añoPublicacion){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.añoPublicacion = añoPublicacion;
    }
    public Libro(){

    }
    
    //Gets y sets

    public int getISBN() {return isbn;}
    public String getAutor() {return autor;}
    public String getTitulo() {return titulo;}
    public int getAñoPublicacion() {return añoPublicacion;}

}
