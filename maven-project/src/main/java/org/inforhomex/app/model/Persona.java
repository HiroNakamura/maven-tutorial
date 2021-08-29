package org.inforhomex.app.model;


public abstract class Persona{
	private String nombre;

	public Persona(){}

	public Persona(String nombre){
		this.nombre = nombre;
	}

	public String getNombre(){
		return nombre;
	}

	public void setNombre(String nombre){
		this.nombre = nombre;
	}

	public abstract void mostrar();

	@Override
	public String toString(){
		return "Nombre: "+this.nombre;
	}
} 