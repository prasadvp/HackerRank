package com.vp;

import java.util.Scanner;

public class NewYearChaosSolution {

    // Complete the minimumBribes function below.
   /* static void minimumBribes(int[] q) {
    	long numOfBribes = 0;
    	int index=0;
    	boolean isChaotic = false;
    	int ctr = 0;
    	//System.out.println("Length of array "+ q.length);
    	while(ctr < q.length){
    		//System.out.println("ctr "+ ctr +" q[ctr] "+ q[ctr] +" index "+ index + " q[index] "+ q[index]);
    		if(Math.abs(ctr - q[ctr])-1 > 2){
    			isChaotic = true;    			
    			break;
    		}else if (ctr+1-q[ctr] < 0 ){
    			numOfBribes+=Math.abs(ctr+1 - q[ctr]); 
    		}else if (ctr+1-q[ctr] > 2 ){
    			numOfBribes++;
    		}
    		ctr++;
    	}
    	if(isChaotic){
    		System.out.println("Too chaotic");
    	}else{
    		System.out.println(numOfBribes);
    	}
  
    }*/
	static void minimumBribes(int[] q) {
    	long numOfBribes = 0;
    	boolean isChaotic = false;
    	for(int index= q.length-1;index>=0;index--){
    		if(q[index]- (index+1) > 2){
    			isChaotic = true;
    			break;
    		}
    		for(int ctr = Math.max(0, q[index]-2); ctr<index;ctr++){
    			if(q[ctr] > q[index]){
    				numOfBribes++;
    			}
    		}
    	}
    	if(isChaotic){
    		System.out.println("Too chaotic");
    	}else{
    		System.out.println(numOfBribes);
    	}
  
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] q = new int[n];

            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int i = 0; i < n; i++) {
                int qItem = Integer.parseInt(qItems[i]);
                q[i] = qItem;
            }

            minimumBribes(q);
        }

        scanner.close();
    }
}

