package gm.estudiantes;

import gm.estudiantes.modelo.Estudiante;
import gm.estudiantes.servicio.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;


@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;
	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicacion");
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicacion finzalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(nl +"Ejecutando metodo run de spring" + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//fin while

	}

	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				***Sistema de Estudiantes*** 
				1. Listar Estudiantes
				2. Buscar estudiantes
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir
				Elige una opcion:""");
	}

	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 -> { //Listar
				logger.info(nl+"Listado de estudiantes: "+nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiantes.toString()+nl)));
			}

			case 2 -> {//Buscar Estudiante
				logger.info("Introduce el estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.nextLine());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null)
					logger.info("Estudiante encontrado: " + estudiante + nl);
				else
					logger.info("Estudiante no encontrado con id: "+idEstudiante+nl);
			}
		}// fin switch
		return salir;
	}
}
