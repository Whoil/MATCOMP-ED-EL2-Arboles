public class ListaSimplementeEnlazada<T extends Comparable<T>> {
    //Hacemos referencia al primer nodo de la lista.
    //Si está vacía, es primero será null
    protected ElementoSe<T> primero;

    //Guardamos el tamaño de la lista para no tener que contar nodos.
    protected int tamaño;

    //Este constructor crea una lista vacía.
    public ListaSimplementeEnlazada(){
        //El primer elemento es nulo.
        this.primero=null;
        //El tamaño es 0 (vacía).
        this.tamaño=0;
    }
    //Devuelve true si está vacía

    public boolean isEmpty(){
        //Usamos el tamaño para no tener que comprobar nodos
        return tamaño==0;
    }
    //Devuelve el tamaño de la lista

    public int getTamaño(){
        return tamaño;
    }
    //Insertamos elementos

    public void add(T dato){
        ElementoSe<T> nuevo= new  ElementoSe<T>(dato);
        if (isEmpty()) {
            primero = nuevo;
        }
        else{
            ElementoSe<T> aux=primero;
            while (aux.siguiente !=null){
                aux= aux.siguiente;
            }
            aux.siguiente=nuevo;
        }
        tamaño++;
    }
    public T del(T dato){
        if (isEmpty()) return null;
        ElementoSe<T> ant=null;
        ElementoSe<T> act=primero;

        while (act!=null){
            if (act.dato.compareTo(dato)==0){
                if (ant==null)primero=act.siguiente;
                else ant.siguiente=act.siguiente;
                tamaño--;
                return act.dato;
            }
            ant=act;
            act=act.siguiente;



        }
        return null;

    }
    public T get(T dato) {
        ElementoSe<T> aux = primero;
        while (aux != null) {
            if (aux.dato.compareTo(dato) == 0) {
                return aux.dato;
            }
            aux = aux.siguiente;
        }
        return null;
    }

}


