package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        File inputText = new File(args[0]);

        try (Scanner scanner = new Scanner(inputText)) {
            StringBuilder stringToBuild = new StringBuilder("");
            while (scanner.hasNextLine()) {
                stringToBuild.append(scanner.nextLine());
            }
            String inputString = stringToBuild.toString();
            Readability scorer = new Readability(inputString);
            scorer.printDetails();
        } catch (FileNotFoundException e) {
            System.out.println("There was a problem finding the input text file!");
        }
    }
}


