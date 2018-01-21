package codeintvw;

import java.util.Scanner;

public class PrimeTest {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        for(int a0 = 0; a0 < p; a0++){
            int n = in.nextInt();
            //checkPrime(n)?System.out.println("Prime"):System.out.println("Not prime"));
            boolean flag = checkPrime(n);
            if(flag)
            		System.out.println("Prime");
            else
            		System.out.println("Not prime");
            
        }
        in.close();
    }

	private static boolean checkPrime(int n) {
		// TODO Auto-generated method stub
		if(n<2) {
			return false;
		}
		if(n<4) {
			return true;
		}
		if(n%2 == 0)
			return false;
		int nearestNo = (int) Math.sqrt(n) + 1;
		for(int i=3;i<nearestNo;i++) {
			if(n%i == 0) {
				return false;
			}
		}
		return true;
		
	}
}