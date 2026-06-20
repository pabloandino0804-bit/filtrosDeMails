package ar.edu.unahur.obj2.composite.filtros.filtroscompuestos;

import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.composite.Correo;
import ar.edu.unahur.obj2.composite.filtros.Filtro;

public class FiltroOR implements Filtro{
    private List<Filtro> filtros;

    public FiltroOR(Filtro... filtros){
        this.filtros = Arrays.asList(filtros);
    }

    @Override
    public Boolean cumple(Correo correo) {
        return filtros.stream().anyMatch(filtro -> filtro.cumple(correo));
    }
}
