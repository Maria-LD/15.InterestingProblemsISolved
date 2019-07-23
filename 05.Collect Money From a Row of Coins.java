import java.util.Arrays;
import java.util.Scanner;

public class CollectMoneyFromARowOfCoins {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] rowOfCoins = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int position = 0;                       //position of the coin on which we have landed
        int sumOfCollectedMoney = rowOfCoins[0];
        boolean stop = false;

        while (true) {
            if (position + rowOfCoins[position] >= 0 && position + rowOfCoins[position] < rowOfCoins.length) {
                position += rowOfCoins[position];
                sumOfCollectedMoney += rowOfCoins[position];

            } else if (position + rowOfCoins[position] >= rowOfCoins.length) {
                if (position - rowOfCoins[position] > 0) {
                    position -= rowOfCoins[position];
                    sumOfCollectedMoney += rowOfCoins[position];
                } else if (position - rowOfCoins[position] == 0) {
                    sumOfCollectedMoney += rowOfCoins[position];
                    stop = true;
                } else {
                    stop = true;
                }
            }

            if(stop) {
                break;
            }
        }
        System.out.println(sumOfCollectedMoney);

    }
}