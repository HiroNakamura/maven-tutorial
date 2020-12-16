package org.inforhomex.app.model;


public final class MyInmutable{
    
    private final String nombre;
    
    public MyInmutable(String nombre){
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }

    @Override
    public String toString(){
        return "MyInmutable{nombre="+this.getNombre()+"}";
    }

}