package org.inforhomex.app.model;

import org.inforhomex.app.interfaces.IServicio;


public class Mensaje implements IServicio<Mensaje>{

	private String titulo;
	private String contenido;


	public Mensaje(){}

	public Mensaje(String titulo, String contenido){
		super();
		this.titulo = titulo;
		this.contenido = contenido;
	}

	public String getTitulo(){
		return titulo;
	}

	public void setTitulo(String titulo){
		this.titulo = titulo;
	}

	public String getContenido(){
		return contenido;
	}

	public void setContenido(String contenido){
		this.contenido = contenido;
	}

	@Override
	public Mensaje mostrar(){
		System.out.println("\t"+this.toString());
		return this;
	}

	@Override
	public String toString(){
		return "Mensaje{titulo: "+this.titulo+", contenido: "+this.contenido+"}";
	}

}