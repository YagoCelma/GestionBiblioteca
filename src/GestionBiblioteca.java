import java.util.ArrayList;
import java.util.Scanner;

public class GestionBiblioteca {

    ArrayList <Libro> libros = new ArrayList<>();
    Persistencia persistencia = new Persistencia();
    
    public void añadirLibro(){

        Scanner sc = new Scanner(System.in);
        boolean pasar = true;
        int añoPublicacion = 0;
        int isbn = 0;
        boolean valido = false;

        System.out.println("Titulo del libro:");
        String titulo = sc.nextLine();

        System.out.println("Autor del libro:");
        String autor = sc.nextLine();

        do{
            System.out.println("ISBN del libro;");
            isbn = sc.nextInt();
            sc.nextLine();
            pasar = comprobarISBN(isbn);
        }while(pasar == true);


        while (!valido) {
            System.out.print("Introduce el año de publicación: ");
            String entrada = sc.nextLine();

            try {
                añoPublicacion = Integer.parseInt(entrada);
                valido = true;
            } catch (NumberFormatException e) {
                System.out.println("Error: El año debe ser un número.");
            }
        }
        if(titulo.isEmpty() || autor.isEmpty() || isbn == 0 || añoPublicacion == 0){
            System.out.println("Algun dato del los introducidos estan vacios o no son validos");
        }else{
            libros.add(new Libro(titulo, autor, isbn, añoPublicacion));
            persistencia.escribirLibros(new Libro(titulo, autor, isbn, añoPublicacion));
        }
    }

    public boolean comprobarISBN(int isbn){
        for(Libro libro : libros){
            if(libro.getISBN() == isbn){
                return true;
            }
        }
        return false;
    }

    public boolean comprobarAutor(String autor){
        for(Libro libro : libros){
            if(libro.getAutor().equalsIgnoreCase(autor)){
                return true;
            }
        }
        return false;
    }

    public boolean comprobarTitulo(String titulo){
        for(Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                return true;
            }
        }
        return false;
    }

    public void borrarLibro(){

        Scanner sc = new Scanner(System.in);

        boolean pasar = false;
        do{
            System.out.println("Introduce el ISBN a borrar:");
            int isbn = sc.nextInt();
            sc.nextLine();

            pasar = comprobarISBN(isbn);

        }while(pasar == false);
    }

    public void menuBuscar(){

        Scanner sc = new Scanner(System.in);

        int opcion;
        do{
            System.out.println("Menu buscar libro");
            System.out.println("1. Buscar por ISBN");
            System.out.println("2. Buscar por autor");
            System.out.println("3. Buscar por titulo");
            System.out.println("4. Salir");
            System.out.println("Elige una opcion");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1-> buscarLibroISBN();
                case 2-> buscarLibroAutor();
                case 3-> buscarLibroTitulo();

            }
        }while(opcion != 4);
    }

    public void buscarLibroISBN(){

        Scanner sc = new Scanner(System.in);

        boolean pasar;
        do{
            System.out.println("Introduce el ISBN");
            int isbn = sc.nextInt();
            sc.nextLine();

            pasar = comprobarISBN(isbn);

            if(pasar == true){
                mostrarLibroISBN(isbn);
            }else{
                System.out.println("No se ha encontrado el ISBN del libro");
                System.out.println("Vuelve a intentarlo");
            }
        }while(pasar == true);
    }

    public void mostrarLibroISBN(int isbn){
        for(Libro libro : libros){
            if(libro.getISBN() == isbn){
                System.out.println(libro);
            }
        }
    }


    public void buscarLibroAutor(){

        Scanner sc = new Scanner(System.in);

        boolean pasar;
        do{
            System.out.println("Introduce el autor");
            String autor = sc.nextLine();

            pasar = comprobarAutor(autor);

            if(pasar == true){
                mostrarLibroAutor(autor);
            }else{
                System.out.println("No se ha encontrado el autor del libro");
                System.out.println("Vuelve a intentarlo");
            }
        }while(pasar == false);
    }

    public void mostrarLibroAutor(String autor){
        for(Libro libro : libros){
            if(libro.getAutor().equalsIgnoreCase(autor)){
                System.out.println(libro);
            }
        }
    }

    public void buscarLibroTitulo(){
        Scanner sc = new Scanner(System.in);

        boolean pasar;
        do{
            System.out.println("Introduce el titulo");
            String titulo = sc.nextLine();

            pasar = comprobarTitulo(titulo);

            if(pasar == true){
                mostrarLibroTitulo(titulo);
            }else{
                System.out.println("No se ha encontrado el titulo del libro");
                System.out.println("Vuelve a intentarlo");
            }
        }while(pasar == false);
    }

    public void mostrarLibroTitulo(String titulo){
        for(Libro libro : libros){
            if(libro.getTitulo().equalsIgnoreCase(titulo)){
                System.out.println(libro);
            }
        }
    }

    public void mostrarLibros(){
        System.out.println("Lista de libros:");
        for(Libro libro : libros){
            System.out.println("Titulo: " + libro.getTitulo() + "|| Autor: " + libro.getAutor() + "|| ISBN: " + libro.getISBN() + "|| Año de publicacion: " + libro.getAñoPublicacion());
        }
    }
}
