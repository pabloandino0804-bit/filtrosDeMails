package ar.edu.unahur.obj2.composite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import ar.edu.unahur.obj2.composite.filtros.FiltroTamaño;

public class CuentaCorreoTests {
    @Test
    void queDevuelvaUnaListaDe2ElementosPorUnaCuentaConFiltroTamañoMayorA200() {
        Correo correo1 = new Correo("Junta importante por inicio de actividades", 220, "Reunion necesaria");
        Correo correo2 = new Correo("junta 2", 213, "segundo reunion");
        Correo correo3 = new Correo("junta de amigos", 140, "tercer reunion");
        Correo correo4 = new Correo("clase 4 presencial", 199, "cuarta semana de clases");

        CuentaCorreo miCuenta = new CuentaCorreo(new FiltroTamaño(200));

        assertEquals(miCuenta.solicitarEmails(correo1, correo2, correo3, correo4).size(), 2);
    }
}
