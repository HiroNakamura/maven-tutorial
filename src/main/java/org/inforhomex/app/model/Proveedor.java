package org.inforhomex.app.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import java.io.Serializable;


@XmlRootElement(name = "proveedor")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Proveedor implements Serializable{
    private String nombre;

    public String getNombre(){
        return nombre;
    }

    @XmlElement
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    @Override
    public String toString(){
        return "Proveedor{nombre="+this.nombre+"}";
    }

}