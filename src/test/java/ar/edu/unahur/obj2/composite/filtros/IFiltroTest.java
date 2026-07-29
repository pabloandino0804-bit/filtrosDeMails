package ar.edu.unahur.obj2.composite.filtros;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.correos.Correo;
import ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos.FiltroAnd;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroAdjuntos;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroPorAsunto;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroPorTamanio;

public class IFiltroTest {
    @Test
    void testAplicar() {
        Correo correo = new Correo("yo","vos","Muy importante",250.0,Boolean.TRUE,"Reunión de consorcio para tratar problema con ascensor 1");

        FiltroAdjuntos fa = new FiltroAdjuntos(correo);
        FiltroPorTamanio fpt = new FiltroPorTamanio(230.0, correo);
        FiltroPorAsunto fpa = new FiltroPorAsunto(correo, "importante");
        List<IFiltro>filtros = new ArrayList<>(List.of(fa,fpt,fpa));
        IFiltro filtroCompuesto = new FiltroAnd(filtros);

        assertTrue(filtroCompuesto.aplicar());
    }
}
