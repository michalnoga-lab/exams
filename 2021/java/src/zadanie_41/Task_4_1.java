package zadanie_41;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Task_4_1 {


    private static final String SOURCE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "zadanie_41" + System.getProperty("file.separator") + "instrukcje.txt";
    private static final String OUTPUT_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "zadanie_41" + System.getProperty("file.separator") + "wynik4.txt";

    private static List<String> getInstructionsFromFile() {
        List<String> instructions = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(SOURCE_PATH))) {

            stream.forEach(instructions::add);

        } catch (Exception e) {
            System.out.println("Word list file not found!");
        }

        return instructions;
    }

    private static void saveToFile(String data) {

        try (FileOutputStream stream = new FileOutputStream(OUTPUT_PATH, false)) {
            stream.write(data.getBytes());
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }

    public static void main(String[] args) {
        List<String> instructions = getInstructionsFromFile();
        List<String> output = new ArrayList<>();

        while (instructions.size() > 0) {
            String currentElement = instructions.get(0);
            String firstPart = currentElement.split("\\s")[0];
            String secondPart = currentElement.split("\\s")[1];

            switch (firstPart) {
                case "DOPISZ": {
                    output.add(secondPart);
                    break;
                }
                case "ZMIEN": {
                    output.remove(output.size() - 1);
                    output.add(secondPart);
                    break;
                }
                case "USUN": {
                    output.remove(output.size() - 1);
                    break;
                }
                case "PRZESUN": {
                    for (int i = 0; i < output.size(); i++) {
                        if (output.get(i).equals(secondPart)) {
                            char letter = secondPart.charAt(0);
                            int letterCode = letter;
                            if (letterCode >= 90) {
                                letterCode = 65;
                            } else {
                                letterCode += 1;
                            }
                            letter = (char) letterCode;
                            output.set(i, String.valueOf(letter));
                            break;
                        }
                    }
                    break;
                }
            }
            instructions.remove(0);
        }

        saveToFile(String.valueOf(output.stream().reduce("", (subtotal, element) -> subtotal + element).length()));
    }
}