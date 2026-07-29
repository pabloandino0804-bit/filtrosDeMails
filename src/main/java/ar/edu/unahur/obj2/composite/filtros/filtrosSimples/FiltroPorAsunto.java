package ar.edu.unahur.obj2.composite.filtros.filtrosSimples;

import ar.edu.unahur.obj2.composite.correos.Correo;

public class FiltroPorAsunto extends FiltroSimple{

    private String palabraDeterminada;

    public FiltroPorAsunto(Correo correo, String palabraDeterminada) {
        super(correo);
        this.palabraDeterminada = palabraDeterminada;
    }

    @Override
    public Boolean aplicar() {
        return correo.getAsunto().contains(palabraDeterminada);
    }

    
}
