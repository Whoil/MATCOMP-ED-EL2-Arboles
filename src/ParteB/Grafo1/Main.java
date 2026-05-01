package ParteB.Grafo1;

public class Main {

    public static void main(String[] args) {

        Grafo grafo = new Grafo();

        grafo.addTriplete(new Triplete("persona:Einstein", "nace_en", "lugar:Ulm"));
        grafo.addTriplete(new Triplete("persona:Einstein", "profesion", "profesion:Fisico"));
        grafo.addTriplete(new Triplete("persona:Einstein", "premio", "premio:NobelFisica"));

        grafo.addTriplete(new Triplete("persona:MaxBorn", "nace_en", "lugar:Ulm"));
        grafo.addTriplete(new Triplete("persona:MaxBorn", "profesion", "profesion:Fisico"));
        grafo.addTriplete(new Triplete("persona:MaxBorn", "premio", "premio:NobelFisica"));

        grafo.addTriplete(new Triplete("persona:MarieCurie", "nace_en", "lugar:Varsovia"));
        grafo.addTriplete(new Triplete("persona:MarieCurie", "profesion", "profesion:Fisico"));
        grafo.addTriplete(new Triplete("persona:MarieCurie", "premio", "premio:NobelFisica"));

        grafo.addTriplete(new Triplete("persona:Antonio", "nace_en", "lugar:Villarrubia de los Caballeros"));

        System.out.println("GRAFO DE CONOCIMIENTO");
        System.out.println("---------------------");
        System.out.println(grafo);

        System.out.println();
        System.out.println("Camino minimo entre Einstein y MaxBorn:");
        System.out.println(grafo.caminoMinimo("persona:Einstein", "persona:MaxBorn"));

        System.out.println();
        System.out.println("El grafo es disjunto:");
        System.out.println(grafo.isDisjunto());

        System.out.println();
        System.out.println("Fisicos famosos nacidos en la misma ciudad que Einstein:");
        System.out.println(grafo.getFisicosNacidosComoEinstein());

        System.out.println();
        System.out.println("Lugares de nacimiento de premios Nobel:");
        System.out.println(grafo.getLugaresNacimientoPremiosNobel());

        System.out.println();
        System.out.println("Tipos de nodos del grafo:");
        System.out.println(grafo.getTiposNodos());
    }
}

