package org.inforhomex.app.extendida;

import java.util.ArrayList;
import org.inforhomex.app.extendida.EmpleadosFile;
import org.inforhomex.app.interfaces.IServicio;

public class EmpleadosListFile extends ArrayList implements IServicio<EmpleadosListFile>{
	private EmpleadosFile empleadosFile;

	public EmpleadosListFile(){}

	public EmpleadosListFile(EmpleadosFile empleadosFile){
		super();
		this.setEmpleadosFile(empleadosFile);
	}
	
	public EmpleadosFile getEmpleadosFile(){
		return empleadosFile;
	}

	public void setEmpleadosFile(EmpleadosFile empleadosFile){
		this.empleadosFile = empleadosFile;
	}
	
	@Override
	public EmpleadosListFile mostrar(){
		System.out.println("Empleado: "+this.getEmpleadosFile().getEmpleado());
		return this;
	}

}