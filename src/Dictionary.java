import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class Dictionary {
    public static void main(String[] args) throws Exception {
        Scanner keyboard = new Scanner(System.in);
        BufferedReader inputStream = null;
        HashSet<String> dictionary = new HashSet<String>();
        String line = "";

        try {
            inputStream = new BufferedReader(new FileReader("dictionary.txt"));

            while ((line = inputStream.readLine()) != null) {
               dictionary.add(line);
            }

            System.out.println("Please input a sentence in English: ");
            String sentence = keyboard.nextLine();
            String[] input = sentence.split(" ");
            keyboard.close();

            for (int i = 0; i < input.length; i++) {
                if (dictionary.contains(input[i])) {
                    System.out.println(input[i] + "<valid>");
                } else {
                    System.out.println(input[i] + "<invalid>");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error opening file");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}