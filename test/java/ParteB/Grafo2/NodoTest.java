package ParteB.Grafo2;

import Estructuras.ListaSE;
import Estructuras.MiIterador;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NodoTest {

    private <T extends Comparable<T>> int contarElementos(ListaSE<T> lista) {
        int contador = 0;
        MiIterador<T> iterador = lista.getIterador();

        while (iterador.hasNext()) {
            iterador.next();
            contador++;
        }

        return contador;
    }

    @Test
    void constructorYGetters() {
        Nodo<Integer> nodo = new Nodo<>(1, 10);

        assertEquals(1, nodo.getId());
        assertEquals(10, nodo.getDato());
        assertNotNull(nodo.getArcosEntrada());
        assertNotNull(nodo.getArcosSalida());
        assertEquals(0, contarElementos(nodo.getArcosEntrada()));
        assertEquals(0, contarElementos(nodo.getArcosSalida()));
    }

    @Test
    void settersIdYDatoa() {
        Nodo<Integer> nodo = new Nodo<>(1, 10);

        nodo.setId(5);
        nodo.setDato(20);

        assertEquals(5, nodo.getId());
        assertEquals(20, nodo.getDato());
    }

    @Test
    void setArcosEntradaYSetArcosSalida() {
        Nodo<Integer> origen = new Nodo<>(1, 10);
        Nodo<Integer> destino = new Nodo<>(2, 20);
        Arco<Integer> arco = new Arco<>(1, "une", origen, destino);

        ListaSE<Arco<Integer>> entrada = new ListaSE<>();
        ListaSE<Arco<Integer>> salida = new ListaSE<>();

        entrada.addLast(arco);
        salida.addLast(arco);

        origen.setArcosEntrada(entrada);
        origen.setArcosSalida(salida);

        assertEquals(1, contarElementos(origen.getArcosEntrada()));
        assertEquals(1, contarElementos(origen.getArcosSalida()));
    }

    @Test
    void addArcoEntradaYAddArcoSalida() {
        Nodo<Integer> origen = new Nodo<>(1, 10);
        Nodo<Integer> destino = new Nodo<>(2, 20);
        Arco<Integer> arco = new Arco<>(1, "une", origen, destino);

        origen.addArcoSalida(arco);
        destino.addArcoEntrada(arco);

        assertEquals(1, contarElementos(origen.getArcosSalida()));
        assertEquals(1, contarElementos(destino.getArcosEntrada()));
    }

    @Test
    void compareToDevuelveMenorMayorEIgual() {
        Nodo<Integer> n1 = new Nodo<>(1, 10);
        Nodo<Integer> n2 = new Nodo<>(2, 20);
        Nodo<Integer> n3 = new Nodo<>(3, 10);

        assertTrue(n1.compareTo(n2) < 0);
        assertTrue(n2.compareTo(n1) > 0);
        assertEquals(0, n1.compareTo(n3));
    }

    @Test
    void toStringNodo() {
        Nodo<Integer> nodo = new Nodo<>(7, 99);

        assertEquals("(7, 99)", nodo.toString());
    }
}