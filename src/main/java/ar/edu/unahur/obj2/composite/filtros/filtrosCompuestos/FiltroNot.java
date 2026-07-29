package ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos;

import java.util.List;

import ar.edu.unahur.obj2.composite.filtros.IFiltro;

public class FiltroNot extends FiltroCompuesto{

    public FiltroNot(List<IFiltro> filtros) {
        super(filtros);
    }

    @Override
    public Boolean doAplicar() {
        return ! filtros.stream().allMatch(f-> f.aplicar());
    }

}
