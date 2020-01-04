package com.vp;
import java.util.Scanner;
import java.util.stream.IntStream;
/*
 * This class find the maximum number of houses that can be built in 2D grid
 * for the given dimension and
 * with the indices in between (horizontal / vertical) cannot be used.
 * Detailed problem statement at the bottom 
 */
public class PromisedLand {

	/*
	 * Approach: In a Grid with indices in between as non usable, visualize it as rectangle 
	 * and identify # of num of houses with given dimension can be built. The process for identification is
	 * find the # of house with given length can be fit in Rectangle length
	 * FInd the # of house with given width can be fit in Rectangle width
	 * Multiply the above two. Detailed solution at bottom
	 * TIME COMPLEXITY O(M+N)O(M+N)
	 */
	private static final Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int numOfTestCases = scanner.nextInt();
		int[] result = new int[numOfTestCases];
		for(int i=0;i<numOfTestCases;i++){
			int verticalUnits = scanner.nextInt();
			int horizontalUnits = scanner.nextInt();
			int horizontalRivers = scanner.nextInt();
			int verticalRivers = scanner.nextInt();
			int dimension = scanner.nextInt();
			int sumXaxis = 0, sumYaxis =0, prevVal = 0, riverAxis; 
			for (int k= 0; k<horizontalRivers;k++){
				riverAxis = scanner.nextInt();
				sumXaxis += (riverAxis-prevVal-1)/dimension;
				prevVal = riverAxis;
			}
			sumXaxis += (verticalUnits-prevVal)/dimension;
			prevVal = 0; riverAxis = 0;
			for ( int k= 0; k<verticalRivers;k++){
				riverAxis = scanner.nextInt();
				sumYaxis += (riverAxis-prevVal-1)/dimension;
				prevVal = riverAxis;
			}
			sumYaxis += (horizontalUnits - prevVal)/dimension;
			result[i] = sumXaxis * sumYaxis;
		}
		IntStream.of(result).forEach(val->System.out.println(val));
		 scanner.close();
	}

}

/*
 * PROBLEM STATEMENT: 
 * 
 * 
 * The land can be thought of as a 2d grid which extends N units vertically and M units horizontally. It is divided into N horizontal rows, 
 * which are numbered from 1 to N, as you move from top to bottom and into M vertical columns numbered from 1 to M, from left to right.

There are X rivers flowing in a horizontal direction, each flowing in a different row and covering the entire row. Similarly, there are Y rivers 
flowing in a vertical direction, each flowing in a different column and covering the entire column.

The people want to build houses of dimensions S×S on the remaining land.

What is the maximum number of houses of the given dimensions that could be built on the remaining land, such that no part of any house is in a river
 and no two houses overlap
*/


/*SOLUTION APPROACH
 * 
 * https://discuss.codechef.com/t/ishvala-editorial/43131
 number of houses possible is (a/S)*(b/S)(a/S)X(b/S). We just sum it over all rectangles in the grid.
 */
