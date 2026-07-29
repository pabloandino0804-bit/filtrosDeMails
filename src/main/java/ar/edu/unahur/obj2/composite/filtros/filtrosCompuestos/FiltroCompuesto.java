package ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos;

import java.util.List;

import ar.edu.unahur.obj2.composite.filtros.IFiltro;

public abstract class FiltroCompuesto implements IFiltro{

    protected List<IFiltro> filtros;

    public FiltroCompuesto(List<IFiltro> filtros) {
        this.filtros = filtros;
    }

    @Override
    public Boolean aplicar() {
        return doAplicar();
    } 

    public abstract Boolean doAplicar(); 

    public void agregarFiltro(IFiltro filtro){
        filtros.add(filtro);
    }

    public void vaciarFiltros(){
        filtros.clear();
    }
}
