
public class ArbolBinarioDeBusqueda<T extends Comparable<T>>{


    //Nodo raiz del árbol
    private Nodo<T> raiz;

    //Constructor que inicializa el árbol con una raíz dada
    public ArbolBinarioDeBusqueda(Nodo<T> raiz){
        this.raiz=raiz;
    }

    //Devuelve la raíz del árbol
    public Nodo<T> getRaiz() {
        return raiz;
    }

    //Cambia la raíz del árbol
    public void setRaiz(Nodo<T> raiz) {
        this.raiz = raiz;
    }

    //Comprueba que el árbol no está vacío
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

    //Inserta un dato comenzando desde la raíz
    public void add(T dato){
        raiz = addNodo(raiz, dato);
    }

    //Obtiene la altura de uno de los nodos de manera recursiva
    protected int getAltura(Nodo<T> actual){
        //Si no hay nodos, la altura es 0
        if (actual==null){
            return 0;
        }
        //Calcula la altura de los subárboles de la izquierda y la derecha de forma recursiva
        int alturaIzquierda=getAltura(actual.getIzquierda());
        int alturaDerecha=getAltura(actual.getDerecha());


        //La altura actual es 1 + la mayor de las alturas
        return 1 + Math.max(alturaDerecha,alturaIzquierda);
    }


    //Devuelve la altura del árbol completo
    public int getAlturaRaiz(){
        return getAltura(raiz);
    }

    //Crea una lista y la rellena del recorrido en preorden
    protected  ListaSE<T> getListaPreOrden(){
        ListaSE<T> DatosPre=new ListaSE<>();
        return getListaPreOrden(raiz, DatosPre);
    }

    //Recorre el árbol en preorden mientras: raíz, izquierda, derecha
   protected ListaSE<T> getListaPreOrden(Nodo<T> actual, ListaSE<T> DatosPre){

        //Caso base, si el nodo es nulo se devuelve la lista acumulada.
        if(actual==null){
            return DatosPre;
        }

        //Se inserta primero la raíz en la lista
       DatosPre.add(actual.getDato());
        //Luego recorre el subárbol izquiedo
        getListaPreOrden(actual.getIzquierda(), DatosPre);
        //Finalmente recorre el subárbol derecho.
        getListaPreOrden(actual.getDerecha(), DatosPre);
        return DatosPre;

   }


    // Crea una lista y la rellena con el recorrido en orden central
    protected ListaSE<T> getListaordenCentral(){
        ListaSE<T> DatosCentral= new ListaSE<>();
        return getListaOrdenCentral(raiz,DatosCentral);
    }

    //Recorre el árbol en orden central: izquierda, ráiz, derecha
   protected ListaSE<T> getListaOrdenCentral(Nodo<T> actual, ListaSE<T> DatosCentral){
       //Caso base, si el nodo es nulo devuelve la lista acumulada.
        if(actual==null){
           return DatosCentral;
       }

        //Recorre el subárbol izquierdo
       getListaOrdenCentral(actual.getIzquierda(), DatosCentral);
        //Añade el dato del nodo actual
       DatosCentral.add(actual.getDato());

       // Recorre el subárbol derecho
       getListaOrdenCentral(actual.getDerecha(), DatosCentral);
       return DatosCentral;
   }


    // Crea una lista y la rellena con el recorrido en postorden
   protected ListaSE<T> getListaPostOrden(){
        ListaSE<T> DatosPost=new ListaSE<>();
        return getListaPostorden(raiz,DatosPost);
   }

    // Recorre el árbol en postorden: izquierda, derecha, raíz
   protected ListaSE<T> getListaPostorden(Nodo<T> actual, ListaSE<T> DatosPost){
        if(actual==null){
            return DatosPost;
        }
       // Recorre el subárbol izquierdo
        getListaPostorden(actual.getIzquierda(), DatosPost);
       // Recorre el subárbol derecho
        getListaPostorden(actual.getDerecha(), DatosPost);
       // Añade el dato del nodo actual
        DatosPost.add(actual.getDato());
        return DatosPost;
   }

