package codeintvw;

import java.util.Scanner;

public class LonelyInteger {

    public static void main(String[] args) {
    		//Map<Integer,Integer> numOfOccurences = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
       
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
          //  checkAndSet(numOfOccurences,a[a_i]); 
            
        }
        //System.out.println(numOfOccurences.keySet().iterator().next());
       
       //ELEGANT WAY OF DOING IT  
       System.out.println(lonelyInteger(a));
       in.close();
    }

	/*private static void checkAndSet(Map<Integer, Integer> numOfOccurences, int i) {
		
		//return  numOfOccurences.get(i) == null? numOfOccurences.put(i,1):numOfOccurences.remove(i);
		if(numOfOccurences.get(i) == null) {
			numOfOccurences.put(i,1);
		}else {
			numOfOccurences.remove(i);
		}
		//return 1;
	}*/
	
	public static int lonelyInteger(int[] a) {
	    int value = 0;

	    for (int i : a) {
	        value ^= i;
	    }
	    return value;
	}
}

/*For n= 4  and C = {1,2,3}  there are four solutions:
 * public static long makeChange(int[] coins, int money) {
        long[] DP = new long[money + 1]; // O(N) space.
        DP[0] = (long) 1; 	// n == 0 case.
        for(int coin : coins) {
            for(int j = coin; j < DP.length; j++) {
            // The only tricky step.
                DP[j] += DP[j - coin];
            }
        }       
        return DP[money];
    }
 DP.length = 5 
 dp[1] = dp[1] + dp[
 */

