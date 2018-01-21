package codeintvw;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class HeapMedian {

	
	public static void main(String[] args) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return -1*o1.compareTo(o2);
			}
			
		});
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
		Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
        	addElements(in.nextInt(),minHeap,maxHeap);
        	rebalance(minHeap,maxHeap);
        	System.out.println(getMedian(minHeap,maxHeap));
        	in.close();
        }
	}

	private static double getMedian(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size()? minHeap:maxHeap;
		PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size()?maxHeap:minHeap;
		
		if(biggerHeap.size() - smallerHeap.size() == 0) {
			return((biggerHeap.peek().doubleValue() + smallerHeap.peek())/2);
			
		}else{
			return biggerHeap.peek();
		}
		
	}

	private static void rebalance(PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		PriorityQueue<Integer> biggerHeap = minHeap.size() > maxHeap.size()? minHeap:maxHeap;
		PriorityQueue<Integer> smallerHeap = minHeap.size() > maxHeap.size()?maxHeap:minHeap;
		
		while(biggerHeap.size() - smallerHeap.size() >=2) {
			smallerHeap.add(biggerHeap.poll());
		}
		
	}

	private static void addElements(int nextInt, PriorityQueue<Integer> minHeap, PriorityQueue<Integer> maxHeap) {
		if(minHeap.isEmpty() || nextInt < minHeap.peek()) {
			minHeap.add(nextInt);
		}else {
			maxHeap.add(nextInt);
		}
		
	}

}
