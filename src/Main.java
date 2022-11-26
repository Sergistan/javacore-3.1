import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;

public class Main {

    static StringBuilder stringBuilder = new StringBuilder();
    static Date date = new Date();

    public static void main(String[] args) {

        createFolder("src", date);
        createFolder("res", date);
        createFolder("savegames", date);
        createFolder("temp", date);

        createFolder("/src/main", date);
        createFolder("/src/test", date);

        try {
            createFile("/src/main/Main.java", date);
            createFile("/src/main/Utils.java", date);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        createFolder("/res/drawables", date);
        createFolder("/res/vectors", date);
        createFolder("/res/icons", date);

        try {
            createFile("/temp/temp.txt", date);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try (FileWriter fileWriter = new FileWriter("D://GamesNet//temp/temp.txt")) {
            fileWriter.write(String.valueOf(stringBuilder));
            fileWriter.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }

    static void createFolder(String pathFolder, Date date) {
        File file = new File("D://GamesNet/" + pathFolder + "/");
        if (file.mkdir()) {
            stringBuilder.append("Папка " + pathFolder + " создана - " + date + "\n");
        } else {
            stringBuilder.append("Папка " + pathFolder + " не создана - " + date + "\n");
        }
    }

    static void createFile(String pathFiler, Date date) throws IOException {
        File file = new File("D://GamesNet/" + pathFiler);
        if (file.createNewFile()) {
            stringBuilder.append("Файл " + pathFiler + " создана - " + date + "\n");
        } else {
            stringBuilder.append("Файл " + pathFiler + " не создан - " + date + "\n");
        }
    }

}
