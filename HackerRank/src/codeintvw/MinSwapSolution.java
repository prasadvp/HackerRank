package com.vp;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class MinSwapSolution {

    // Complete the minimumSwaps function below.
    /*static int minimumSwaps(int[] arr) {
    	int numOfSwaps = 0;
    	int difference = 0; 
    	int index1 =0, index2=0;
    	boolean swapped = false;
    	do{
    		swapped = false;
    		difference = 0;
    		index1=0;index2=0;
    		for(int i=0;i<arr.length;i++){
        		for(int j=i+1;j<arr.length;j++){
        			//System.out.println("Checking now arr[i] "+arr[i] +" arr[j] "+ arr[j]);
        			if(arr[i] - arr[j] >0 && arr[i]-arr[j] > difference){
        				difference = arr[i]-arr[j];
        				index1= i;
        				index2 = j;
        				swapped = true;
        			}
        		}
        		if(swapped){
        			
        			int tmp = arr[index1];
        			arr[index1] = arr[index2];
        			arr[index2] = tmp;
        			numOfSwaps++;
        			break;
        		}
        	}
    		//System.out.println("Array "+ arr.toString());
    	}while(swapped);
    	
    	
    	
    	return numOfSwaps;

    }*/
    
    static int minimumSwaps(int[] arr) {
        int first = 0, last = arr.length - 1;
        int swaps = 0;
        while (first < last) {
            while (arr[first] == first + 1 && first < last)
                first++;
            if (first < last) {
                int temp = arr[arr[first] - 1];
                arr[arr[first] - 1] = arr[first];
                arr[first] = temp;
                swaps++;
            }
        }
        return swaps;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       // BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

     /*   int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
int[] arr = new int[n];
        

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }*/
    	
       int[] arr = new int[]{7,1,3,2,4,5,6};

       //System.out.println(arr[0] +" "+ arr[1]+ " "+ arr[2]+" "+ arr[3]);
        int res = minimumSwaps(arr);
        System.out.println(res);

     /*   bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedWriter.close();*/

        scanner.close();
    }
}

