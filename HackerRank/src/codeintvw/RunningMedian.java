package codeintvw;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
/*
 * Put it into the next list as input. 
 * sortAndAdd
 * list = 0 push it 
 * if list = 1 = print the number 
 * if list=2, list[0] and list[1] /2
 * if list.size%2 ==0, Middle number is list.size/2 and (list.size)/2+1 
 * if list.size%2==1, Middle number is list.size/2 
 */

public class RunningMedian {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        //int[] a = new int[n];
        ArrayList<Integer> sortedList = new ArrayList<>();
        for(int a_i=0; a_i < n; a_i++){
            //a[a_i] = in.nextInt();
            sortedList.add(Integer.valueOf(in.nextInt()));
            Collections.sort(sortedList);
            System.out.println(  displayMedian(sortedList));
        }
        in.close();
    }

	private static Double displayMedian(ArrayList<Integer> sortedList) {
		Double d = 0.0;
		int midIndex = sortedList.size()/2;
		if(sortedList.size() == 1) {
			d=  sortedList.get(0).doubleValue();
		} else if(sortedList.size()%2==0) {
			d = (sortedList.get(midIndex).doubleValue() + sortedList.get(midIndex-1).doubleValue())/2;
		}else {
			d = sortedList.get(midIndex).doubleValue();
		}
		return d;
	}
}
