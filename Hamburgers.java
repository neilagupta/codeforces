import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.lang.StringBuilder;

public class Hamburgers {
    public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String recipe = bufferedReader.readLine();

            StringTokenizer st = new StringTokenizer(bufferedReader.readLine());
            int bread = Integer.parseInt(st.nextToken());
            int sausage = Integer.parseInt(st.nextToken());
            int cheese = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(bufferedReader.readLine());
            int breadPrice = Integer.parseInt(st.nextToken());
            int sausagePrice = Integer.parseInt(st.nextToken());
            int cheesePrice = Integer.parseInt(st.nextToken());

            String rublesString = bufferedReader.readLine();
            long rubles = Long.parseLong(rublesString);

            long start = System.currentTimeMillis();

            //parse recipe in integer values
            int breadNeeded = 0;
            int sausageNeeded = 0;
            int cheeseNeeded = 0;

            char[] recipeArray = recipe.toCharArray();

            for (char c : recipeArray) {
                if (c == 'B')
                    breadNeeded++;
                if (c == 'S')
                    sausageNeeded++;
                if (c == 'C')
                    cheeseNeeded++;
            }
            long end = System.currentTimeMillis();
            // System.out.println(end - start);
            
            if (breadNeeded == 0)
                bread = 0;
            if (sausageNeeded == 0)
                sausage = 0;
            if (cheeseNeeded == 0)
                cheese = 0;
            long hamburgers = 0;

            while (rubles >= 0) {
                if (bread < breadNeeded) {
                    // Check if enough money to resupply bread to breadNeeded, 
                    // add different of current bread count to bread needed to the supply
                    int addedCost = (breadNeeded - bread) * breadPrice;
                    if (addedCost > rubles)
                        break;
                    rubles -= addedCost;
                    bread = breadNeeded;
                }
                if (sausage < sausageNeeded) {
                    int addedCost = (sausageNeeded - sausage) * sausagePrice;
                    if (addedCost > rubles)
                        break;
                    rubles -= addedCost;
                    sausage = sausageNeeded;
                }
                if (cheese < cheeseNeeded) {
                    int addedCost = (cheeseNeeded - cheese) * cheesePrice;
                    if (addedCost > rubles)
                        break;
                    rubles -= addedCost;
                    cheese = cheeseNeeded;
                }

                if (bread == breadNeeded && sausage == sausageNeeded && cheese == cheeseNeeded) {
                    long addedCost = (sausageNeeded) * sausagePrice + breadNeeded * breadPrice + cheeseNeeded * cheesePrice;
                    if (addedCost != 0)
                        hamburgers += rubles / addedCost + 1;
                    break;
                }



                long burgersAdded = Long.MAX_VALUE;
                if (breadNeeded != 0)
                    burgersAdded = Math.min(burgersAdded, bread / breadNeeded);
                if (sausageNeeded != 0)
                    burgersAdded = Math.min(burgersAdded, sausage / sausageNeeded);
                if (cheeseNeeded != 0)
                    burgersAdded = Math.min(burgersAdded, cheese / cheeseNeeded);
                
                if (burgersAdded == Long.MAX_VALUE)
                    break;
                cheese -= burgersAdded * cheeseNeeded;
                sausage -= burgersAdded * sausageNeeded;
                bread -= burgersAdded * breadNeeded;
                hamburgers += burgersAdded;             
            }
            System.out.println(hamburgers);
            end = System.currentTimeMillis();
            // System.out.println(end - start);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
