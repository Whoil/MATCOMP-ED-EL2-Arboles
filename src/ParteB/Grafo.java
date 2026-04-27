package ParteB;

import Estructuras.ListaSE;
import Estructuras.Cola;

public class Grafo {

    private ListaSE<Nodo<String>> nodos;
    private ListaSE<Arco<String>> arcos;
    private long idNodo;
    private long idArco;

    public Grafo() {
        nodos = new ListaSE<>();
        arcos = new ListaSE<>();
        idNodo = 1;
        idArco = 1;
    }

    public void addTriplete(Triplete triplete) {
        Nodo<String> origen = buscarOCrearNodo(triplete.getS());
        Nodo<String> destino = buscarOCrearNodo(triplete.getO());

        Arco<String> arco = new Arco<>(idArco, origen, destino, triplete.getP());
        arcos.addLast(arco);
        idArco++;
    }

    private Nodo<String> buscarOCrearNodo(String dato) {
        Nodo<String> nodo = buscarNodo(dato);

        if (nodo == null) {
            nodo = new Nodo<>(idNodo, dato);
            nodos.addLast(nodo);
            idNodo++;
        }

        return nodo;
    }

    private Nodo<String> buscarNodo(String dato) {
        for (int i = 0; i < nodos.getSize(); i++) {
            Nodo<String> nodo = nodos.get(i);

            if (nodo.getDato().compareTo(dato) == 0) {
                return nodo;
            }
        }

        return null;
    }

    public ListaSE<String> caminoMinimo(String inicio, String fin) {
        ListaSE<String> visitados = new ListaSE<>();
        ListaSE<String> padresNodo = new ListaSE<>();
        ListaSE<String> padresAnterior = new ListaSE<>();
        Cola<String> cola = new Cola<>();

        cola.offer(inicio);
        visitados.addLast(inicio);
        padresNodo.addLast(inicio);
        padresAnterior.addLast("");

        while (!cola.isEmpty()) {
            String actual = cola.poll();

            if (actual.compareTo(fin) == 0) {
                return reconstruirCamino(fin, padresNodo, padresAnterior);
            }

            ListaSE<String> vecinos = getVecinos(actual);

            for (int i = 0; i < vecinos.getSize(); i++) {
                String vecino = vecinos.get(i);

                if (!visitados.existeDato(vecino)) {
                    visitados.addLast(vecino);
                    cola.offer(vecino);

                    padresNodo.addLast(vecino);
                    padresAnterior.addLast(actual);
                }
            }
        }

        return new ListaSE<>();
    }

    private ListaSE<String> reconstruirCamino(String fin, ListaSE<String> padresNodo, ListaSE<String> padresAnterior) {
        ListaSE<String> camino = new ListaSE<>();
        String actual = fin;

        while (actual != null && actual.compareTo("") != 0) {
            camino.addLast(actual);

            String anterior = "";

            for (int i = 0; i < padresNodo.getSize(); i++) {
                if (padresNodo.get(i).compareTo(actual) == 0) {
                    anterior = padresAnterior.get(i);
                }
            }

            actual = anterior;
        }

        camino.invertir();
        return camino;
    }

    private ListaSE<String> getVecinos(String dato) {
        ListaSE<String> vecinos = new ListaSE<>();

        for (int i = 0; i < arcos.getSize(); i++) {
            Arco<String> arco = arcos.get(i);

            if (arco.getOrigen().getDato().compareTo(dato) == 0) {
                if (!vecinos.existeDato(arco.getDestino().getDato())) {
                    vecinos.addLast(arco.getDestino().getDato());
                }
            }

            if (arco.getDestino().getDato().compareTo(dato) == 0) {
                if (!vecinos.existeDato(arco.getOrigen().getDato())) {
                    vecinos.addLast(arco.getOrigen().getDato());
                }
            }
        }

        return vecinos;
    }

