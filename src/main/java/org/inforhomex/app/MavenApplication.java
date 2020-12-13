package org.inforhomex.app;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import org.inforhomex.app.model.Empleado;
import org.inforhomex.app.model.Mensaje;
import org.inforhomex.app.contenedor.Contenedor;


public class MavenApplication{

	private static final Logger LOGGER = LoggerFactory.getLogger(MavenApplication.class);
	private static final String TITULO = "Congratulations!!";
	private static final String CONTENIDO = "You are the best programmer of the tournament!!";

	public static void main(String[] args){
		LOGGER.info("Hola, desde una aplicacion Maven!!!");
		if (args.length > 0) {
            LOGGER.info("Lista de argumentos: {}", Arrays.toString(args));
            try{
            	testMockB(args[0], Double.parseDouble(args[1]));
            }catch(NullPointerException npe){
            	LOGGER.error("Error: {}",npe.toString());
            }catch(Exception ex){
            	LOGGER.error("Error: {}",ex.toString());
            }
        }else{
        	testMockB("Mario Molina", new Double("24000.043"));
        }

        testMockA();
        testMockC(TITULO, CONTENIDO);
        testMockD(TITULO, CONTENIDO);
	}


	public static void testMockA(){
		Empleado empleado = new Empleado("Raul Lopez", new Double("23300.005"));
		LOGGER.info("testMockA-Empleado: {}", empleado);
		empleado.mostrar();
	}

	public static void testMockB(String nombre, double salario){
		Empleado empleado = new Empleado(nombre, salario);
		LOGGER.info("testMockB-Empleado: {}", empleado);
		empleado.mostrar();
	}

	public static void testMockC(final String titulo, final String contenido){
		new Mensaje(titulo, contenido).mostrar();
		LOGGER.info("testMockC-Mensaje: {}", new Mensaje(titulo, contenido));
	}

	public static void testMockD(final String titulo, final String contenido){
		Contenedor contenedor= new Contenedor(new Mensaje(titulo, contenido));
		LOGGER.info("testMockD-Contenedor: {}", contenedor.ejecutar());
	}

}
