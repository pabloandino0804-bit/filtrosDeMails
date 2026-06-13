package ar.edu.unahur.obj2.composite.filtros.filtroscompuestos;

import ar.edu.unahur.obj2.composite.Correo;
import ar.edu.unahur.obj2.composite.filtros.Filtro;

public class FiltroNot implements Filtro{
    private Filtro filtroBase;

    public FiltroNot(Filtro filtro) {
        this.filtroBase = filtro;
    }

    @Override
    public Boolean cumple(Correo correo) {
        return !this.filtroBase.cumple(correo);
    }
    
}
