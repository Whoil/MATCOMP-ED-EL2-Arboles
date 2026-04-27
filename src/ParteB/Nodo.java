package ParteB;

public class Nodo<T extends Comparable<T>> implements Comparable<Nodo<T>> {

    private long id;
    private T dato;

    public Nodo() {
        this.id = 0;
        this.dato = null;
    }

    public Nodo(long id, T dato) {
        this.id = id;
        this.dato = dato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    @Override
    public int compareTo(Nodo<T> otro) {
        return this.dato.compareTo(otro.getDato());
    }

    @Override
    public String toString() {
        return "(" + id + ", " + dato + ")";
    }
}

