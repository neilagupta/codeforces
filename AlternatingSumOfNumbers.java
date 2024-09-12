import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://codeforces.com/problemset/problem/2010/A

public class AlternatingSumOfNumbers {
  public static void main(String[] args) {
    try {
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

      int testCases = Integer.parseInt(bufferedReader.readLine());
      
      for (int i = 0; i < testCases; i++) {
        int numberCount = Integer.parseInt(bufferedReader.readLine());
        String numbersString = bufferedReader.readLine().trim();
        String[] numbersInString = numbersString.split("\\s+");
        List<Integer> numbers = new ArrayList<>(numberCount);

        for (String numString : numbersInString) {
          numbers.add(Integer.parseInt(numString));
        }

        System.out.println(alternatingSum(numbers));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static int alternatingSum(List<Integer> numbers) {
    int sum = 0;
    int symbol = 1;

    for (int num : numbers) {
      sum += num * symbol;
      symbol *= -1;
    }

    return sum;
  }
}