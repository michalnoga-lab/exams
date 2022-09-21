package zadanie_43;

import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task_4_3 {

    private static final String SOURCE_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "zadanie_43" + System.getProperty("file.separator") + "instrukcje.txt";
    private static final String OUTPUT_PATH = System.getProperty("user.dir") + System.getProperty("file.separator") + "src" + System.getProperty("file.separator") + "zadanie_43" + System.getProperty("file.separator") + "wynik4.txt";

    private static List<String> getCharactersFromFileForInstruction() {
        List<String> characters = new ArrayList<>();

        try (Stream<String> stream = Files.lines(Paths.get(SOURCE_PATH))) {
            stream
                    .filter(line -> line.contains("DOPISZ"))
                    .map(line -> line.split("\\s")[1])
                    .forEach(characters::add);
        } catch (Exception e) {
            System.out.println("Error reading from file");
        }
        return characters;
    }

    private static void writeToFile(String data) {
        try (FileOutputStream stream = new FileOutputStream(OUTPUT_PATH)) {
            stream.write(data.getBytes());
        } catch (Exception e) {
            System.out.println("Error writing to file");
        }
    }

    public static void main(String[] args) {
        List<String> allCharactersForAddInstruction = getCharactersFromFileForInstruction();

        Map.Entry<String, Long> mostFrequentElement = allCharactersForAddInstruction
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .orElseThrow(NoSuchElementException::new);


        writeToFile("Najczęściej pojawiającą się literą dla instrukcji DOPISZ jest: "
                + mostFrequentElement.getKey() + " pojawiające się " + mostFrequentElement.getValue() + " razy");
    }
}