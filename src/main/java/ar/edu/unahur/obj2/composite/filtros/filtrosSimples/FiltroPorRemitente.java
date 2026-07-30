package ar.edu.unahur.obj2.composite.filtros.filtrosSimples;

import ar.edu.unahur.obj2.composite.correos.Correo;

public class FiltroPorRemitente extends FiltroSimple {
    private String remitente;

    public FiltroPorRemitente(Correo correo, String remitente) {
        super(correo);
        this.remitente = remitente;
    }

    @Override
    public Boolean aplicar() {
        return remitente.equals(correo.getRemitente());
    }

}
