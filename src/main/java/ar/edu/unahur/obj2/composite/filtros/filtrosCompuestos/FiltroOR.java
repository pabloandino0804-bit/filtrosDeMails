package ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos;

import java.util.List;

import ar.edu.unahur.obj2.composite.filtros.IFiltro;

public class FiltroOR extends FiltroCompuesto {

    public FiltroOR(List<IFiltro> filtros) {
        super(filtros);
    }

    @Override
    public Boolean doAplicar() {
        return filtros.stream().anyMatch(p -> p.aplicar());
    }

}
