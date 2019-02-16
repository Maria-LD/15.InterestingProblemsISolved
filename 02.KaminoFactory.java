import java.util.Scanner;

public class KaminoFactory {
    public static void main(String args[]) {

        Scanner scanner = new Scanner(System.in);

        int DNALength = Integer.parseInt(scanner.nextLine());
        String line = scanner.nextLine();

        /*the best values of the current variables from all inputs
          that meet the conditions in the problem*/
        int bestLength = 0;
        String bestDNA = "";
        int bestIndex = 0;
        int bestSum = 0;
        int counter = 0;
        int bestCounter = 0;

        while(!line.equals("Clone them!")) {
            counter++;

            String replacedLine = line.replaceAll("!", "");
            String[] dnas = replacedLine.split("0");

            int maxLength = 0;             //the longest sequence of 1s in the current input
            int sum = 0;                  //the sum of 1s
            String bestCurrentDNA = "";  //String with the greatest number of 1s in the current input

            for (int i = 0; i < dnas.length; i++) {
                if (dnas[i].length() > maxLength) {
                    maxLength = dnas[i].length();
                    bestCurrentDNA = dnas[i];
                }
                //since the String contains only 1s, its length in fact represents the sum of 1s in it
                sum += dnas[i].length();
            }

            //from what index the longest String of 1s in the current input starts
            int startIndex = replacedLine.indexOf(bestCurrentDNA);

            /*I overwrite all current variables in external ones,
             so they will be adequate for all inputs*/
            if (maxLength > bestLength) {
                bestLength = maxLength;
                bestDNA = replacedLine;
                bestIndex = startIndex;
                bestSum = sum;
                bestCounter = counter;

                //if there are several sequences with same length
            } else if (maxLength == bestLength &&
                    (startIndex < bestIndex || sum > bestSum)) {
                bestLength = maxLength;
                bestDNA = replacedLine;
                bestIndex = startIndex;
                bestSum = sum;
                bestCounter = counter;

                //if I have only 1 input
            } else if (counter == 1) {
                bestLength = maxLength;
                bestDNA = replacedLine;
                bestIndex = startIndex;
                bestSum = sum;
                bestCounter = counter;
            }

            line = scanner.nextLine();
        }

        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestCounter, bestSum));

        for (int i = 0; i < bestDNA.length(); i++) {
            System.out.print(bestDNA.charAt(i) + " ");
        }

        System.out.println();
    }
}