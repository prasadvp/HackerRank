package codeintvw;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class Node{
	int id;
	int distance;
	Set<Node> childNodes;
	boolean visited;
	public Node(int id) {
		this.id = id;
		this.distance = -1;
		this.childNodes = new HashSet<>();
		this.visited = false;
	}
	
	public void addChild(Node child) {
		this.childNodes.add(child);
		child.childNodes.add(this);
	}
	
  public static void main(String args[]) {
	  Scanner in = new Scanner(System.in);
	  int numOfQueries = in.nextInt();
	  for(int i=0;i<numOfQueries;i++) {
		  int numOfNodes = in.nextInt();
		  Map<Integer,Node> nodeList = new HashMap<>(numOfNodes);
		  for(int j = 0; j<numOfNodes;j++) {
			  nodeList.put(j+1, new Node(j+1));
		  }
		  int numOfEdges = in.nextInt();
		   while(numOfEdges >0) {
			 int startNode = in.nextInt();
			  int endNode = in.nextInt();
			  nodeList.get(startNode).addChild(nodeList.get(endNode));
			  numOfEdges--;
		  }
		   int rootNode = in.nextInt();
		   calculateDistance(nodeList.get(rootNode));
		   for ( int ind = 1; ind <= numOfNodes; ind++) {
               if (ind != rootNode) {
                   System.out.print(nodeList.get(ind).distance + " ");
               }
           }
           System.out.println();
	  }
	  
	  in.close();
	  
  }

   private static void calculateDistance(Node node) {
	   if(node == null) return;
	   node.distance = 0;
	   node.visited = true;
	   Queue<Node> processList = new ArrayDeque<>();
	   processList.add(node);
	   
	   while(!processList.isEmpty()) {
		   Node currNode = processList.poll(	);
		   for(Node childNode: currNode.childNodes) {
			   if(!childNode.visited) {
				   childNode.distance = currNode.distance + 6;
				   childNode.visited=true;
				   processList.add(childNode);
			   }
		   }
		  
	   }
    } 
}

