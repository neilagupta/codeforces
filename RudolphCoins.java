import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;


public class RudolphCoins {

    //Rudolf and the Ticket 1941A
    public static void main(String[] args) {

        try {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            int g = Integer.parseInt(bufferedReader.readLine());
            int n = 0, m = 0, k = 0;

            for (int testIndex = 0; testIndex < g; testIndex++) {
                int[] leftCoins = new int[0];
                int[] rightCoins = new int[0];
                
                for (int i = 0; i < 3; i++) {
                    StringTokenizer st = new StringTokenizer(bufferedReader.readLine()); 
                    if (i == 0) {
                        n = Integer.parseInt(st.nextToken());
                        m = Integer.parseInt(st.nextToken());
                        k = Integer.parseInt(st.nextToken());
                    } else if (i == 1) {                    
                        leftCoins = new int[n];
                        for (int leftIndex = 0; leftIndex < n; leftIndex++) {
                            leftCoins[leftIndex] = Integer.parseInt(st.nextToken());
                        }
                    } else if (i == 2) {      
                        rightCoins = new int[m];              
                        for (int rightIndex = 0; rightIndex < m; rightIndex++) {
                            rightCoins[rightIndex] = Integer.parseInt(st.nextToken());
                        }
                    }
                }
                System.out.println(result(leftCoins, rightCoins, k));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int result(int[] leftCoins, int[] rightCoins, int k) {
        int count = 0;
        for (int leftIndex = 0; leftIndex < leftCoins.length; leftIndex++) {
            for (int rightIndex = 0; rightIndex < rightCoins.length; rightIndex++) {
                if (leftCoins[leftIndex] + rightCoins[rightIndex] <= k)
                    count++;
            }
        }
        return count;
    }
}