package pregunta5;

public class ProvarTriangle {
    public static void main(String[] args) throws Exception {
        Triangle tri1 = new Triangle();
        tri1.setCostat1(3.0f);
        tri1.setCostat2(3.0f);
        tri1.setCostat3(5.0f);
        Triangle tri2 = new Triangle();
        tri2.setCostat1(4.0f);
        tri2.setCostat2(4.0f);
        tri2.setCostat3(4.0f);
        System.out.println(tri1.perimetre());
        System.out.println(tri2.perimetre());
        Triangle tri3 = new Triangle(2.0f,3.0f,4.0f);
        System.out.println(tri3.perimetre());
        Equilater triEqui1 = new Equilater(3,3,3);
        Isoseles triIsos2 = new Isoseles(3,3,2);
        Escale triEsca1 = new Escale(1,2,3);
    }
}
