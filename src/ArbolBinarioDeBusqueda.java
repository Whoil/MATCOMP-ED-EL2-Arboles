
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
        int alturaIzquierda=getAltura(actual.getIzquierda());
        int alturaDerecha=getAltura(actual.getDerecha());
        return 1 + Math.max(alturaDerecha,alturaIzquierda);
    }



    public int getAlturaRaiz(){
        return getAltura(raiz);
    }


    protected  ListaSE<T> getListaPreOrden(){
        ListaSE<T> DatosPre=new ListaSE<>();
        return getListaPreOrden(raiz, DatosPre);
    }

   protected ListaSE<T> getListaPreOrden(Nodo<T> actual, ListaSE<T> DatosPre){
        if(actual==null){
            return DatosPre;
        }
       DatosPre.add(actual.getDato());
        getListaPreOrden(actual.getIzquierda(), DatosPre);
        getListaPreOrden(actual.getDerecha(), DatosPre);
        return DatosPre;

   }

   protected ListaSE<T> getListaOrdenCentral(Nodo<T> actual, ListaSE<T> DatosCentral){
       if(actual==null){
           return DatosCentral;
       }
       getListaOrdenCentral(actual.getIzquierda(), DatosCentral);
       DatosCentral.add(actual.getDato());
       getListaOrdenCentral(actual.getDerecha(), DatosCentral);
       return DatosCentral;
   }

   protected ListaSE<T> getListaordenCentral(){
       ListaSE<T> DatosCentral= new ListaSE<>();
        return getListaOrdenCentral(raiz,DatosCentral);
   }


   protected ListaSE<T> getListaPostOrden(){
        ListaSE<T> DatosPost=new ListaSE<>();
        return getListaPostorden(raiz,DatosPost);
   }


   protected ListaSE<T> getListaPostorden(Nodo<T> actual, ListaSE<T> DatosPost){
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


    // Devuelve una lista con el camino desde la raíz hasta el dato buscado.
   public ListaSE<T> getCamino(T dato){


       ListaSE<T> camino=new ListaSE<>();

        boolean encontrado= getCamino(raiz, dato,camino);

       // Si el dato no se encuentra, devuelve una lista vacía.
       if(encontrado==false){
           return new ListaSE<>();
       }
        return camino;
    }

    // Método auxiliar recursivo que busca el dato en el árbol binario de búsqueda.
    protected boolean getCamino(Nodo<T> actual, T dato, ListaSE<T> camino) {
        // Recorre recursivamente el árbol desde el nodo actual.
        // Si el nodo es null, el dato no se ha encontrado en esta rama.

        if (actual == null) {
            return false;
        }
        // Va añadiendo a la lista los datos de los nodos por los que pasa.
        camino.add(actual.getDato());

        if (actual.getDato().compareTo(dato) == 0) {
            // Si encuentra el dato, devuelve true.
            return true;

        } else if (actual.getDato().compareTo(dato) > 0) {
            // Si el dato buscado es menor, continúa por la izquierda.
            return getCamino(actual.getIzquierda(), dato, camino);

        } else {
            // Si es mayor, continúa por la derecha.
            return getCamino(actual.getDerecha(), dato, camino);

        }
    }





}
