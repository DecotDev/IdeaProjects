package pregunta2;

public class Triangle {
    double costat1;
    double costat2;
    double costat3;

    public double getCostat1() {
        return costat1;
    }

    public void setCostat1(double costat1) {
        this.costat1 = costat1;
    }

    public double getCostat3() {
        return costat3;
    }

    public void setCostat3(double costat3) {
        this.costat3 = costat3;
    }

    public double getCostat2() {
        return costat2;
    }

    public void setCostat2(double costat2) {
        this.costat2 = costat2;
    }

    public Triangle() {
    }

    public double perimetre(){
        return costat1 + costat2 + costat3;
    }
}
