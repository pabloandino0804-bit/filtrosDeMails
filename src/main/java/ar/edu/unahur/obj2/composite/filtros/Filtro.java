package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.Correo;

public interface Filtro {

    Boolean cumple(Correo correo);

}