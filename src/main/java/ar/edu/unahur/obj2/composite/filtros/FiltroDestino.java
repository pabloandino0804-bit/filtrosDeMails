package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.Correo;

public class FiltroDestino implements Filtro{
    private String destinatario;

    public FiltroDestino(String destinatario) {
        this.destinatario = destinatario;

    }

    @Override
    public Boolean cumple(Correo correo) {
       return destinatario == correo.getDestinatatio();
    }

}
