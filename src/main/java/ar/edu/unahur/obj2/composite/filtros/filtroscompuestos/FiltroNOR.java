package ar.edu.unahur.obj2.composite.filtros.filtroscompuestos;

import ar.edu.unahur.obj2.composite.Correo;
import ar.edu.unahur.obj2.composite.filtros.Filtro;

public class FiltroNOR implements Filtro {
    private Filtro filtro;

    public FiltroNOR(Filtro... filtrosDados) {
        this.filtro = new FiltroNot(new FiltroOR(filtrosDados));
    }

    @Override
    public Boolean cumple(Correo correo) {
        return filtro.cumple(correo);
    }
}
