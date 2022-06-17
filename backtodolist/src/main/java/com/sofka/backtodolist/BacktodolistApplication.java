package com.sofka.backtodolist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * [Clase principal donde se encuentra el metodo main de salida
 * ]
 *
 * @version [1.0.0 2022-06-17]
 *
 * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
 *
 * @since [1.0.0]
 *
 */
@SpringBootApplication
public class BacktodolistApplication {

	/**
	 * [llama el framework Springboot para ejecutarlo
	 * ]
	 *
	 * @param args arreglo por defecto
	 *
	 * @author Miller Esteban Gallego Forero - miller.gallegof@gmail.com
	 *
	 * @since [1.0.0]
	 *
	 */
	public static void main(String[] args) {
		SpringApplication.run(BacktodolistApplication.class, args);
	}

}
