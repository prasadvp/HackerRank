package codeintvw;

import java.util.HashMap;
import java.util.Scanner;

public class CoinChallenge {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount = in.nextInt();
        int numOfCoins = in.nextInt();
        int coins[] = new int[numOfCoins];
        for(int coins_i=0; coins_i < numOfCoins; coins_i++){
            coins[coins_i] = in.nextInt();
        }
       // System.out.println(numOfWays(coins,amount));
        System.out.println(makeChange(coins,amount));
        in.close();
    }
    /*Each coin mod %2 == 0  - First way
     * Sort the coin array in desc order  - Take the first maximum number and subtract. 
     * Now the remaining - how to do it with other coins
     * 
     * 
     */

	private static long numOfWays(int[] coins, int amount) {
		// TODO Auto-generated method stub
		return makeChange(coins,amount,0, new HashMap<String,Long>());
	}

	private static long makeChange(int[] coins, int money, int index, HashMap<String,Long> memo) {
		if(money==0) {
			return 1;
		}
		if(index >=coins.length) {
			return 0;
		}
		String key = money +"-"+index;
		if(memo.containsKey(key)) {
			return memo.get(key);
		}
		int amountWithCoin = 0;
		long ways = 0;
		while(amountWithCoin <= money) {
			int remaining = money - amountWithCoin;
			ways += makeChange(coins,remaining,index+1,memo);
			amountWithCoin+=coins[index];
		}
		memo.put(key, ways);
		return ways;
	}
	
	public static long makeChange(int[] coins, int money) {
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
}

