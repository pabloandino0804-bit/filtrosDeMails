package ar.edu.unahur.obj2.composite.filtros.filtrosSimples;

import ar.edu.unahur.obj2.composite.correos.Correo;

public class FiltroPorTamanio extends FiltroSimple{

    private Double valorMinimo;

    public FiltroPorTamanio(Double valorMinimo, Correo correo) {
        super(correo);
        this.valorMinimo = valorMinimo;
    }

    @Override
    public Boolean aplicar() {
        return correo.getTamanio() >= valorMinimo;
    }

}
