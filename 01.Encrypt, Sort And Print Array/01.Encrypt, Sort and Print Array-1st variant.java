import java.util.Arrays;
import java.util.Scanner;

public class EncriptSortAndPrintArray {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        int[] sumAsArr = new int[n];
        int index = 0;                      //index of sumAsArr

        for (int i = 0; i < n; i++) {
            String str = scanner.nextLine();
            char[] letters = str.toCharArray();

            int vowlsSum = 0;
            int consonantsSum = 0;
            int wholeSum = 0;

            for (int j = 0; j < letters.length; j++) {

                if (letters[j] == 'a' || letters[j] == 'e' || letters[j] == 'i' || letters[j] == 'o' || letters[j] == 'u' ||
                        letters[j] == 'A' || letters[j] == 'E' || letters[j] == 'I' || letters[j] == 'O' || letters[j] == 'U') {
                    vowlsSum += (int) letters[j] * str.length();
                } else {
                    consonantsSum += (int) letters[j] / str.length();
                }

                wholeSum = vowlsSum + consonantsSum;
            }

            sumAsArr[index] = wholeSum;
            index++;
        }

        Arrays.sort(sumAsArr);

        for (int a : sumAsArr) {
            System.out.println(a);
        }

    }
}
