import java.util.Arrays;
import java.util.Scanner;

public class CurrencyExchangeBureau {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] currencies = {"USD", "EUR", "CAD", "CHF", "CNY", "RUB", "AUD"};
        long[] amounts = {100000, 100000, 100000, 100000, 100000, 100000, 100000};
        double[] rates = {1.74223, 1.95583, 1.33458, 1.77271, 2.5329, 2.76493, 1.22908};

        double totalPrice = 0;

        String command = scanner.nextLine();
        while (!"END".equals(command)) {

            //orders
            String[] commandAsStringArray = command.split(" ");
            String orderedCurrency = commandAsStringArray[0];
            String orderedAmountAsString = commandAsStringArray[1];
            long orderedQuantity = Long.parseLong(orderedAmountAsString);

            boolean hasToStop = false;

            //calculating prices and quantities
            for (int i = 0; i < currencies.length; i++) {
                for (int j = 0; j < amounts.length; j++) {
                    for (int k = 0; k < rates.length; k++) {

                        if (orderedCurrency.equals(currencies[i]) && i == j && i == k) {

                            if (amounts[j] >= orderedQuantity) {
                                double price = orderedQuantity * rates[k];
                                System.out.printf("%s x %d costs %.2f.%n",
                                        orderedCurrency, orderedQuantity, price);
                                totalPrice += price;
                                amounts[j] -= orderedQuantity;
                                hasToStop = true;

                            } else {
                                System.out.printf("We do not have enough %s. ", orderedCurrency);
                                System.out.printf("We have only %d %s left.%n", amounts[j], currencies[i]);
                                hasToStop = true;
                            }
                        }
                    }
                    if (hasToStop) {
                        break;
                    }
                }
                if (hasToStop) {
                    break;
                }
            }
            command = scanner.nextLine();
        }

        if ("END".equals(command)) {
            System.out.printf("Total price: %.2f.%n", totalPrice);
        }
    }
}