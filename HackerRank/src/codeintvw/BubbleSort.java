package codeintvw;

import java.util.Scanner;

public class BubbleSort {

	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		int numOfElements = in.nextInt();
		int[] array = new int[numOfElements];
		for(int i=0;i<numOfElements;i++) {
			array[i] = in.nextInt();
		}
		in.close();
		sortArray(array);
	}

	private static void sortArray(int[] array) {
		// TODO Auto-generated method stub
		int numOfSwaps = 0;
		for(int i=0;i<array.length;i++) {
			boolean isSwapped = false;
			for(int j=0;j<array.length-1;j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					numOfSwaps++;
					isSwapped = true;
				}
			}
			if(!isSwapped)
				break;
		}	
		System.out.println("Array is sorted in " + numOfSwaps +" swaps");
		System.out.println("First Element: "+array[0]);
		System.out.println("Last Element: "+array[array.length-1]);
	}
}
