import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ListadoPersonasApp {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);

        //Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        //Empezamos con el menu
        var salir = false;
        while (!salir){
            mostrarMenu();
            System.out.println();
            try {
                salir = ejecutarOperacion(consola, personas);
            }catch (Exception e){
                System.out.println("Ocurrio un error: " +e.getMessage());
            }

        }
    }
    private static void mostrarMenu(){
        //Mostramos menu

        System.out.print("""
                **** Listado Personas App ****
                1. Agregar
                2. Listar
                3. Salir
                """);

        System.out.print("Proporciona la opcion: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //Revisamos la opcion proporcionada

        switch (opcion){
            case 1 ->{//Agregar persona a la lista
                System.out.print("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.print("Proporciona el email: ");
                var email = consola.nextLine();
                //Crear el objeto de tipo persona
                var persona = new Persona(nombre, tel , email);
                //Lo agregamos a la lista de personas
                personas.add(persona);
                System.out.println("La lista tiene: " + personas.size() + " elementos");
            }//fin caso 1

            case 2 -> { //Listar personas
                //personas.forEach((persona)-> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 -> {// Salimos del ciclo
                System.out.println("Hasta pronto");
                salir = true;
            }

            default -> System.out.println("Opcion erronea: " + opcion);
        }//fin switch

        return salir;
    }
}