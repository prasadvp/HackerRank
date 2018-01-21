package codeintvw;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DFS {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int cols = in.nextInt();
        int grid[][] = new int[rows][cols];
        for(int grid_i=0; grid_i < rows; grid_i++){
            for(int grid_j=0; grid_j < cols; grid_j++){
                grid[grid_i][grid_j] = in.nextInt();
            }
        }
        /*
        1. Start with 0,0. 
        2. Check the visited map / set . 
        3. if not present in visited map, add it 
        4. Check the value -  if it is 1 Add to the count - Get the adjacent rows 
        5. Move on till you see 0
        if it is 0 - increase to next column or row and repeat from step 2
        Get the max  of count from previous and current iteration - store the maximum and discard the other 
        */
        Set<String> visited = new HashSet<String>();
        int count = 0;
        for(int grid_i=0; grid_i < rows; grid_i++){
            for(int grid_j=0; grid_j < cols; grid_j++){
            	count = 	Math.max(count, computeBiggestRegion(grid, grid_i, grid_j,visited));
            }
            
        }
        System.out.println(count);
        in.close();
    }
    
    public static int computeBiggestRegion(int[][]grid, int currRow, int currCol, Set<String>visited) {
    	int currCount = 0;
    	if(currRow >= grid.length || currCol>= grid[0].length
    			|| currRow <0 || currCol < 0) {
    		return currCount;
    	}
    	
    	String currNode = String.valueOf(currRow)+String.valueOf(currCol);
    	if(!visited.contains(currNode)) {
    		visited.add(currNode);
    		currCount = grid[currRow][currCol];
    		if(currCount == 0) return currCount;
    		
    		currCount += computeBiggestRegion(grid, currRow, currCol+1,visited);
    		currCount += computeBiggestRegion(grid, currRow, currCol-1,visited);
    		currCount += computeBiggestRegion(grid, currRow+1, currCol,visited);
    		currCount += computeBiggestRegion(grid, currRow-1, currCol,visited);
    		currCount += computeBiggestRegion(grid, currRow-1, currCol+1,visited);
    		currCount += computeBiggestRegion(grid, currRow-1, currCol-1,visited);
    		currCount += computeBiggestRegion(grid, currRow+1, currCol-1,visited);
    		currCount += computeBiggestRegion(grid, currRow+1, currCol+1,visited);
    	}
    	return currCount;
    }

	

}

