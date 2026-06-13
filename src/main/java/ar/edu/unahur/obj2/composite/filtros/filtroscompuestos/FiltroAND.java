package ar.edu.unahur.obj2.composite.filtros.filtroscompuestos;

import java.util.Arrays;
import java.util.List;

import ar.edu.unahur.obj2.composite.Correo;
import ar.edu.unahur.obj2.composite.filtros.Filtro;

public class FiltroAND implements Filtro{

    private List<Filtro> filtros;

    public FiltroAND(Filtro filtros){
        this.filtros = Arrays.asList(filtros);
    }

    @Override
    public Boolean cumple(Correo correo) {
        return filtros.stream().allMatch(filtro -> filtro.cumple(correo));
    }
}
