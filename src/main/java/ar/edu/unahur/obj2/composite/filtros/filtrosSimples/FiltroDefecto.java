package ar.edu.unahur.obj2.composite.filtros.filtrosSimples;

import ar.edu.unahur.obj2.composite.correos.Correo;

public class FiltroDefecto extends FiltroSimple{

    public FiltroDefecto(Correo correo) {
        super(correo);
    }

    @Override
    public Boolean aplicar() {
        return Boolean.TRUE;
    }

}
