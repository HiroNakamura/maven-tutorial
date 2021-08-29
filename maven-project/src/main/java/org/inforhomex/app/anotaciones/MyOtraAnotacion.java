package org.inforhomex.app.anotaciones;

import java.lang.annotation.Target;
import java.lang.annotation.ElementType;

@Target(ElementType.METHOD)
public @interface MyOtraAnotacion{
    String nombre();
    int valor();
}