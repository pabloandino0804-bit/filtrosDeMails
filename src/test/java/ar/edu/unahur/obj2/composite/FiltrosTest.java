package ar.edu.unahur.obj2.composite;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.filtros.Filtro;
import ar.edu.unahur.obj2.composite.filtros.FiltroDestino;
import ar.edu.unahur.obj2.composite.filtros.FiltroPorAsunto;
import ar.edu.unahur.obj2.composite.filtros.FiltroRemitente;
import ar.edu.unahur.obj2.composite.filtros.FiltroTamaño;
import ar.edu.unahur.obj2.composite.filtros.FiltroTieneAdjunto;
import ar.edu.unahur.obj2.composite.filtros.filtroscompuestos.FiltroAND;
import ar.edu.unahur.obj2.composite.filtros.filtroscompuestos.FiltroNot;
import ar.edu.unahur.obj2.composite.filtros.filtroscompuestos.FiltroOR;

public class FiltrosTest {
    @Test
    void queElCuerpoTengaLaPalabraImportante() {
        Correo unCorreo = new Correo("Junta importante por inicio de actividades", 220, "Hoy habra una reunion importante");

        assertTrue(unCorreo.getCuerpo().contains("importante"));
    }

    @Test
    void QueUnFiltroPorAsuntoCumplaCuandoCumpleLaCondicionExacta(){
        Correo unCorreo = new Correo("Junta importante por inicio de actividades", 220, "Reunion necesaria");
        FiltroPorAsunto filtro = new FiltroPorAsunto("importante");

        Boolean obtenido = filtro.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void QueUnFiltroTieneAdjuntoCumplaCuandoCumpleLaCondicionExacta(){
        Correo unCorreo = new Correo("Roberto", "Juan", "Junta importante por inicio de actividades", 220, true,"Reunion necesaria");
        FiltroTieneAdjunto filtroAdjunto = new FiltroTieneAdjunto();

        Boolean obtenido = filtroAdjunto.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void QueUnFiltroTamañoCumplaCuandoCumpleLaCondicionExacta(){
        Correo unCorreo = new Correo("Roberto", "Juan", "Junta importante por inicio de actividades", 220, true,"Reunion necesaria");
        FiltroTamaño filtroTamaño = new FiltroTamaño(210);

        Boolean obtenido = filtroTamaño.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void QueUnFiltroANDNoCumplaCuandoNoCumplenSusCondiciones(){
        Correo unCorreo = new Correo("Roberto", "Juan", "Junta importante por inicio de actividades", 220, false,"Reunion necesaria");
        
        FiltroDestino filtroDestino = new FiltroDestino("null");
        FiltroRemitente filtroRemitente = new FiltroRemitente("null");
        FiltroPorAsunto filtro1 = new FiltroPorAsunto("importante");
        FiltroTamaño filtro2 = new FiltroTamaño(210);
        FiltroTieneAdjunto filtro3 = new FiltroTieneAdjunto();

        FiltroAND filtroAnd = new FiltroAND(filtro1, filtro2, filtro3, filtroDestino, filtroRemitente);

        Boolean obtenido = filtroAnd.cumple(unCorreo);

        assertFalse(obtenido);
    }

    @Test
    void QueUnFiltroORCumplaCuandoCuandoSeCumpleAlgunaDeSusFunciones(){
        Correo unCorreo = new Correo("Junta importante por inicio de actividades", 220, "Reunion necesaria");
        
        FiltroDestino filtroDestino = new FiltroDestino("Juan");
        FiltroRemitente filtroRemitente = new FiltroRemitente("Roberto Matias");
        

        FiltroPorAsunto filtro1 = new FiltroPorAsunto("alto");
        FiltroTamaño filtro2 = new FiltroTamaño(210);
        FiltroTieneAdjunto filtro3 = new FiltroTieneAdjunto();

        FiltroOR filtroOr = new FiltroOR(filtro1, filtro2, filtro3, filtroDestino, filtroRemitente);

        Boolean obtenido = filtroOr.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void QueElFiltroNotAltereLaCondicionDeUnFiltroTamanioSiNoCumple() {
        Correo unCorreo = new Correo("Junta importante por inicio de actividades", 220,"Reunion necesaria");
        FiltroTamaño filtroTamaño = new FiltroTamaño(240);

        Filtro filtroAlterado = new FiltroNot(filtroTamaño);

        Boolean obtenido = filtroAlterado.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void QueElFiltroRemitenteYFiltroDestinoCumplanConSusCondiciones() {
        Correo unCorreo = new Correo("Roberto Matias", "Juan", "Junta importante por inicio de actividades", 220, false,"Reunion necesaria");

        FiltroDestino filtroDestino = new FiltroDestino("Juan");
        FiltroRemitente filtroRemitente = new FiltroRemitente("Roberto Matias");
        
        FiltroAND filtroAnd = new FiltroAND(filtroDestino, filtroRemitente);

        Boolean obtenido = filtroAnd.cumple(unCorreo);

        assertTrue(obtenido);
    }

    @Test
    void Filtro() {
        Correo unCorreo = new Correo("Roberto Matias", "Juan", "Junta importante por inicio de actividades", 220, false,"Reunion necesaria");

        FiltroDestino filtroDestino = new FiltroDestino("Juan");
        FiltroRemitente filtroRemitente = new FiltroRemitente("Roberto Matias");
        
        FiltroAND filtro = new FiltroAND(filtroDestino, filtroRemitente);

        Boolean obtenido = filtro.cumple(unCorreo);

        assertTrue(obtenido);
    }
}
