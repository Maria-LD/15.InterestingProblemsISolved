import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrackingPartyOrHappeningGuests {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        List<String> names = new ArrayList<>();

        while (!"End".equals(command)) {
            String[] data = command.split("\\s+");

            if (data.length == 3) {

                if (names.contains(data[0])) {
                    System.out.printf("%s is already in the list!%n", data[0]);
                } else {
                    names.add(data[0]);
                }

            } else {

                if (!names.contains(data[0])) {
                    System.out.printf("%s is not in the list!%n", data[0]);
                } else {
                    names.remove(data[0]);
                }
            }

            command = scanner.nextLine();
        }

        System.out.println(String.join("\n", names));
    }
}