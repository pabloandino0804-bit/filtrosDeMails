package ar.edu.unahur.obj2.composite.correos;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CorreoTest {
    @Test
    void testCorreo() {
        Correo correo = new Correo("yo", "vos", "Muy importante", 250.0, Boolean.TRUE,
                "Reunión de consorcio para tratar problema con ascensor 1");

        assertTrue(correo.filtrar());
    }

    @Test
    void testGetCuerpo() {
        Correo correo = new Correo("yo", "vos", "Muy importante", 250.0, Boolean.TRUE,
                "Reunión de consulta para tratar problema con ascensor 1");

        assertTrue(correo.getCuerpo().contains("consulta"));
    }
}
