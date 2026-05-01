3.
    iv. Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho. ¿Por qué?

        La suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho junto con la raíz.
        Esto ocurre porque un árbol binario se divide en tres partes: el subárbol izquierdo, la raíz y el subárbol derecho.
        Por eso, para obtener la suma total del árbol, hay que sumar esas tres partes.
        No sería suficiente sumar solo el subárbol izquierdo y el subárbol derecho, porque faltaría el valor almacenado en la raíz.
        Por tanto:
        suma total = suma subárbol izquierdo + raíz + suma subárbol derecho.
        El resultado coincide con getSuma() porque se están sumando todos los nodos del árbol exactamente una vez.

    v. ¿Cuál es la altura del árbol?

        8.

    vi. ¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino?

        El camino es [63, 95, 111, 103, 107, 109, 110] y la longitud de el camino es 6.

4.
    iv. Verifica que la suma es la misma cuando se suman los elementos de los subárboles izquierdo y derecho. ¿Por qué?

        En el árbol creado con números aleatorios, la suma también coincide cuando se suman los elementos del subárbol izquierdo,
        los elementos del subárbol derecho y el valor de la raíz. Esto ocurre porque, aunque los números se hayan insertado en orden aleatorio,
        el árbol sigue estando formado por tres partes principales:el subárbol izquierdo, la raíz y el subárbol derecho.
        Por tanto, la suma total del árbol se sigue calculando de la misma forma que antes, ya que los valores numericos siguen siendo todos los número de el 0 al 128.

    v. ¿Cuál es la altura del árbol? ¿por qué?

        La altura del árbol es 8 porque se insertan 129 números, desde el 0 hasta el 128, y el árbol se va equilibrando mediante rotaciones.
        En mi código, cada vez que se añade un dato con add(), se llama al método equilibrarArbol(). Este método comprueba si un lado del árbol pesa mucho más que el otro y,
        si hace falta, realiza giros a la izquierda o a la derecha. Gracias a eso, el árbol no queda inclinado como una lista, sino que se mantiene bastante equilibrado.
        Por eso normalmente la altura se mantiene en 8.

    vi. ¿Cuál es el camino para llegar al valor 110? ¿Cuál es su longitud de camino?

        En el árbol aleatorio, el camino para llegar al valor 110 depende del orden en el que se hayan insertado los números.
        Ya que el 110 no siempre va a estar wen el mismo nivel respecto a la raiz ni en el mismo nodo, ya que se insertan numeros aleatoriamente.

* Explique las diferencias (si las ha habido) de los resultados obtenidos entre los dos programas de prueba.

    En los dos programas la suma total es la misma, porque se insertan los mismos números: del 0 al 128. Por eso getSuma() da 8256 en los dos casos.
    También da la misma suma usando preorden, orden central y postorden, porque los tres recorridos pasan por todos los nodos del árbol.
    Lo único que cambia entre ellos es el orden en el que recorren los datos. La diferencia principal está en la forma interna del árbol.
    En el primer programa los números se insertan en orden, mientras que en el segundo se insertan de forma aleatoria. Esto puede hacer que cambien la raíz, los subárboles y el camino hasta un número concreto, como el 110.
    En mi implementación, el árbol se equilibra mediante rotaciones, por eso la altura se mantiene baja. En el programa ordenado la altura es 8. En el programa aleatorio normalmente también sale 8, aunque podría variar un poco dependiendo del orden aleatorio de inserción.

* ¿Qué sucede con los resultados si ejecuta los programas de prueba varias veces?

    El programa ordenado siempre da los mismos resultados, porque los números se insertan siempre en el mismo orden.
    El programa aleatorio puede cambiar algunos resultados cada vez que se ejecuta, porque el orden de inserción cambia.
    La suma total seguirá siendo siempre 8256, pero pueden cambiar el camino hasta el valor 110, la longitud de ese camino, la raíz y la forma del árbol.
    La altura suele mantenerse en 8 porque el árbol está equilibrado, aunque en alguna ejecución podría cambiar ligeramente.
