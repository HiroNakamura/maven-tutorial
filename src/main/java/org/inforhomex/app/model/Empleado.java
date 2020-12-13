package org.inforhomex.app.model;


public class Empleado extends Persona{
	private double salario;

	public Empleado(){}


	public Empleado(String nombre, double salario){
		super(nombre);
		this.salario = salario;
	}

	public double getSalario(){
		return salario;
	}

	public void setSalario(double salario){
		this.salario = salario;
	}

    @Override
	public void mostrar(){
		System.out.println("Datos:\n\t"+this.toString());
	}

	@Override
	public String toString(){
		return super.toString()+" , Salario: "+this.salario;
	}
} 