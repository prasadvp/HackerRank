package codeintvw;

import java.util.Scanner;

public class MergeSort {

    static long countInversions(int[] arr) {
    	    long numberOfInversions = 0;
        // Complete this function
    	    int[] temp = new int[arr.length];
    	    numberOfInversions =  mergeSort(arr,  temp, 0, arr.length-1);
    		return numberOfInversions;
    }
    
    

    private static long mergeSort(int[] arr, int[] temp, int leftStart, int rightEnd ) {
    		long inversionCnt = 0;
		if(leftStart < rightEnd ) {
    		int middleIndex = (leftStart+rightEnd)/2;
    		inversionCnt = inversionCnt + mergeSort(arr,temp,leftStart,middleIndex);
    		inversionCnt = inversionCnt + mergeSort(arr,temp,middleIndex+1,rightEnd);
		inversionCnt = inversionCnt+ mergeHalves(arr,temp,leftStart,rightEnd);
		}
		return inversionCnt;
	}



	private static long mergeHalves(int[] arr, int[] temp, int leftStart, int rightEnd) {
		// TODO Auto-generated method stub
		long inversionCnt = 0;
		int leftEnd = (rightEnd + leftStart)/2;
		int rightStart = leftEnd +1;
		int leftIndex = leftStart;
		int startIndex = leftStart;
		int rightIndex = rightStart;
		
		int size = rightEnd-leftStart + 1;
		
		while(leftIndex <=leftEnd && rightIndex <= rightEnd) {
			if(arr[leftIndex] <= arr[rightIndex]) {
				temp[startIndex] = arr[leftIndex];
				
				leftIndex++;
			}else {
				temp[startIndex] = arr[rightIndex];
				//inversionCnt++;
				inversionCnt += leftEnd -leftIndex + 1;
				rightIndex++;
			}
			startIndex++;
		}
		 // Leftover elements here.
        while(leftIndex <=leftEnd) {
        		temp[startIndex++] = arr[leftIndex++];  
        }
        
        while(rightIndex <= rightEnd) {
        	temp[startIndex++] = arr[rightIndex++]; 
        }
		
		System.arraycopy(temp, leftStart, arr, leftStart, size);
		return inversionCnt;
	}



	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++){
            int n = in.nextInt();
            int[] arr = new int[n];
            for(int arr_i = 0; arr_i < n; arr_i++){
                arr[arr_i] = in.nextInt();
            }
            long result = countInversions(arr);
            System.out.println(result);
        }
        in.close();
    }
}

