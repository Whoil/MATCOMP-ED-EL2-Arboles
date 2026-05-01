package ParteB.Grafo2;

public class Main {
    public static void main(String[] args) {
        Grafo<String> grafo = new Grafo<>();

        grafo.addArco("A", "B", "conoce");
        grafo.addArco("A", "C", "trabaja_con");
        grafo.addArco("B", "D", "visita");

        System.out.println("Grafo:");
        System.out.println(grafo);

        System.out.println("Adyacentes de A:");
        System.out.println(grafo.getAdyacentes("A"));

        grafo.addArco("A", "B", "conoce");

        System.out.println("Tras intentar duplicar A --conoce--> B:");
        System.out.println("Numero de nodos: " + grafo.getNodos().getSize());
        System.out.println("Numero de arcos: " + grafo.getArcos().getSize());
        System.out.println(grafo.caminoMinimo("A", "D"));
    }
}
