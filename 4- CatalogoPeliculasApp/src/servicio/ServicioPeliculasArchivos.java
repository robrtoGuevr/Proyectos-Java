package servicio;

import dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivos implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "Peliculas.txt";

    public ServicioPeliculasArchivos() {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Si ya existe el archvio no se vuelve a crear
            if(archivo.exists()){
                System.out.println("El archivo ya existe");
            }else{
                //Si no existe, se crea  vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se ha creado el archivo");
            }
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {
        //Volvemos a abrir el archivo
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listado de peliculas");
            //Abrimos el archivo para lectura
            var entrada = new BufferedReader(new FileReader(archivo));
            //Leemos linea a linea el archivo
            String linea;
            linea = entrada.readLine();
            //Leemos todas las lineas disponibles
            while(linea!= null){
                var pelicula = new Pelicula(linea);
                System.out.println(pelicula);
                //Antes de terminar el ciclo volvemos a leer la siguiente linea
                linea = entrada.readLine();
            }

            entrada.close();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public void agreagrPelicula(Pelicula pelicula) {
        boolean anexar = false;
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Revisamos si existe el archivo
            anexar = archivo.exists();
            var salida = new PrintWriter(new FileWriter(archivo, anexar));
            //Agregamos la pelicula usando ToString
            salida.println(pelicula);
            salida.close();
        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            //Abrimos el archivo para lectura linea a linea
            var entrada = new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto = entrada.readLine();
            var indice = 1;
            var encontrada = false;
            var peliculaBuscar = pelicula.getNombre();
            while(lineaTexto != null){
                //Buscamos sin importar mayusculas/minusculas
                if(peliculaBuscar != null && peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    encontrada = true;
                    break;
                }
                //Si no se ha encontrado la pelicula leemos la siguiente iteracion
                lineaTexto = entrada.readLine();
                indice++;
            }//fin while
            //Imprimimos los resultados de la busqueda
            if(encontrada)
                System.out.println("Pelicula "+lineaTexto+ " encontrada - linea "+indice);
            else
                System.out.println("No se encontro la pelicula: "+pelicula.getNombre());
            entrada.close();

        }catch (Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }
}
