package ParteB;

public class Arco<T> {
    private long id;
    private Nodo<T> origen;
    private Nodo<T> destino;
    private String dato;

    public Arco(){
        this.id=0;
        this.destino=null;
        this.origen=null;
        this.dato=null;

    }

    public Arco( long id, Nodo<T> destino, Nodo<T> origen, String dato){
        this.id=id;
        this.destino=destino;
        this.origen=origen;
        this.dato=dato;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Nodo<T> getOrigen() {
        return origen;
    }

    public void setOrigen(Nodo<T> origen) {
        this.origen = origen;
    }


    public Nodo<T> getDestino() {
        return destino;
    }

    public void setDestino(Nodo<T> destino) {
        this.destino = destino;
    }

    public String getDato() {
        return dato;
    }

    public void setDato(String dato) {
        this.dato = dato;
    }

    @Override
    public String toString() {
        return "(" + id + ", " + origen + ", " + dato + ", " + destino + ")";
    }
}
