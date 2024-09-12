import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TandomRepeats {
    public static void main(String[] args) {
        //Problem 1948D
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());

            int inputChecks = Integer.parseInt(st.nextToken());

            for (int i = 0; i < inputChecks; i++) {
                String input = bufferedReader.readLine();
                System.out.println(tandomRepeat(input));
            }

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }

    public static int tandomRepeat(String input) {
        // Find midpoint and split in half

        String leftString = input.substring(0, input.length() / 2);
        String rightString = input.substring(input.length() / 2);
        int max = 0;
        for (int startLeft = 0; startLeft < leftString.length(); startLeft++) {
            int rightPointer = 0;
            int leftPointer = startLeft;
            int counter = 0;
            while (leftPointer < leftString.length() && rightPointer < rightString.length()) {
                char leftStringCurrChar = leftString.charAt(leftPointer);
                char rightStringCurrChar = rightString.charAt(rightPointer);
                if (leftStringCurrChar != rightStringCurrChar && leftStringCurrChar != '?' && rightStringCurrChar != '?') {
                    max = Math.max(max, counter);
                    break;
                }
                counter++;
                rightPointer++;
                leftPointer++;
                if (leftPointer == leftString.length())
                    max = Math.max(max, counter);
            }
        }
        return max*2;
    }
}