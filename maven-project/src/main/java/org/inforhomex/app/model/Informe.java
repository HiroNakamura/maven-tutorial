package org.inforhomex.app.model;

import org.inforhomex.app.anotaciones.MyAnotacion;
import org.inforhomex.app.anotaciones.MyOtraAnotacion;

@MyAnotacion(nombre="Informe")
public class Informe {
	
	private static final String MENSAJE = new StringBuilder("Este es un informe de suma importancia").toString();
	
	@MyOtraAnotacion(nombre="Mi mensaje",valor = 1)
	public String mensaje() {
		return Informe.MENSAJE;
	}
}
