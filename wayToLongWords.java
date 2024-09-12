import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;


public class Solution {
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int n = Integer.parseInt(bufferedReader.readLine());

            while(n-- > 0) {
                String currWord = bufferedReader.readLine();

                int length = currWord.length();

                if (length > 10) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(currWord.charAt(0));
                    sb.append(length-2);
                    sb.append(currWord.charAt(length - 1));
                    System.out.println(sb.toString());
                } else {
                    System.out.println(currWord);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}