package ParteA;

import Estructuras.ListaSE;

public class ArbolBinarioDeBusquedaEnteros extends ArbolBinarioDeBusqueda<Integer> {

    public int getSuma() {
        return getSuma(getRaiz());
    }

    private int getSuma(Nodo<Integer> actual) {
        if (actual == null) {
            return 0;
        }

        return actual.getDato()
                + getSuma(actual.getIzquierda())
                + getSuma(actual.getDerecha());
    }

    public int getSumaLista(ListaSE<Integer> lista) {
        int suma = 0;

        for (int i = 0; i < lista.getSize(); i++) {
            suma += lista.get(i);
        }

        return suma;
    }
}

