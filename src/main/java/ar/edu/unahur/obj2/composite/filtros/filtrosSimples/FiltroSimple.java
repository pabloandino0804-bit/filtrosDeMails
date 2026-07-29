package ar.edu.unahur.obj2.composite.filtros.filtrosSimples;

import ar.edu.unahur.obj2.composite.correos.Correo;
import ar.edu.unahur.obj2.composite.filtros.IFiltro;

public abstract class FiltroSimple implements IFiltro{

    protected Correo correo;

    public FiltroSimple(Correo correo) {
        this.correo = correo;
    }

    

}
