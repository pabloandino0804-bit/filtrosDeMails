package ar.edu.unahur.obj2.composite;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.filtros.FiltroPorAsunto;
import ar.edu.unahur.obj2.composite.filtros.FiltroTamaño;
import ar.edu.unahur.obj2.composite.filtros.FiltroTieneAdjunto;

public class FiltrosTest {
    @Test
    void QueUnFiltroPorAsuntoCumplaCuandoCumpleLaCondicionExacta(){
        Correo unCorreo = new Correo("Junta importante por inicio de actividades", 220, true,"Reunion necesaria");
        FiltroPorAsunto filtro = new FiltroPorAsunto("importante");

        Boolean obtenido = filtro.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void QueUnFiltroTieneAdjuntoCumplaCuandoCumpleLaCondicionExacta(){
        Correo unCorreo = new Correo("Junta importante por inicio de actividades", 220, true,"Reunion necesaria");
        FiltroTieneAdjunto filtroAdjunto = new FiltroTieneAdjunto();

        Boolean obtenido = filtroAdjunto.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void QueUnFiltroTamañoCumplaCuandoCumpleLaCondicionExacta(){
        Correo unCorreo = new Correo("Junta importante por inicio de actividades", 220, true,"Reunion necesaria");
        FiltroTamaño filtroTamaño = new FiltroTamaño(210);

        Boolean obtenido = filtroTamaño.cumple(unCorreo);

        assertTrue(obtenido);
    }
}
