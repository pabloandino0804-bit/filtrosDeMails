package ar.edu.unahur.obj2.composite.filtros;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.correos.Correo;
import ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos.FiltroAND;
import ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos.FiltroNOR;
import ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos.FiltroNot;
import ar.edu.unahur.obj2.composite.filtros.filtrosCompuestos.FiltroOR;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroAdjuntos;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroPorAsunto;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroPorDestinatario;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroPorRemitente;
import ar.edu.unahur.obj2.composite.filtros.filtrosSimples.FiltroPorTamanio;

public class IFiltroTest {

    @Test
    void testAplicar() {
        Correo correo = new Correo("yo", "vos", "Muy importante", 250.0, Boolean.TRUE,
                "Reunión de consorcio para tratar problema con ascensor 1");

        FiltroAdjuntos fa = new FiltroAdjuntos(correo);
        FiltroPorTamanio fpt = new FiltroPorTamanio(230.0, correo);
        FiltroPorAsunto fpa = new FiltroPorAsunto(correo, "importante");
        List<IFiltro> filtros = new ArrayList<>(List.of(fa, fpt, fpa));
        IFiltro filtroCompuesto = new FiltroAND(filtros);

        assertTrue(filtroCompuesto.aplicar());
    }

    @Test
    void queUnFiltroANDNoCumplaCuandoNoCumplenSusCondiciones() {
        Correo unCorreo = new Correo("Roberto", "Luciano Mateo",
                "Junta importante por inicio de actividades", 220.0, false, "Reunion necesaria para estudiar");
        FiltroPorDestinatario fd = new FiltroPorDestinatario(unCorreo, "usuario");
        FiltroPorRemitente fr = new FiltroPorRemitente(unCorreo, "usuario");
        FiltroPorAsunto filtro1 = new FiltroPorAsunto(unCorreo, "importante");
        FiltroPorTamanio filtro2 = new FiltroPorTamanio(210.0, unCorreo);
        FiltroAdjuntos filtro3 = new FiltroAdjuntos(unCorreo);
        List<IFiltro> filtros = new ArrayList<>(List.of(filtro1, filtro2, filtro3, fd, fr));
        IFiltro filtroAnd = new FiltroAND(filtros);

        assertFalse(filtroAnd.aplicar());
    }

    @Test
    void queUnFiltroORCumplaCuandoCuandoSeCumpleAlgunaDeSusFunciones() {
        Correo unCorreo = new Correo("Roberto Matias", "Juan", "Junta importante por actividades", 220.0, true,
                "Reunion necesaria");
        FiltroPorDestinatario fd = new FiltroPorDestinatario(unCorreo, "Juan");
        FiltroPorRemitente fr = new FiltroPorRemitente(unCorreo,
                "Roberto Matias");
        FiltroPorAsunto filtro1 = new FiltroPorAsunto(unCorreo, "alto");
        FiltroPorTamanio filtro2 = new FiltroPorTamanio(210.0, unCorreo);
        FiltroAdjuntos filtro3 = new FiltroAdjuntos(unCorreo);
        List<IFiltro> filtros = new ArrayList<>(List.of(filtro1, filtro2, filtro3, fd, fr));
        IFiltro filtroOr = new FiltroOR(filtros);

        Boolean obtenido = filtroOr.aplicar();

        assertTrue(obtenido);
    }

    @Test
    void queElFiltroRemitenteYFiltroDestinoCumplanConSusCondiciones() {
        Correo unCorreo = new Correo("Roberto Matias", "Juan", "Junta importante por inicio de actividades", 220.4,
                false, "Reunion necesaria");

        FiltroPorDestinatario fd = new FiltroPorDestinatario(unCorreo, "Juan");
        FiltroPorRemitente fr = new FiltroPorRemitente(unCorreo, "Roberto Matias");
        List<IFiltro> filtros = new ArrayList<>(List.of(fd, fr));
        IFiltro filtroAnd = new FiltroAND(filtros);

        Boolean obtenido = filtroAnd.aplicar();

        assertTrue(obtenido);
    }

    @Test
    void dadoFiltroNot_DebeDarVerdaderoSiUnoDeEllosNoCumple() {
        Correo unCorreo = new Correo("Roberto Matias", "Juan",
                "Junta importante por inicio de actividades", 220.4, false,
                "Reunion necesaria");

        FiltroPorDestinatario fd = new FiltroPorDestinatario(unCorreo, "Juan");
        FiltroPorRemitente fr = new FiltroPorRemitente(unCorreo, "Roberto Lopez");

        IFiltro filtro = new FiltroNot(Arrays.asList(fd, fr));

        Boolean obtenido = filtro.aplicar();

        assertTrue(obtenido);
    }

    @Test
    void dadoUnFliltroNOR_DebeDarVerdaderoSiTodosLosFiltrosNoCumple() {
        Correo unCorreo = new Correo("Roberto Matias", "Juan",
                "Junta importante por inicio de actividades", 220.4, false,
                "Reunion necesaria");

        FiltroPorDestinatario fd = new FiltroPorDestinatario(unCorreo, "Alejandro britez");
        FiltroPorRemitente fr = new FiltroPorRemitente(unCorreo, "Roberto Lopez");

        IFiltro filtro = new FiltroNOR(Arrays.asList(fd, fr));

        Boolean obtenido = filtro.aplicar();

        assertTrue(obtenido);
    }

}
