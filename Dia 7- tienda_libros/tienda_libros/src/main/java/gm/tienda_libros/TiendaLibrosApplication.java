package gm.tienda_libros;

import gm.tienda_libros.view.FormBook;
import org.hibernate.id.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

import javax.swing.*;
import java.awt.*;

@SpringBootApplication
public class TiendaLibrosApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext contextSpring = new SpringApplicationBuilder(TiendaLibrosApplication.class).headless(false).web(WebApplicationType.NONE)
				.run(args);
		//Ejecutamos el codigo para cargar el fomrulario
		EventQueue.invokeLater(()->{
			//Obtenemos el objeto form a traves de Spirng
			FormBook formBook = contextSpring.getBean(FormBook.class);
			formBook.setVisible(true);
		});
	}

}
