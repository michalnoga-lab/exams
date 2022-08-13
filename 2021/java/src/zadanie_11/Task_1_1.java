package zadanie_11;

import java.util.*;

public class Task_1_1 {

    private static List<Integer> getAllFourDigitNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1000; i < 10000; i++) {
            numbers.add(i);
        }
        return numbers;
    }

    private static Integer getComplement(Integer number) {
        List<String> numberStr = Arrays.stream(String.valueOf(number).split("")).toList();
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < numberStr.size(); i++) {
            stringBuilder.append(9 - Integer.parseInt(numberStr.get(i)));
        }

        return Integer.valueOf(stringBuilder.toString());
    }

    private static List<Integer> getBiggestDifference(List<Integer> numbers) {
        List<Integer> output = new ArrayList<>(Arrays.asList(0, 0, 0));

        for (int i = 0; i < numbers.size(); i++) {
            Integer complement = getComplement(numbers.get(i));
            Integer difference = Math.abs(numbers.get(i) - complement);
            if (output.get(0) < difference && numbers.get(i) <= 5000) {
                output.set(0, difference);
                output.set(1, numbers.get(i));
                output.set(2, complement);
            }
        }

        return output;
    }

    private static List<Integer> getSmallestDifference(List<Integer> numbers) {

    }

    public static void main(String[] args) {
        System.out.println(getAllFourDigitNumbers());
        System.out.println(getComplement(1231));

        List<Integer> biggestDifference = getBiggestDifference(getAllFourDigitNumbers());
        List<Integer> smallestDifference = getSmallestDifference(getAllFourDigitNumbers());

        System.out.println("Największa różnica jest dla liczb: " + biggestDifference.get(1) + " oraz " + biggestDifference.get(2) + " i wynosi: " + biggestDifference.get(0));
        System.out.println("Najmniejsza różnica jest dla liczb: " + smallestDifference.get(1) + " oraz " + smallestDifference.get(2) + " i wynosi: " + smallestDifference.get(0));
    }
}