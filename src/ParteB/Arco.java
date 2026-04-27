package ParteB;

public class Arco<T extends Comparable<T>> implements Comparable<Arco<T>> {

    private long id;
    private Nodo<T> origen;
    private Nodo<T> destino;
    private String dato;

    public Arco() {
        this.id = 0;
        this.origen = null;
        this.destino = null;
        this.dato = null;
    }

    public Arco(long id, Nodo<T> origen, Nodo<T> destino, String dato) {
        this.id = id;
        this.origen = origen;
        this.destino = destino;
        this.dato = dato;
    }

    public long getId() {
        return id;
    }

    public Nodo<T> getOrigen() {
        return origen;
    }

    public Nodo<T> getDestino() {
        return destino;
    }

    public String getDato() {
        return dato;
    }

    @Override
    public int compareTo(Arco<T> otro) {
        if (this.id < otro.getId()) {
            return -1;
        } else if (this.id > otro.getId()) {
            return 1;
        } else {
            return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + id + ", " + origen + ", " + dato + ", " + destino + ")";
    }
}