    public boolean isDisjunto() {
        if (nodos.isEmpty()) {
            return false;
        }

        ListaSE<String> visitados = new ListaSE<>();
        Cola<String> cola = new Cola<>();

        String primero = nodos.get(0).getDato();

        cola.offer(primero);
        visitados.addLast(primero);

        while (!cola.isEmpty()) {
            String actual = cola.poll();
            ListaSE<String> vecinos = getVecinos(actual);

            for (int i = 0; i < vecinos.getSize(); i++) {
                String vecino = vecinos.get(i);

                if (!visitados.existeDato(vecino)) {
                    visitados.addLast(vecino);
                    cola.offer(vecino);
                }
            }
        }

        return visitados.getSize() != nodos.getSize();
    }

    public ListaSE<String> getTiposNodos() {
        ListaSE<String> tipos = new ListaSE<>();

        for (int i = 0; i < nodos.getSize(); i++) {
            String dato = nodos.get(i).getDato();
            String tipo = obtenerTipo(dato);

            if (!tipos.existeDato(tipo)) {
                tipos.addLast(tipo);
            }
        }

        return tipos;
    }

    private String obtenerTipo(String dato) {
        int posicion = dato.indexOf(":");

        if (posicion == -1) {
            return "sin_tipo";
        }

        return dato.substring(0, posicion);
    }

    public ListaSE<String> getFisicosNacidosComoEinstein() {
        ListaSE<String> respuesta = new ListaSE<>();
        String ciudadEinstein = buscarObjeto("persona:Einstein", "nace_en");

        for (int i = 0; i < nodos.getSize(); i++) {
            String persona = nodos.get(i).getDato();

            if (obtenerTipo(persona).compareTo("persona") == 0
                    && persona.compareTo("persona:Einstein") != 0) {

                boolean esFisico = existeTriplete(persona, "profesion", "profesion:Fisico");
                boolean esNobel = existeTriplete(persona, "premio", "premio:NobelFisica");
                boolean mismaCiudad = existeTriplete(persona, "nace_en", ciudadEinstein);

                if (esFisico && esNobel && mismaCiudad) {
                    respuesta.addLast(persona);
                }
            }
        }

        return respuesta;
    }

    public ListaSE<String> getLugaresNacimientoPremiosNobel() {
        ListaSE<String> lugares = new ListaSE<>();

        for (int i = 0; i < nodos.getSize(); i++) {
            String persona = nodos.get(i).getDato();

            if (obtenerTipo(persona).compareTo("persona") == 0) {
                boolean tienePremioNobel = tienePredicado(persona, "premio");
                String lugar = buscarObjeto(persona, "nace_en");

                if (tienePremioNobel && lugar != null && !lugares.existeDato(lugar)) {
                    lugares.addLast(lugar);
                }
            }
        }

        return lugares;
    }

    private String buscarObjeto(String sujeto, String predicado) {
        for (int i = 0; i < arcos.getSize(); i++) {
            Arco<String> arco = arcos.get(i);

            if (arco.getOrigen().getDato().compareTo(sujeto) == 0
                    && arco.getDato().compareTo(predicado) == 0) {
                return arco.getDestino().getDato();
            }
        }

        return null;
    }

    private boolean tienePredicado(String sujeto, String predicado) {
        for (int i = 0; i < arcos.getSize(); i++) {
            Arco<String> arco = arcos.get(i);

            if (arco.getOrigen().getDato().compareTo(sujeto) == 0
                    && arco.getDato().compareTo(predicado) == 0) {
                return true;
            }
        }

        return false;
    }

    private boolean existeTriplete(String sujeto, String predicado, String objeto) {
        for (int i = 0; i < arcos.getSize(); i++) {
            Arco<String> arco = arcos.get(i);

            if (arco.getOrigen().getDato().compareTo(sujeto) == 0
                    && arco.getDato().compareTo(predicado) == 0
                    && arco.getDestino().getDato().compareTo(objeto) == 0) {
                return true;
            }
        }

        return false;
    }

    public String toString() {
        return arcos.toString();
    }
}

