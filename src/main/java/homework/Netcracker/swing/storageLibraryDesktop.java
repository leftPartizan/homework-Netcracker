package homework.Netcracker.swing;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;


public class storageLibraryDesktop {

//    private String pathToStorage = "C:\\Users\\?\\Desktop\\Netracker\\";
    private String pathToStorage;
    private String nameFile;
    private String formatFile;
    private String path;

    public String getPath() {
        return path;
    }

    public storageLibraryDesktop() {
        nameFile = "storage";
        formatFile = ".json";
//        pathToStorage = storageLibraryDesktop.class.getProtectionDomain().getCodeSource().getLocation().getPath();
        String s = File.separator;
        pathToStorage = Paths.get("").toAbsolutePath().toString() + s + "src"
                + s + "java" + s + "homework" + s + "Netcracker" + s;
        path = pathToStorage + nameFile + formatFile;
    }

    public void setPath() {
        this.path = getPathToStorage() + getNameFile() + getFormatFile();
    }

    public void setPath(String path) {
        this.path = path + getNameFile() + getFormatFile();
    }

    public String getPathToStorage() {
        return pathToStorage;
    }

    public void setPathToStorage(String pathToStorage) {
        this.pathToStorage = pathToStorage;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }

    public String getFormatFile() {
        return formatFile;
    }

    public void setFormatFile(String formatFile) {
        this.formatFile = formatFile;
    }

    public void saveStorage(List<Book> books) throws IOException{
        FileOutputStream fos = new FileOutputStream(getPath());
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(books);
        oos.flush();
        oos.close();
    }

    public List<Book> loadStorage() throws IOException,ClassNotFoundException{
        FileInputStream fis = new FileInputStream(getPath());
        ObjectInputStream oin = new ObjectInputStream(fis);
        List<Book> books = (List<Book>) oin.readObject();
        return books;
    }

    public void saveStorage2(List<?> books) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            File a =  new File(getPath());
            mapper.writeValue(new File(getPath()), books);
            String jsonInString = mapper.writeValueAsString(books);
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public  List<Book> loadStorage2() {
        List<Book> obj = null;
        try {
            ObjectMapper mapper = new ObjectMapper();
            obj = mapper.readValue(new File(getPath()), new TypeReference<List<Book>>(){});
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
