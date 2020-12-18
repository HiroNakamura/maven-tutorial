package org.inforhomex.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.Arrays;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.inforhomex.app.model.Proveedor;
import org.inforhomex.app.model.Empleado;
import org.inforhomex.app.model.Mensaje;
import org.inforhomex.app.model.MyInmutable;
import org.inforhomex.app.contenedor.Contenedor;
import org.inforhomex.app.extendida.ListaEmpleados;
import org.inforhomex.app.extendida.EmpleadosFile;

public class MavenApplication{

	private static final Logger LOGGER = LoggerFactory.getLogger(MavenApplication.class);
	private static final String TITULO = "Congratulations!!";
	private static final String CONTENIDO = "You are the best programmer of the tournament!!";
	private static final String ARCHIVO = "empleados.csv";

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
		testMockE();
		testMockF();
		testMockG(ARCHIVO);
		testMockH();
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
		Mensaje mensaje = new Mensaje();
		mensaje.setTitulo("Felicitaciones");
		mensaje.setContenido("Has sido el ganador del certamen: JUNIOR DEVELOPER");
		LOGGER.info("testMockC-Mensaje: {}",mensaje);
	}

	public static void testMockD(final String titulo, final String contenido){
		Contenedor contenedor= new Contenedor(new Mensaje(titulo, contenido));
		LOGGER.info("testMockD-Contenedor: {}", contenedor.ejecutar());
	}

	public static void testMockE(){
		ListaEmpleados listaEmpleados = new ListaEmpleados("*** EMPLEADOS ***");
		LOGGER.info("testMockE-Lista: {}", listaEmpleados.getNombre());
		listaEmpleados.add(0, new Empleado("Horacio Gomez",34009.00));
		listaEmpleados.add(1, new Empleado("Jimena Zaras",25000.60));
		listaEmpleados.add(2, new Empleado("Antonia Sanchez",35000.00));
		listaEmpleados.add(3, new Empleado("Karla Gomora",25000.40));
		LOGGER.info("testMockE-Cant. de empleados: {}",listaEmpleados.size());
		LOGGER.info("tesMock-Empleados:\n");
		for(Empleado emp: listaEmpleados){
			LOGGER.info("\ttestMockE-Empleado: {}",emp);
		}
	}

	public static void testMockF(){
		MyInmutable myInmutable = new MyInmutable("Europa renacida");
		LOGGER.info("testMockF-MyInmutable: {}", myInmutable);
	}

	public static void testMockG(String archivo){
		Empleado empleado = new Empleado("Juan Tolomeo Archundia",new Double("12400.00"));
		LOGGER.info("testMockG-EmpleadosFile: {}",new EmpleadosFile(empleado, archivo).getEmpleadosFile());
	}

	public static void testMockH(){
		File file = null;
		JAXBContext jaxbContext = null;
		Marshaller jaxbMarshaller = null;
		Unmarshaller jaxbUnmarshaller = null;
		Proveedor proveedor = new Proveedor();
		proveedor.setNombre("Ignacio Colmenares Rojas");
		LOGGER.info("testMockH-Proveedor: {}", proveedor);
		try{
			if(new File("proveedor.xml").exists()){
				LOGGER.info("testMockH-Borrando archivo XML...");
				new File("proveedor.xml").delete();
			}
			file = new File("proveedor.xml");
			jaxbContext = JAXBContext.newInstance(Proveedor.class);
			jaxbMarshaller = jaxbContext.createMarshaller();
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
			jaxbMarshaller.marshal(proveedor, file);
			jaxbMarshaller.marshal(proveedor, System.out);
		}catch(JAXBException ex){
			LOGGER.error("Error: {}",ex.toString());
			ex.printStackTrace();
		}
		LOGGER.info("testMockH-Obteniendo datos de un XML...");
		try{
			jaxbContext = JAXBContext.newInstance(Proveedor.class);
			jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			Proveedor myProveedor = (Proveedor) jaxbUnmarshaller.unmarshal(file);
			LOGGER.info("testMockH-Proveedor (obtenido de un XML): {}",myProveedor);
		}catch(JAXBException ex){
			LOGGER.error("Error: {}",ex.toString());
			ex.printStackTrace();
		}
		
	}

}
