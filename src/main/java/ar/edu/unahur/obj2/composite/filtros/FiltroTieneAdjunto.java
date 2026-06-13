package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.Correo;

public class FiltroTieneAdjunto implements Filtro{

    @Override
    public Boolean cumple(Correo correo) {
        return correo.tieneAdjuntos();
    }

}
