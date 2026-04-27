package ParteB;

public class Triplete implements Comparable<Triplete> {

    private String s;
    private String p;
    private String o;

    public Triplete() {
        this.s = null;
        this.p = null;
        this.o = null;
    }

    public Triplete(String s, String p, String o) {
        this.s = s;
        this.p = p;
        this.o = o;
    }

    public String getS() {
        return s;
    }

    public String getP() {
        return p;
    }

    public String getO() {
        return o;
    }

    @Override
    public int compareTo(Triplete otro) {
        return this.toString().compareTo(otro.toString());
    }

    @Override
    public String toString() {
        return "(" + s + ", " + p + ", " + o + ")";
    }
}

