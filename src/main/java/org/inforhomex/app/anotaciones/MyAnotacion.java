package org.inforhomex.app.anotaciones;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target(ElementType.TYPE)  
public @interface MyAnotacion {
	String nombre();
}
