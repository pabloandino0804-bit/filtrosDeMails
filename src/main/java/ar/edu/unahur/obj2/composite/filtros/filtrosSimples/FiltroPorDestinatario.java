package ar.edu.unahur.obj2.composite.filtros.filtrosSimples;

import ar.edu.unahur.obj2.composite.correos.Correo;

public class FiltroPorDestinatario extends FiltroSimple {
    private String destinatario;

    public FiltroPorDestinatario(Correo correo, String destinatario) {
        super(correo);
        this.destinatario = destinatario;
    }

    @Override
    public Boolean aplicar() {
        return destinatario.equals(correo.getDestinatario());
    }

}
