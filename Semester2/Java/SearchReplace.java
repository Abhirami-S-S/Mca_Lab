
import java.io.*;

public class SearchReplace {
    public static void main(String[] args) {
        String source = "input.txt";
        String destination = "output.txt";
        String searchWord = "hi ";
        String replaceWord = "Hello";

        int count = 0;

        try (
                BufferedReader br = new BufferedReader(new FileReader(source));
                BufferedWriter bw = new BufferedWriter(new FileWriter(destination))) {
            String line;

            while ((line = br.readLine()) != null) {
                while (line.contains(searchWord)) {
                    line = line.replaceFirst(searchWord, replaceWord);
                    count++;
                }
                bw.write(line);
                bw.newLine();
            }

            System.out.println("Replacements made: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}