import java.util.Scanner;

public class PasswordValidatorWithMethodsVariant1 {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine().toLowerCase();
        validate(password);
    }

    private static void validate(String password) {
        boolean numberOfCharacters = true;
        boolean digitsAndLetters = true;
        boolean numberOfDigits = true;

        int countCharacters = 0;
        int countLetters = 0;
        int countDigits = 0;

        for (int i = 0; i < password.length(); i++) {
            countCharacters = getNumberOfCharacters(password, countCharacters);
            countLetters = getNumberOfLetters(password, countLetters, i);
            countDigits = getNumberOfDigits(password, countDigits, i);
        }

        if (countCharacters < 6 || countCharacters > 10) {
            numberOfCharacters = false;
            System.out.println("Password must be between 6 and 10 characters");
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

    static int getNumberOfCharacters(String password, int countCharacters) {
        countCharacters++;
        return countCharacters;
    }

    static int getNumberOfLetters(String password, int countLetters, int i) {
        String tableLetters = "abcdefghijklmnopqrstuvwxyz";
        if (tableLetters.contains(password.charAt(i) + "")) {
            countLetters++;
        }
        return countLetters;
    }

    static int getNumberOfDigits(String password, int countDigits, int i) {
        String tableDigits = "0123456789";
        if (tableDigits.contains(password.charAt(i) + "")) {
            countDigits++;
        }
        return countDigits;
    }
}