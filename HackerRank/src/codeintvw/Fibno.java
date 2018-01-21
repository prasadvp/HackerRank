package codeintvw;

import java.util.*;

public class Fibno {

	private static long [] fibArray;
    public static long fibonacciIterative(long n) {

        // Complete the function. iterative 
    	
    		if(n<=1) return n;
    		int fib = 1;
    		int prevFib = 1;
    		for(int i=2;i<n;i++) {
    			int temp = fib;
    			fib+=prevFib;
    			prevFib=temp;
    		}
    		return fib;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();
        long startTime = System.currentTimeMillis();
        System.out.println(fibonacciIterative(n));
        long stopTime = System.currentTimeMillis();
        System.out.println("Iterative "+ (stopTime - startTime));
        //Initialize 
        fibArray = new long[(int) n+1];
        startTime = System.currentTimeMillis();
        System.out.println(fibMemoization(n));
        stopTime = System.currentTimeMillis();
        System.out.println("Memoization "+ (stopTime - startTime));
        
    }

	private static long fibMemoization(long n) {
		if(n<=1) 
			return n;
		if(fibArray[(int)n]!=0)
			return fibArray[(int)n];
		long fibValue = fibMemoization(n-1)+fibMemoization(n-2);
		fibArray[(int)n] = fibValue;
		return fibValue;
	}
}