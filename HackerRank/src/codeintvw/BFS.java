package codeintvw;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


public class BFS {
	Map<Integer,List<Integer>> nodeList = null;
	int numOfEdges = 0;
	int startingNode = 0;
	int numOfNodes = 0;
	//List<Node> nodeDetails;
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			int numOfQueries = in.nextInt();
			List<BFS> nodeQueries= new ArrayList<>(numOfQueries);
			//List<Node> graphList = new ArrayList<>(numOfQueries);
			for(int i=0;i<numOfQueries;i++) {
				BFS obj = new BFS();
				int numOfNodes = in.nextInt();
				int numOfEdges = in.nextInt();
				Map<Integer,List<Integer>> currNodeList = obj.getNodeList()!=null? 
												obj.getNodeList(): new HashMap<>();
				for(int j=0;j<numOfEdges;j++) {
					int startNode = in.nextInt();
					int endNode = in.nextInt();
					List<Integer> endNodeList = currNodeList.get(Integer.valueOf(startNode))!=null?
													currNodeList.get(Integer.valueOf(startNode))
													:new ArrayList<Integer>();
					endNodeList.add(Integer.valueOf(endNode));
					currNodeList.put(Integer.valueOf(startNode), endNodeList);
					
					 endNodeList = currNodeList.get(Integer.valueOf(endNode))!=null?
							currNodeList.get(Integer.valueOf(endNode))
							:new ArrayList<Integer>();
					endNodeList.add(Integer.valueOf(startNode));
					currNodeList.put(Integer.valueOf(endNode), endNodeList);
				}
				obj.setNodeList(currNodeList);
				obj.setStartingNode(in.nextInt());
			
				obj.setNumOfNodes(numOfNodes);
				nodeQueries.add(obj);
			}
			
			displayNodeReach(nodeQueries);
			
		}catch(Exception ex) {
			System.out.println("Exception \n "+ex);
			
		}finally {
			in.close();
			
		}
		
		
		
	}

	private static void displayNodeReach(List<BFS> nodeQueries) {
		 for(BFS currGraph:nodeQueries) {
			List<Integer> currEgdeList = currGraph.getNodeList().get(currGraph.getStartingNode());
			for(int i=1;i<=currGraph.getNumOfNodes();i++) {
				if(i==currGraph.getStartingNode())
					continue;
				if(currEgdeList.contains(i)) {
					System.out.print(6+" ");
				}else {
					System.out.print(-1+" ");
				}
			}System.out.println();
		}
	}



	public int getNumOfEdges() {
		return numOfEdges;
	}

	public void setNumOfEdges(int numOfEdges) {
		this.numOfEdges = numOfEdges;
	}

	public int getStartingNode() {
		return startingNode;
	}

	public void setStartingNode(int startingNode) {
		this.startingNode = startingNode;
	}

	public int getNumOfNodes() {
		return numOfNodes;
	}

	public void setNumOfNodes(int numOfNodes) {
		this.numOfNodes = numOfNodes;
	}

	public Map<Integer, List<Integer>> getNodeList() {
		return nodeList;
	}

	public void setNodeList(Map<Integer, List<Integer>> nodeList) {
		this.nodeList = nodeList;
	}


}
