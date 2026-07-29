package ar.edu.unahur.obj2.composite.filtros.filtrosSimples;

import ar.edu.unahur.obj2.composite.correos.Correo;

public class FiltroAdjuntos extends FiltroSimple{

    public FiltroAdjuntos(Correo correo) {
        super(correo);
    }

    @Override
    public Boolean aplicar() {
        return correo.getArchivosAdjuntos();
    }

    
}
