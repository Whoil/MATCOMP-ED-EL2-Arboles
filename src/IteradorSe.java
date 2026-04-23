public class IteradorSe<T> implements MiIterador<T> {
    private ElementoSe<T> actual;

    public IteradorSe(ElementoSe<T> primero){
        this.actual=primero;
    }
    public boolean hasNext(){
        return actual!=null;
    }
    public T next(){
        T dato= actual.dato;
        actual=actual.siguiente;
        return dato;
    }
}
