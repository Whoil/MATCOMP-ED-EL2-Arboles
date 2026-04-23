//Un nodo (Elemento) de una lista simplemente enlazada.

class ElementoSe<T>{
    //Guarda el dato real del nodo. Es de tipo T (genérico)
    //Es decir, si T es Integer, aquí habrá un Integer, etc.

    T dato;

    // Es una flecha que apunta al siguiente elemento de la lista.
    //Si es el último elemento, siguiente será null.
    ElementoSe<T> siguiente;

    //El constructor: crea un nodo con un dato dentro.
    ElementoSe(T dato){
        //Guardamos el dato dentro del nodo.
        //Por defecto, al crear un nodo no está enganchado a nadie, por eso el siguiente no apunta a nadie.

        this.dato=dato;
        this.siguiente=null;
    }
}