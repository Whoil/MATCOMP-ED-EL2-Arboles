public class ArbolBinarioDeBusqueda<T extends Comparable<T>>{
    private Nodo<T> raiz;


    public ArbolBinarioDeBusqueda(Nodo<T> raiz){
        this.raiz=raiz;
    }


    public Nodo<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    public boolean isEmpty(){
        return raiz==null; // devuelve true si no hay nodo raiz ( el árbol es vacío)
    }



    // Inserta un dato en el árbol de forma recursiva
    protected Nodo<T> addNodo(Nodo<T> actual,T dato){
        // Si no hay nodo en esta posición, se crea uno nuevo
        if(actual==null){

            return new  Nodo<>(dato);

        }
        //Comparamos de forma recursiva para decidir en qué dirección irá el dato

        // Si el dato es menor, irá a la izquierda
        if(actual.dato.compareTo(dato)>0){
            actual.izquierda=addNodo(actual.izquierda, dato);

        }
        // Si el dato es mayor, irá a la derecha
        else if (actual.dato.compareTo(dato)<0){
            actual.derecha=addNodo(actual.derecha, dato);
        }
        return actual;

    }

    //Inserta la raiz del árbol binario
    public void add(T dato){
        raiz = addNodo(raiz, dato);
    }


    protected int getAltura(Nodo<T> actual){
        if (actual==null){
            return 0;
        }
        int alturaIzquierda=getAltura(actual.izquierda);
        int alturaDerecha=getAltura(actual.derecha);
        return 1 + Math.max(alturaDerecha,alturaIzquierda);
    }



    public int getAlturaRaiz(){
        return getAltura(raiz);
    }


    protected  ListaSimplementeEnlazada<T> getListaPreOrden(){
        ListaSimplementeEnlazada<T> DatosPre=new ListaSimplementeEnlazada<>();
        return getListaPreOrden(raiz, DatosPre);
    }

   protected ListaSimplementeEnlazada<T> getListaPreOrden(Nodo<T> actual, ListaSimplementeEnlazada<T> DatosPre){
        if(actual==null){
            return DatosPre;
        }
       DatosPre.add(actual.getDato());
        getListaPreOrden(actual.getIzquierda(), DatosPre);
        getListaPreOrden(actual.getDerecha(), DatosPre);
        return DatosPre;

   }

   protected ListaSimplementeEnlazada<T> getListaOrdenCentral(Nodo<T> actual, ListaSimplementeEnlazada DatosCentral){
       if(actual==null){
           return DatosCentral;
       }
       getListaOrdenCentral(actual.getIzquierda(), DatosCentral);
       DatosCentral.add(actual.getDato());
       getListaOrdenCentral(actual.getDerecha(), DatosCentral);
       return DatosCentral;
   }

   protected ListaSimplementeEnlazada<T> getListaordenCentral(){
        ListaSimplementeEnlazada<T> DatosCentral= new ListaSimplementeEnlazada<>();
        return getListaOrdenCentral(raiz,DatosCentral);
   }


   protected ListaSimplementeEnlazada<T> getListaPostOrden(){
        ListaSimplementeEnlazada DatosPost=new ListaSimplementeEnlazada<>();
        return getListaPostorden(raiz,DatosPost);
   }


   protected ListaSimplementeEnlazada<T> getListaPostorden(Nodo<T> actual, ListaSimplementeEnlazada DatosPost){
        if(actual==null){
            return DatosPost;
        }
        getListaPostorden(actual.getIzquierda(), DatosPost);
        getListaPostorden(actual.getDerecha(), DatosPost);
        DatosPost.add(actual.getDato());
        return DatosPost;
   }


   protected ArbolBinarioDeBusqueda<T> getSubArbolDerecha(){
         ArbolBinarioDeBusqueda<T> SubArbol=new ArbolBinarioDeBusqueda<>(raiz);
        if(isEmpty()){
            return SubArbol ;

        }
        SubArbol.setRaiz(raiz.getDerecha());
        return SubArbol;

   }

   protected ArbolBinarioDeBusqueda<T> getSubArbolIzquierda(){
        ArbolBinarioDeBusqueda<T> SubArbol= new ArbolBinarioDeBusqueda<>(raiz);
        if(isEmpty()){
            return SubArbol;

        }
        SubArbol.setRaiz(raiz.getIzquierda());
        return SubArbol;

   }


   protected int getGrado(Nodo<T> actual){
       int gradoActual=0;
        if( actual==null){
            return 0;
       }
        if (actual.getIzquierda()!=null) gradoActual++;

        if (actual.getDerecha()!=null) gradoActual++;


        int gradoIzquierda = getGrado(actual.getIzquierda());
        int gradoDerecha= getGrado(actual.getDerecha());

        return Math.max(gradoActual,Math.max(gradoDerecha,gradoIzquierda));
   }

   public int gerGrado(){
        return getGrado(raiz);
   }




}
