package ar.edu.unahur.obj2.composite.filtros;

import ar.edu.unahur.obj2.composite.Correo;

public class FiltroTamaño implements Filtro{
    private Integer tamanioDado;

    public FiltroTamaño(Integer tamanioDado) {
        this.tamanioDado = tamanioDado;
    }

    @Override
    public Boolean cumple(Correo correo) {
        return correo.getTamanioKB() >= tamanioDado;
    }
}
