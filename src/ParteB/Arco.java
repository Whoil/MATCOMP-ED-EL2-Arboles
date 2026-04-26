package ParteB;

public class Arco<T> {
    private long id;
    private Nodo<T> origen;
    private Nodo<T> destino;
    private T dato;

    public Arco(){
        this.id=0;
        this.destino=null;
        this.origen=null;
        this.dato=null;

    }

    public Arco( long id, Nodo<T> destino, Nodo<T> origen, T dato){
        this.id=id;
        this.destino=destino;
        this.origen=origen;
        this.dato=dato;
    }



    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }


    public Nodo<T> getDestino() {
        return destino;
    }

    public void setDestino(Nodo<T> destino) {
        this.destino = destino;
    }

    public Nodo<T> getOrigen() {
        return origen;
    }

    public void setOrigen(Nodo<T> origen) {
        this.origen = origen;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + origen + ", " + dato + ", " + destino + ")";
    }
}
