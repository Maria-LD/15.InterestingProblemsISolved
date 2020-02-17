import java.util.Scanner;

public class PasswordValidatorWithMethodsVariant2 {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        String password = scanner.nextLine().toLowerCase();

        if (validatePassword(password)) {
            System.out.println("Password is valid");
        }

    }

    static boolean validatePassword(String password) {

        boolean isValid = true;

        if (!checkLegth(password)) {
            System.out.println("Password must be between 6 and 10 characters");
            isValid = false;
        }

        if (!containLettersAndDigits(password)) {
            System.out.println("Password must consist only of letters and digits");
            isValid = false;
        }

        if (!hasAtLeastTwoDigits(password)) {
            System.out.println("Password must have at least 2 digits");
            isValid = false;
        }



        return isValid;
    }

    static boolean hasAtLeastTwoDigits (String password) {
        int counter = 0;

        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                counter++;
                if (counter == 2) {
                    return true;
            }
            }
        }
        return false;
    }

    static boolean containLettersAndDigits(String pasword) {
        boolean lettersAndDigitsAreValid = true;

        for (int i = 0; i < pasword.length(); i++) {
            if (!Character.isLetterOrDigit(pasword.charAt(i))) {
                lettersAndDigitsAreValid = false;
                break;
            }
        }
        return lettersAndDigitsAreValid;
    }

    static boolean checkLegth(String password) {
        boolean lengthIsValid = false;
        if (password.length() >= 6 && password.length() <= 10) {
            lengthIsValid = true;
        }
        return lengthIsValid;
    }
}