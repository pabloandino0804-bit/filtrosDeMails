package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.Correo;

public class FiltroRemitente implements Filtro{
    private String remitente;

    public FiltroRemitente(String remitente) {
        this.remitente = remitente;

    }

    @Override
    public Boolean cumple(Correo correo) {
       return remitente == correo.getRemitente();
    }
}
