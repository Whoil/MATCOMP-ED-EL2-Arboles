package ParteA;

public class Main {
    public static void main(String[] args) {

        ArbolBinarioDeBusqueda<Integer> arbol = new ArbolBinarioDeBusqueda<>();

        arbol.add(8);
        arbol.add(3);
        arbol.add(10);
        arbol.add(1);
        arbol.add(6);

        System.out.println("ÁRBOL BINARIO DE BÚSQUEDA");
        System.out.println("------------------------");

        System.out.println("Altura del árbol: " + arbol.getAlturaRaiz());
        System.out.println("Grado del árbol: " + arbol.getGrado());

        System.out.println("Preorden: " + arbol.getListaPreOrden());
        System.out.println("Orden central: " + arbol.getListaOrdenCentral());
        System.out.println("Postorden: " + arbol.getListaPostOrden());

        System.out.println("Camino hasta 6: " + arbol.getCamino(6));
        System.out.println("Datos del nivel 1: " + arbol.getListaDatosNivel(1));
        System.out.println("Datos del nivel 2: " + arbol.getListaDatosNivel(2));
        System.out.println("Datos del nivel 3: " + arbol.getListaDatosNivel(3));

        System.out.println("¿Árbol homogéneo?: " + arbol.isArbolHomogeneo());
        System.out.println("¿Árbol completo?: " + arbol.isArbolCompleto());
        System.out.println("¿Árbol casi completo?: " + arbol.isArbolCasiCompleto());
        System.out.println("¿Árbol equilibrado?: " + arbol.isEquilibrado());

        System.out.println("Subárbol izquierdo en orden central: " + arbol.getSubArbolIzquierda().getListaOrdenCentral());
        System.out.println("Subárbol derecho en orden central: " + arbol.getSubArbolDerecha().getListaOrdenCentral());


        ArbolBinarioDeBusqueda<Integer> arbolEquilibrado = new ArbolBinarioDeBusqueda<>();

        arbolEquilibrado.add(1);
        arbolEquilibrado.add(2);
        arbolEquilibrado.add(3);
        arbolEquilibrado.add(4);
        arbolEquilibrado.add(5);

        System.out.println();
        System.out.println("PRUEBA DE EQUILIBRADO");
        System.out.println("---------------------");
        System.out.println("Orden central: " + arbolEquilibrado.getListaOrdenCentral());
        System.out.println("Preorden: " + arbolEquilibrado.getListaPreOrden());
        System.out.println("Altura del árbol: " + arbolEquilibrado.getAlturaRaiz());
        System.out.println("¿Árbol equilibrado?: " + arbolEquilibrado.isEquilibrado());

    }
}
