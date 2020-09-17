//package test;

import org.junit.Test;
import static org.junit.Assert.*;

public class PruebasTest {

    @Test
    public void probando(){
        Pruebas prueba = new Pruebas();
        boolean respuesta = prueba.metodo();
        assertTrue(respuesta);
    }
}