package org.inforhomex.app.extendida;

import java.util.ArrayList;
import org.inforhomex.app.model.Empleado;

public class ListaEmpleados extends ArrayList<Empleado>{
    private String nombre;

    public ListaEmpleados(){}

    public ListaEmpleados(String nombre){
        super();
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

}