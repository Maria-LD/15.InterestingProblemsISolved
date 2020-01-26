import java.util.Scanner;

public class PasswordValidatorWithoutMethods {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine().toLowerCase();
        boolean numberOfCharacters = true;
        boolean digitsAndLetters = true;
        boolean numberOfDigits = true;

        if (password.length() < 6 || password.length() > 10) {
            numberOfCharacters = false;
            System.out.println("Password must be between 6 and 10 characters");
        }

        int countLetters = 0;
        int countDigits = 0;
        for (int i = 0; i < password.length(); i++) {

            String tableLetters = "abcdefghijklmnopqrstuvwxyz";
            String tableDigits = "0123456789";
            if (tableLetters.contains(password.charAt(i) + "")) {
                countLetters++;
            }

            if (tableDigits.contains(password.charAt(i) + "")) {
                countDigits++;
            }
        }

        if (countLetters + countDigits != password.length()) {
            digitsAndLetters = false;
            System.out.println("Password must consist only of letters and digits");
        }

        if (countDigits < 2) {
            numberOfDigits = false;
            System.out.println("Password must have at least 2 digits");
        }

        if (numberOfDigits && digitsAndLetters && numberOfCharacters) {
            System.out.println("Password is valid");
        }
    }
}