    // Devuelve el subárbol derecho del árbol actual
   protected ArbolBinarioDeBusqueda<T> getSubArbolDerecha(){
       // Devuelve el subárbol derecho del árbol actual
         ArbolBinarioDeBusqueda<T> SubArbol=new ArbolBinarioDeBusqueda<>(raiz);
       // Si el árbol actual está vacío, se devuelve vacío
        if(isEmpty()){
            return SubArbol ;

        }
       // La raíz del nuevo árbol será el hijo derecho de la raíz actual
        SubArbol.setRaiz(raiz.getDerecha());
        return SubArbol;

   }

    // Devuelve el subárbol izquierdo del árbol actual
   protected ArbolBinarioDeBusqueda<T> getSubArbolIzquierda(){
       // Se crea un nuevo árbol inicialmente con raíz nula
        ArbolBinarioDeBusqueda<T> SubArbol= new ArbolBinarioDeBusqueda<>(raiz);

       // Si el árbol actual está vacío, se devuelve vacío
        if(isEmpty()){
            return SubArbol;

        }
       // La raíz del nuevo árbol será el hijo izquierdo de la raíz actual
        SubArbol.setRaiz(raiz.getIzquierda());
        return SubArbol;

   }

    // Calcula el grado del árbol desde un nodo dado
    // El grado de un nodo es el número de hijos que tiene
   protected int getGrado(Nodo<T> actual){
       int gradoActual=0;
       // Si el nodo es nulo, su grado es 0
        if( actual==null){
            return 0;
       }
       // Si tiene hijo izquierdo, suma 1
        if (actual.getIzquierda()!=null) gradoActual++;

       // Si tiene hijo derecho, suma 1
        if (actual.getDerecha()!=null) gradoActual++;

       // Calcula el mayor grado en el subárbol izquierdo
        int gradoIzquierda = getGrado(actual.getIzquierda());

       // Calcula el mayor grado en el subárbol derecho
        int gradoDerecha= getGrado(actual.getDerecha());

       // Devuelve el mayor entre el nodo actual y sus subárboles
        return Math.max(gradoActual,Math.max(gradoDerecha,gradoIzquierda));
   }

    // Devuelve el grado del árbol completo
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

    //Comprueba que el árbol está equilibrado
    public boolean isEquilibrado(){
        return(isEquilibrado(raiz));
    }

    protected boolean isEquilibrado(Nodo<T> actual){
        //Caso base, si no existen más nodos devuelve true
        if (actual==null){
            return true;
        }
        //Se calcula la altura del subárbol derecho
        int alturaDerecha = getAltura(actual.getDerecha());

        //Se calcula la altura del subárbol izquierdo
        int alturaIzquierda= getAltura(actual.getIzquierda());

        //Se comprueba si existe desequilibrio
        if (Math.abs(alturaIzquierda-alturaDerecha)>1){
            return false;
        }

        //Repetimos el proceso de manera recursiva
        return isEquilibrado(actual.getIzquierda()) && isEquilibrado(actual.getDerecha());


    }

    public ListaSE<T> getListaDatosNivel(int nivel){
        ListaSE<T> ListaDatosNivel= new ListaSE<>();
        return getListaDatosNivel(raiz, nivel, 1,ListaDatosNivel);
    }

    private ListaSE<T> getListaDatosNivel(Nodo<T> actual, int nivelBuscado, int nivelActual, ListaSE<T> ListaNivel){
        if (actual==null){
            return ListaNivel;
        }

        if(nivelActual==nivelBuscado){
            ListaNivel.add(actual.getDato());
            return ListaNivel;
        }
        getListaDatosNivel(actual.getIzquierda(),nivelBuscado,nivelActual+1,ListaNivel);
        getListaDatosNivel(actual.getDerecha(),nivelBuscado,nivelActual+1,ListaNivel);

        return ListaNivel;


    }







}
