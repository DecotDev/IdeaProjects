package pregunta6;

public class Equilater extends Triangle {

    public Equilater(double costat1, double costat2, double costat3) throws Exception {
        super(costat1, costat2, costat3);
        if (costat1 != costat2 || costat2 != costat3) {
            throw new Exception("Les mides no son d'un equilater.");
        }

    }
}