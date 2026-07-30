package ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos;

import java.util.List;

import ar.edu.unahur.obj2.composite.filtros.IFiltro;

public class FiltroNOR extends FiltroCompuesto {

    public FiltroNOR(List<IFiltro> filtros) {
        super(filtros);
    }

    @Override
    public Boolean doAplicar() {
        return !filtros.stream().anyMatch(f -> f.aplicar());
    }

}
