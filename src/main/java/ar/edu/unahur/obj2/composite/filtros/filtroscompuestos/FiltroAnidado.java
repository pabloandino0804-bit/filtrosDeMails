package ar.edu.unahur.obj2.composite.filtros.filtroscompuestos;

import ar.edu.unahur.obj2.composite.Correo;
import ar.edu.unahur.obj2.composite.filtros.Filtro;

public class FiltroAnidado implements Filtro{

    @Override
    public Boolean cumple(Correo correo) {
        return true;
    }
    
}
