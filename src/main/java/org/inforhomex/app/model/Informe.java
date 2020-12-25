package org.inforhomex.app.model;

import org.inforhomex.app.anotaciones.MyAnotacion;

@MyAnotacion(nombre="Informe")
public class Informe {
	
	private static final String MENSAJE = new StringBuilder("Este es un informe de suma importancia").toString();
	
	public String mensaje() {
		return Informe.MENSAJE;
	}
}
