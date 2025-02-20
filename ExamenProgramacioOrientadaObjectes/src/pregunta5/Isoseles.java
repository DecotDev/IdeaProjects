package pregunta5;

public class Isoseles extends Triangle {

    public Isoseles(double costat1, double costat2, double costat3) throws Exception {
        super(costat1, costat2, costat3);
        if ( (costat1 == costat2 && (costat3 != costat1 && costat3 != costat2)) ||
                (costat1 == costat3 && (costat2 != costat1 && costat2 != costat3)) ||
                (costat2 == costat3 && (costat1 != costat2 && costat1 != costat3)) ) {
        }else {
            throw  new Exception("Les mides no son d'un isoseles.");
        }

    }
}
// c1 = 5, c2 = 5, c3 = 7