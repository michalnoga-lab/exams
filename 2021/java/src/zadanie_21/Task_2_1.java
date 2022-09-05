package zadanie_21;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task_2_1 {

    private static List<Integer> calculate(Integer[] T, Integer x) {
        List<Integer> output = new ArrayList<>();
        output.add(0);
        output.addAll(Arrays.asList(T));

        int n = T.length + 1;
        output.add(x);
        int s = n;

        while ((s / 2 >= 1) && (output.get(s) > output.get(output.get(s / 2)))) {
            Integer temp = output.get(s);
            output.set(s, output.get((s / 2)));
            output.set(output.get((s / 2)), temp);
            s = s / 2;
        }

        return output;
    }

    public static void main(String[] args) {
        Integer[] firstArray = new Integer[]{26, 3, 5, -4};
        List<Integer> firstCalculated = calculate(firstArray, 5);
        firstCalculated.remove(0);
        System.out.println("Dla tablicy " + Arrays.toString(firstArray) + " otrzymamy wartości " + firstCalculated);

    }
}