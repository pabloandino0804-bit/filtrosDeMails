package ar.edu.unahur.obj2.composite;

import java.util.List;
import java.util.Arrays;

import ar.edu.unahur.obj2.composite.filtros.Filtro;

public class CuentaCorreo {
    private Filtro filtro;

    public CuentaCorreo(Filtro unFiltro) {
        filtro = unFiltro;
    }

    public List<Correo> solicitarEmails (Correo... emails) {
        List<Correo> listaCorreos = Arrays.asList(emails);
        return listaCorreos.stream().filter(correo -> filtro.cumple(correo)).toList();
    }
}
