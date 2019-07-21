import java.util.Arrays;
import java.util.Scanner;

public class OrdersAndInventoryInAShopOrStorage {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] products = scanner.nextLine().split(" ");
        long[] quantities = Arrays.stream(scanner.nextLine().split(" "))
                .mapToLong(Long::parseLong)
                .toArray();
        double[] prices = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        //if lengths of the Strings in the input are different
        long[] quantitiesSameLength = new long[products.length];
        for (int i = 0; i < quantitiesSameLength.length; i++) {
            for (int j = 0; j < quantities.length; j++) {
                if (i == j) {
                    quantitiesSameLength[i] = quantities[j];
                }
                if (i > j) {
                    quantitiesSameLength[i] = 0;
                }
            }
        }

        String command = scanner.nextLine();
        while (!"Done".equals(command)) {

            //orders
            String[] commandAsStringArray = command.split(" ");
            String orderedProduct = commandAsStringArray[0];
            String orderedQuantityAsString = commandAsStringArray[1];
            long orderedQuantity = Long.parseLong(orderedQuantityAsString);

            boolean hasToStop = false;

            //calculating prices and quantities
            for (int i = 0; i < products.length; i++) {
                for (int j = 0; j < quantitiesSameLength.length; j++) {
                    for (int k = 0; k < prices.length; k++) {

                        if (orderedProduct.equals(products[i]) && i == j && i == k) {

                            if (quantitiesSameLength[j] >= orderedQuantity) {
                                double finalPrice = orderedQuantity * prices[k];
                                System.out.printf("%s x %d costs %.2f%n",
                                        orderedProduct, orderedQuantity, finalPrice);
                                quantitiesSameLength[j] -= orderedQuantity;
                                hasToStop = true;

                            } else {
                                System.out.printf("We do not have enough %s%n", orderedProduct);
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
    }
}