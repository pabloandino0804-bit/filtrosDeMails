package ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos;

import java.util.List;

import ar.edu.unahur.obj2.composite.filtros.IFiltro;

public class FiltroOr extends FiltroCompuesto{

    public FiltroOr(List<IFiltro> filtros) {
        super(filtros);
    }

    @Override
    public Boolean doAplicar() {
        return filtros.stream().anyMatch(f -> f.aplicar());
    }

}
