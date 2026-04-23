public class Nodo< T  extends Comparable<T> >{
   protected T dato;
   protected Nodo<T> izquierda;
   protected Nodo<T> derecha;

   public Nodo(T dato, Nodo<T> izquierda, Nodo<T> derecha){
       this.dato=dato;
       this.izquierda=izquierda;
       this.derecha=derecha;
    }


    public Nodo(T dato){
        this(dato,null,null);
    }


    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }


    public Nodo<T> getDerecha() {
        return derecha;
    }

    public void setDerecha(Nodo<T> derecha) {
        this.derecha = derecha;
    }

    public Nodo<T> getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(Nodo<T> izquierda) {
        this.izquierda = izquierda;
    }
}
