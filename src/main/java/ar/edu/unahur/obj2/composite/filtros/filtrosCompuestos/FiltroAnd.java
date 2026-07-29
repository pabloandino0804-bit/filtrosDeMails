package ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos;

import java.util.List;

import ar.edu.unahur.obj2.composite.filtros.IFiltro;

public class FiltroAnd extends FiltroCompuesto{

    public FiltroAnd(List<IFiltro> filtros) {
        super(filtros);
    }

    @Override
    public Boolean doAplicar() {
        return filtros.stream().allMatch(f-> f.aplicar());
    }

    
}
