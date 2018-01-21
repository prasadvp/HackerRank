package codeintvw;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IceCream {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int m = in.nextInt();
            int n = in.nextInt();
            int a[] = new int[n];
            for(int a_i=0; a_i < n; a_i++){
                a[a_i] = in.nextInt();
            }
            int[] flavorIds = displayFlavourIds(a,m);
            System.out.println(flavorIds!=null && flavorIds.length == 2? flavorIds[0] + " "+ flavorIds[1]:"0 0");
            in.close();
        }
    }

	private static int[] displayFlavourIds(int[] a,int money) {
		// TODO Auto-generated method stub
		
		if(a.length >=2) {
			Map<Integer, Integer> results = new HashMap<>();
			for(int index=0;index<a.length;index++) {
				if(results.get(a[index])!=null) {
					int[] output = new int[2];
					output[0] = results.get(a[index]);
					output[1] = index+1;
					return output;
				}else {
					results.put(money-a[index], index+1);
				}
			}
		}
		return null;
	}
}

