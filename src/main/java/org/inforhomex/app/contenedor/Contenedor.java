package org.inforhomex.app.contenedor;

import org.inforhomex.app.interfaces.IServicio;

public class Contenedor{

	private IServicio servicio;

	public Contenedor(){}
	
	public Contenedor(IServicio servicio){
		super();
		this.servicio = servicio;
	}

	public IServicio getServicio(){
		return servicio;
	}

	public Object ejecutar(){
		return this.getServicio().mostrar();
	}

}