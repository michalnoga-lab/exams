package zadanie_31;

public class Task_3_1 {

    private static void calculate(int number) {

        if (number > 0) {
            System.out.print(number + " ");
            calculate(number - 2);
            System.out.print(number + " ");
        }

    }

    public static void main(String[] args) {
        System.out.println("**********************************");
        calculate(5);
        System.out.println("\n" + "**********************************");
        calculate(6);
        System.out.println("\n" + "**********************************");
        calculate(7);
        System.out.println("\n" + "**********************************");
        calculate(8);
        System.out.println("\n" + "**********************************");
    }
}