package zadanie_12;

import java.util.ArrayList;
import java.util.List;

public class Task_1_2 {

    private static Integer calculateComplement(Integer number) {
        Integer numberToCalculate = number;
        List<Integer> tempNumberList = new ArrayList<>();
        int result = 0;

        while (numberToCalculate > 0) {
            int tempNumber = numberToCalculate % 10;
            tempNumberList.add(9 - tempNumber);
            numberToCalculate /= 10;

        }

        for (int i = 0; i < tempNumberList.size(); i++) {
            result += tempNumberList.get(i) * Math.pow(10, i);
        }

        return result;
    }

    public static void main(String[] args) {

        int firstNumber = 123;
        int firstComplement = calculateComplement(firstNumber);
        System.out.println("Dopełnieniem liczby " + firstNumber + " jest " + firstComplement);

        int secondNumber = 231;
        int secondComplement = calculateComplement(secondNumber);
        System.out.println("Dopełnieniem liczby " + secondNumber + " jest " + secondComplement);

        int thirdNumber = 987654321;
        int thirdComplement = calculateComplement(thirdNumber);

        System.out.println("Dopełnieniem liczby " + thirdNumber + " jest " + thirdComplement);
    }
}