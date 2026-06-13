package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.Correo;

public class FiltroPorAsunto implements Filtro {
    private String asunto;

    public FiltroPorAsunto(String asunto) {
        this.asunto = asunto;
    }

    @Override
    public Boolean cumple(Correo correo){
        return correo.getAsunto().contains(asunto);
    }
}
