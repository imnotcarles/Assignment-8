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

            System.out.println("Please enter a sentence in English: ");
            String sentence = keyboard.nextLine();
            System.out.println("Here is a spell check of your sentence: ");
            keyboard.close();

            String[] input = sentence.split(" ");

            for (int i = 0; i < input.length; i++) {
                if (dictionary.contains(input[i])) {
                    System.out.println(i + 1 + ". " + input[i] + " <valid>");
                } else {
                    System.out.println(i + 1 + ". " + input[i] + " <invalid>");
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("Error opening file.");
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }
}