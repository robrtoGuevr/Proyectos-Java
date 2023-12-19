package org.example;

import org.example.datos.EstudianteDAO;
import org.example.dominio.Estudiante;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

        var estudianteDao = new EstudianteDAO();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e.getMessage());
            }

        }//fin while
    }

    public static void mostrarMenu(){
        System.out.println("""
                    *** Sistema de Estudiantes ***
                    1. Listar Estudiantes
                    2. Buscar Estudiante por id
                    3. Agregar Estudiante
                    4. Modificar Estudiante
                    5. Eliminar Estudiante
                    6. Salir
                    Elige una opcion
                    """);
    }

    private static  boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {//Listar estudiantes
                System.out.println("Listado de estudiantes...");
                var estudiantes = estudianteDAO.listar();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> {//buscar estudiante
                System.out.println("Introduce el id del estudiante a buscar");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if(encontrado)
                    System.out.println("Estudiante encontrado: "+estudiante);
                else
                    System.out.println("No se logro encontrar estudiante: "+estudiante);
            }
            case 3 ->{//Agregar estudiante
                System.out.println("Agregar Estudiante");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();

                var estudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.agregarEstudiante(estudiante);
                if(agregado)
                    System.out.println("Estudiante Agregado: "+estudiante);
                else
                    System.out.println("Estudiante no agregado");
            }
            case 4 -> {//Modificar estudiante
                System.out.println("Modificar estudiante: ");
                System.out.println("Id estudiante");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                //Crear el objeto estudiante a modificar
                var estudiante = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if(modificado)
                    System.out.println("Estudiante modificado: "+estudiante);
                else
                    System.out.println("Estudiante no modificado");
            }
            case 5 -> {//eliminar estudiante
                System.out.println("Eliminar estudiante");
                System.out.println("Id estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if(eliminado)
                    System.out.println("Estudiante eliminado: "+estudiante);
                else
                    System.out.println("Estudiante no eliminado");
            }
            case 6 -> {
                System.out.println("Hasta pronto");
                salir = true;
            }

            default -> System.out.println("Opcion no reconocida");
        }
        return salir;
    }
}