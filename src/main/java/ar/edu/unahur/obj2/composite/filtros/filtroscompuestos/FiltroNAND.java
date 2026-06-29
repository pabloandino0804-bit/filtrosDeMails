package ar.edu.unahur.obj2.composite.filtros.filtroscompuestos;

import ar.edu.unahur.obj2.composite.Correo;
import ar.edu.unahur.obj2.composite.filtros.Filtro;

public class FiltroNAND implements Filtro {
    private Filtro filtro;

    public FiltroNAND(Filtro... filtrosDados) {
        this.filtro = new FiltroNot(new FiltroAND(filtrosDados));
    }

    @Override
    public Boolean cumple(Correo correo) {
        return filtro.cumple(correo);
    }

}
