package org.inforhomex.app.extendida;

import org.inforhomex.app.model.Empleado;

public class EmpleadosFile extends java.io.File{
    private Empleado empleado;

    public EmpleadosFile(Empleado empleado, String nombre){
        super(nombre);
        this.empleado = empleado;
    }

    public Empleado getEmpleado(){
        return empleado;
    }

    public void setEmpleado(Empleado empleado){
        this.empleado = empleado;
    }

    public EmpleadosFile getEmpleadosFile(){
        System.out.println("#>>>"+empleado);
        return this;
    }
}