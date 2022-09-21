package zadanie_42;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task_4_2 {

    private static final String SOURCE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "zadanie_42" + System.getProperty("file.separator") + "instrukcje.txt";
    private static final String OUTPUT_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "zadanie_42" + System.getProperty("file.separator") + "wynik4.txt";

    public static List<String> getInstructionsFromFile() {
        List<String> instructions = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(SOURCE_PATH))) {

            stream.forEach(pair -> instructions.add(pair.split("\\s")[0]));

        } catch (Exception e) {
            System.out.println("Error reading from file");
        }

        return instructions;
    }

    public static void writeToFile(String data) {

        try (FileOutputStream fileOutputStream = new FileOutputStream(OUTPUT_PATH)) {

            fileOutputStream.write(data.getBytes());

        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }

    public static void main(String[] args) {
        List<String> instructions = getInstructionsFromFile();
        String longestInstruction = "";
        int longestSequence = 0;

        for (int i = 0; i < instructions.size() - 1; i++) {
            int tempLongest = 1;

            while (instructions.get(i).equals(instructions.get(i + 1))) {
                tempLongest++;
                i++;
            }

            if (tempLongest > longestSequence) {
                longestSequence = tempLongest;
                longestInstruction = instructions.get(i);
            }
        }

        writeToFile(longestInstruction + " - " + longestSequence);
    }
}