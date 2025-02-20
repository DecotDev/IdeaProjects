import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        //Crear dirs
        FnF fnf = new FnF();

        //ArrayList<String> content = new ArrayList<>(Arrays.asList("Linea 1", "Linea 2"));
        ArrayList<String> content = new ArrayList<>();
        content.add("Línea 3 afegida amb un .add");
        content.add("Línea 3 afegida amb un .add");
        content.add("Línea 3 afegida amb un .add");
        fnf.createFile("folder1/folder2", "file", content);

        //Llegir content
        //ArrayList<String> llegit = fnf.readFile("folder1/folder2/file");
        //System.out.println("El contingut es: " + "\n" + llegit);
        fnf.llegirContent();

        //Borrar dir i fitxer
        File file = new File("folder1/folder2/file");
        file.delete();

        File dir = new File("folder1/folder2");
        dir.delete();

        dir = new File("folder1");
        dir.delete();
    }
}
