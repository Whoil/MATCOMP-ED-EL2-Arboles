import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class MainTest {
    private ArbolBinarioDeBusqueda<Integer> crearArbol() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();
        arbol.add(8);
        arbol.add(3);
        arbol.add(10);
        arbol.add(1);
        arbol.add(6);
        return arbol;
    }

    @Test
    void arbolVacio() {
        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        assertTrue(arbol.isEmpty());
        assertEquals(0, arbol.getAlturaRaiz());
        assertEquals(0, arbol.getGrado());
        assertTrue(arbol.isArbolHomogeneo());
        assertTrue(arbol.isArbolCompleto());
        assertTrue(arbol.isArbolCasiCompleto());
        assertTrue(arbol.isEquilibrado());
    }

    @Test
    void alturaYGrado() {
        ArbolBinarioDeBusqueda<Integer> arbol = crearArbol();

        assertEquals(3, arbol.getAlturaRaiz());
        assertEquals(2, arbol.getGrado());
    }

    @Test
    void recorridos() {
        ArbolBinarioDeBusqueda<Integer> arbol = crearArbol();

        assertEquals("[8, 3, 1, 6, 10]", arbol.getListaPreOrden().toString());
        assertEquals("[1, 3, 6, 8, 10]", arbol.getListaOrdenCentral().toString());
        assertEquals("[1, 6, 3, 10, 8]", arbol.getListaPostOrden().toString());
    }

    @Test
    void camino() {
        ArbolBinarioDeBusqueda<Integer> arbol = crearArbol();

        assertEquals("[8, 3, 6]", arbol.getCamino(6).toString());
        assertEquals("[8, 10]", arbol.getCamino(10).toString());
        assertEquals("[]", arbol.getCamino(99).toString());
    }

    @Test
    void niveles() {
        ArbolBinarioDeBusqueda<Integer> arbol = crearArbol();

        assertEquals("[8]", arbol.getListaDatosNivel(1).toString());
        assertEquals("[3, 10]", arbol.getListaDatosNivel(2).toString());
        assertEquals("[1, 6]", arbol.getListaDatosNivel(3).toString());
    }

    @Test
    void tiposDeArbol() {
        ArbolBinarioDeBusqueda<Integer> arbol = crearArbol();

        assertTrue(arbol.isArbolHomogeneo());
        assertFalse(arbol.isArbolCompleto());
        assertTrue(arbol.isArbolCasiCompleto());
        assertTrue(arbol.isEquilibrado());
    }

    @Test
    void subArboles() {
        ArbolBinarioDeBusqueda<Integer> arbol = crearArbol();

        assertEquals("[1, 3, 6]", arbol.getSubArbolIzquierda().getListaOrdenCentral().toString());
        assertEquals("[10]", arbol.getSubArbolDerecha().getListaOrdenCentral().toString());
    }

}