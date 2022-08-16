package zadanie_32;

public class Task_3_2 {

    public static void main(String[] args) {
        System.out.println("************************************");
        System.out.println("first number: " + Integer.parseInt("10000000", 2) + ", second number: " + Integer.parseInt("A9", 16));
        System.out.println(Integer.parseInt("10000000", 2) > Integer.parseInt("A9", 16));
        System.out.println("************************************");
        System.out.println("first number: " + Integer.parseInt("1111", 4) + ", second number: " + Integer.parseInt("1111111", 2));
        System.out.println(Integer.parseInt("1111", 4) > Integer.parseInt("1111111", 2));
        System.out.println("************************************");
        System.out.println("first number: " + Integer.parseInt("3003", 4) + ", second number: " + Integer.parseInt("C2", 16));
        System.out.println(Integer.parseInt("3003", 4) > Integer.parseInt("C2", 16));
        System.out.println("************************************");
        System.out.println("first number: " + Integer.parseInt("333", 8) + ", second number: " + Integer.parseInt("10100101", 2));
        System.out.println(Integer.parseInt("333", 8) > Integer.parseInt("10100101", 2));
        System.out.println("************************************");
    }
}