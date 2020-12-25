package org.inforhomex.app;

import java.awt.Desktop;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import org.inforhomex.app.model.Proveedor;
import org.inforhomex.app.model.Empleado;
import org.inforhomex.app.model.Mensaje;
import org.inforhomex.app.model.Informe;
import org.inforhomex.app.model.MyInmutable;
import org.inforhomex.app.contenedor.Contenedor;
import org.inforhomex.app.extendida.ListaEmpleados;
import org.inforhomex.app.extendida.EmpleadosFile;
import org.inforhomex.app.extendida.EmpleadosListFile;
import org.inforhomex.app.anotaciones.MyAnotacion;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;  

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
		try{
			testMockI();
		}catch(Exception ex){
			LOGGER.error("Ha ocurrido una excepcion: {}",ex.toString());
			ex.printStackTrace();
		}
		testMockJ();
		testMockK();
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
			LOGGER.error("Error al obtener datos del XML: {}",ex.toString());
			ex.printStackTrace();
		}
	}

	public static void testMockI(){
		LOGGER.info(" **** Creando PDF con Apache PDF Box ***");
		PDDocument documento = null;
		PDPage pagina = null;
		if(new File("documento.pdf").exists()){
			new File("documento.pdf").delete();
			LOGGER.info("testMockI-El documento PDF existe y se ha eliminado!!!");
		}
		try{
			documento = new PDDocument();
			pagina = new PDPage();
			documento.addPage(pagina);
			PDPageContentStream cont = new PDPageContentStream(documento, pagina);
			cont.beginText();
			cont.setFont(PDType1Font.TIMES_ROMAN, 12);
			cont.setLeading(14.5f);
			cont.newLineAtOffset(25, 700);
			String line1 = "El mejor lenguaje de programación es "+ " Java.";
			cont.showText(line1);
			cont.newLine();
			String line2 = "Es importante no olvidarlo. "+ "Ya que es una necesidad para cualquier programador.";
			cont.showText(line2);
			cont.newLine();
			String line3 = "Eventualmente conocerás otros lenguajes, "+ "pero Java sigue y seguirá siendo el mejor.";
			cont.showText(line3);
			cont.newLine();
			String line4 = "Estás a tiempo de  "+ "aprender a programar en Java.";
			cont.showText(line4);
			cont.newLine();
			cont.endText();
			cont.close();
        }catch(Exception ex){
        	ex.printStackTrace();
        }finally{
        	try{
        		documento.save("documento.pdf");
        		documento.close();
				LOGGER.info("testMockI-El documento PDF ha sido creado");
				File file = new File("documento.pdf");
				if(file.exists()){
					LOGGER.info("testMockI-El documento PDF existe y sera abierto");
					if(Desktop.isDesktopSupported()) {
						LOGGER.info("testMockI-El documento PDF ha sido abierto");
						Desktop.getDesktop().open(file);
					}
				} 
        	}catch(IOException ioe){
        		LOGGER.error("testMockI-Ha ocurrido una Exception al crear el documento PDF: {}",ioe.toString());
        		ioe.printStackTrace();
        	}
        }
	}

	public static void testMockJ(){
		List<Empleado> empleadosList = Arrays.asList(new Empleado("Bruno Acosta",26000.30),new Empleado("Daniel Solorzano",24000.0),new Empleado("Laura Tomassi",25000.90),new Empleado("Karla Alvarez",23000.0));
		ArrayList<Empleado> empleadosArrayList = new ArrayList<Empleado>();
		empleadosArrayList.addAll(empleadosList);
		LOGGER.info("testMockJ-Cant.de empleados {}", empleadosArrayList.size());
		LOGGER.info("testMockJ-Empleados {}", empleadosArrayList.toString());
		List<EmpleadosFile> empleadosFile = new ArrayList<EmpleadosFile>();
		LOGGER.info("testMockJ-Empleados:");
		int cont = 0;
		for(Empleado emp : empleadosArrayList) {
			System.out.println(emp);
			empleadosFile.add(new EmpleadosFile(emp, String.valueOf(cont)));
			cont++;
		}
		LOGGER.info("testMockJ-EmpleadosFile {}", empleadosFile.toString());
		EmpleadosListFile empleadosListFile = new EmpleadosListFile();
		try {
			empleadosListFile.setEmpleadosFile(empleadosFile.get(0).getEmpleadosFile());
			LOGGER.info("testMockJ-EmpleadosListFile asignado");
		}catch(RuntimeException re) {
			re.printStackTrace();
		}finally {
			LOGGER.info("testMockJ-EmpleadosListFile {}", empleadosListFile.getEmpleadosFile());
		}
	}
	
	@SuppressWarnings("unchecked")
	public static void testMockK() {
		LOGGER.info("testMockK **** Anotaciones Java ****");
		Informe informe = new Informe();
		LOGGER.info("testMockK-Informe: {}",informe.mensaje());
		Class getClase = null;
		MyAnotacion myAnotacion = null;
		try {
			getClase = informe.getClass();
			LOGGER.info("testMockK-Informe de tipo: {}",getClase.getName());
			Annotation[] anotaciones = getClase.getAnnotations();    
		    if(anotaciones.length > 0) {
		    	LOGGER.info("testMockK-Se ha encontrado anotaciones en lcaseInforme, total: {}",anotaciones.length);
		    }
		    getClase = Informe.class;
		    Annotation anotacion = getClase.getAnnotation(MyAnotacion.class);
		    if(anotacion !=null) {
		    	LOGGER.info("testMockK-Anotacion de la clase Informe: {}",anotacion.toString());
		    }
		}catch(RuntimeException re) {
			LOGGER.error("testMockK-RuntimeException {}", re.toString());
			re.printStackTrace();
		}catch(Exception ex) {
			LOGGER.error("testMockK-Exception {}", ex.toString());
			ex.printStackTrace();
		}
	}

}
