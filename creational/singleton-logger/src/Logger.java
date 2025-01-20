import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;  

public class Logger {
    private static Logger instance = null;
    private static File myFile = null;

    private Logger() {
        if (myFile == null) {
            myFile = new File("../log_files/log.txt");
            try {
                if (myFile.createNewFile()) {
                    System.out.println("File created: " + myFile.getName());
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }

    public static Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    private void writeToFile(String message) {
        if (myFile != null) {
            try {
                FileWriter myWriter = new FileWriter(myFile, true);
                myWriter.write(message + "\n");
                myWriter.close();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("File not found.");
        }
    }

    public void log(String message) {
        writeToFile(message);
    }
}