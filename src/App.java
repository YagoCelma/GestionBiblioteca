
import java.util.ArrayList;
import java.util.Scanner;


public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Libro libro = new Libro();
        Persistencia persistencia = new Persistencia();
        GestionBiblioteca gestionBiblioteca = new GestionBiblioteca();


        ArrayList<Libro> libros = new ArrayList<>();
        persistencia.leerFichero(libro);
        
        int opcion;
        do{
            System.out.println("----MENU PRINCIPAL----");
            System.out.println("1. Añadir libro");
            System.out.println("2. Borrar libro");
            System.out.println("3. Buscar libro");
            System.out.println("4. Mostrar todos los libros");
            System.out.println("5. Salir del programa");
            System.out.println("Elige una opcion");
            opcion = sc.nextInt();
            sc.nextLine();

            switch(opcion){
                case 1-> gestionBiblioteca.añadirLibro();
                case 2-> gestionBiblioteca.borrarLibro();
                case 3-> gestionBiblioteca.menuBuscar();
                case 4-> gestionBiblioteca.mostrarLibros();
                case 5-> System.out.println("Saliendo del programa...");
                default-> System.out.println("Valor introducido no valido");
            }
        }while(opcion != 5);
    }
}
