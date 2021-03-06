import java.util.Arrays;
import java.util.Scanner;

public class ArrayManipulator {
    public static void main (String args[]) {

        Scanner scanner = new Scanner(System.in);

        String[] inputData = scanner.nextLine().split("\\s+");
        int numbers[] = new int[inputData.length];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = Integer.parseInt(inputData[i]);
        }

        String input = "";

        while (!"end".equals(input = scanner.nextLine())) {
            String[] data = input.split("\\s+");
            String command = data[0];

            switch (command) {
                case "exchange":
                    int index = Integer.parseInt(data[1]);
                    exchangeArray(numbers, index);
                    break;

                case "min":
                    minElementIndex(numbers, data[1]);
                    break;

                case "max":
                    maxElementIndex(numbers, data[1]);
                    break;

                case "first":
                    firstCountElements(numbers, Integer.parseInt(data[1]), data[2]);
                    break;

                case "last":
                    lastCountElements(numbers, Integer.parseInt(data[1]), data[2]);
                    break;
            }
        }

        System.out.println(Arrays.toString(numbers));
    }

    static void lastCountElements(int[] numbers, int count, String data) {

        if(count < 0 || count > numbers.length) {
            System.out.println("Invalid count");
            return;
        }

        int num = "even".equals(data) ? 0 : 1;

        int index = 0;
        int result[] = new int[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == num) {

                if (index == result.length){
                    result = changeArraySize(result);
                }
                result[index++] = numbers[i];
            }
        }

        if (index == 0) {
            System.out.println("[]");
        } else {
            int minCount = Math.min(count, result.length);
            String output = "[";
            int countElements = 0;
            for (int i = 0; i < minCount; i++) {
                if (i < minCount - 1) {
                    output += result[result.length - minCount + countElements++] + ", ";
                } else {
                    output += result[result.length - minCount + countElements++] + "]";
                }
            }
            System.out.println(output);
        }
    }

    static void firstCountElements(int[] numbers, int count, String data) {

        if(count < 0 || count > numbers.length) {
            System.out.println("Invalid count");
            return;
        }

        int num = "even".equals(data) ? 0 : 1;

        int index = 0;
        int result[] = new int[0];

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == num) {

                if (index == result.length){
                    result = changeArraySize(result);
                }
               result[index++] = numbers[i];
            }
        }

        if (index == 0) {
            System.out.println("[]");
        } else {
            int minCount = Math.min(count, result.length);
            String output = "[";
            for (int i = 0; i < minCount; i++) {
                if (i < minCount - 1) {
                    output += result[i] + ", ";
                } else {
                    output += result[i] + "]";
                }
            }
            System.out.println(output);
        }
    }

    static int[] changeArraySize(int[] result) {

        int[] newArray = new int[result.length + 1];

        for (int i = 0; i < result.length; i++) {
            newArray[i] = result[i];
        }

        return newArray;
    }

    static void minElementIndex(int[] numbers, String data) {

        int num = "even".equals(data) ? 0 : 1;

        int minElement = Integer.MAX_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == num) {
                if (numbers[i] <= minElement) {
                    minElement = numbers[i];
                    index = i;
                }
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    static void maxElementIndex(int[] numbers, String data) {

        int num = "even".equals(data) ? 0 : 1;

        int maxElement = Integer.MIN_VALUE;
        int index = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == num) {
                if (numbers[i] >= maxElement) {
                    maxElement = numbers[i];
                    index = i;
                }
            }
        }

        if (index == -1) {
            System.out.println("No matches");
        } else {
            System.out.println(index);
        }
    }

    static void exchangeArray(int[] numbers, int index) {

        if (index < 0 || index >= numbers.length) {
            System.out.println("Invalid index");
            return;
        }

        int count = 0;
        int[] result = new int[numbers.length];

        for (int i = index + 1; i < numbers.length; i++) {
            result[count++] = numbers[i];
        }

        for (int i = 0; i <= index; i++) {
            result[count++] = numbers[i];
        }

        for (int i = 0; i < result.length; i++) {
            numbers[i] = result[i];
        }
    }
}