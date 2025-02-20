import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FnF {
    public void createFile(String folderPath, String fileName, ArrayList<String> content) throws IOException {
        File dir = new File(folderPath);
        if (!dir.exists()) dir.mkdirs();

        File file = new File(folderPath, fileName);
        FileWriter fw = new FileWriter(file);
        for (String c: content) {
            fw.write(c + "\n");
        }
        fw.close();
    }

    public ArrayList<String> readFile(String relPath) throws FileNotFoundException {
        //Ha de llegir el fitxer (path relatiu, l'arrel serà la ruta del projecte).
        File file = new File(relPath);
        Scanner sc = new Scanner(file);

        ArrayList<String> content = new ArrayList<>();
        while (sc.hasNextLine()) {
            content.add(sc.nextLine());
        }
        sc.close();
        return content;
    }
    public void afegirContent() throws IOException {
        ArrayList<String> content = new ArrayList<>();
        content.add("Línea 3 afegida amb un .add");
        content.add("Línea 3 afegida amb un .add");
        content.add("Línea 3 afegida amb un .add");
        createFile("folder1/folder2", "file", content);
    }
    public void llegirContent() throws FileNotFoundException {
        //File file = new File(file)
        ArrayList<String> llegit = readFile("folder1/folder2/file");
        System.out.println("El contingut es: " + "\n" + llegit);
    }
    public void borrarfile(){
        File file = new File("folder1/folder2/file");
        file.delete();
    }
}
