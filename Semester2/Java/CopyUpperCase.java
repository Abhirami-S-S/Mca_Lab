
import java.io.*;

public class CopyUpperCase {
    public static void main(String[] args) {
        String source = "input.txt";
        String destination = "output.txt";

        try (
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(source));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(destination))
        ) {
            int ch;
            while ((ch = bis.read()) != -1) {
                char upper = Character.toUpperCase((char) ch);
                bos.write(upper);
            }
            System.out.println("File copied and converted to UPPERCASE successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}