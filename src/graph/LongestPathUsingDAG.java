package graph;

import java.util.ArrayList;
import java.util.List;

public class LongestPathUsingDAG {

	public static void main(String[] args) {
		
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		LPUsingDAG lp = new LPUsingDAG(nodeList, 5);
		
		lp.createVertices();
		
		lp.am.connect_weighted_Undirected_Edges(0, 1, 4);
		lp.am.connect_weighted_Undirected_Edges(0, 2, 8);
		lp.am.connect_weighted_Undirected_Edges(1, 2, 7);
		lp.am.connect_weighted_Undirected_Edges(1, 3, 3);
		lp.am.connect_weighted_Undirected_Edges(3, 2, 5);
		lp.am.connect_weighted_Undirected_Edges(2, 4, 9);
		lp.am.connect_weighted_Undirected_Edges(4, 3, 6);
		
		System.out.println("Directed Acyclic Graph : \n");
		lp.printAdjacencyMatrix();
		System.out.println("\n");
		lp.getLongestPath(nodeList.get(4), nodeList.get(1));
	}

}
class LPUsingDAG
{
	
	List<GraphNode> nodeList;
	int vertices;
	AdjacencyMatrix am;
	UndirectedGraphToDirectedAcyclicGraph dag;
	
	public LPUsingDAG(List<GraphNode> nodeList, int vertices) {
		this.nodeList = nodeList;
		this.vertices = vertices;
		am = new AdjacencyMatrix(vertices);
		dag = new UndirectedGraphToDirectedAcyclicGraph(nodeList, vertices);
	}
	
	public void getLongestPath(GraphNode node1, GraphNode node2) {
		
		dag.convertToDirectedAcyclicGraph(am.adjacencyMatrix);
		
		int i = node1.getNodeIndex();
		int j = node2.getNodeIndex();
		int distance = 0;
		String path = "";
		boolean pathFlag = true;
		
		if(am.adjacencyMatrix[i][j]!=0)
		{
			System.out.print("Maximum Distance from "+node1.getNode()+" to "+node2.getNode()+" : "+am.adjacencyMatrix[i][j]*(-1)+", Longest Path : ");
			System.out.println(node1.getNode()+""+node2.getNode());
		}
		else
		{
			if(zeroRowCheck(i))
				System.out.println("No Paths Found");
			else
			{
				if(i > j)
				{
					while (i>j) {
						
						int minWeight = getMinWeight(i);
						int index = getIndexOfWeight(minWeight, i);
						
						if(index > i)
						{
							System.out.println("No Paths Found\n");
							pathFlag = false;
							break;
						}
						
						distance += minWeight;
						path += nodeList.get(index).getNode();
						i = i - (i - index);
						
						if(index==j)
							break;
					}
					if(pathFlag)
					{
						System.out.print("Maximum Distance from "+node1.getNode()+" to "+node2.getNode()+" : "+distance*(-1)+", Longest Path : ");
						System.out.println(node1.getNode()+""+path);
					}
				}
				else if(i < j)
				{
					while (i < j) {
						
						
						int minWeight = getMinWeight(i);
						int index = getIndexOfWeight(minWeight, i);
						
						if(index < i)
						{
							System.out.println("No Paths Found");
							pathFlag = false;
							break;
						}
						
						distance += minWeight;
						path += nodeList.get(index).getNode();
						i = i + (index - i);
						
						if(index==j)
							break;
					}
					if(pathFlag)
					{
						System.out.print("Maximum Distance from "+node1.getNode()+" to "+node2.getNode()+" : "+distance*(-1)+", Longest Path : ");
						System.out.println(node1.getNode()+""+path);
					}
				}
			}
		}
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodeList.add(new GraphNode());
			nodeList.get(i).setNode((char)(65+i));
			nodeList.get(i).setNodeIndex(i);
		}
	}
	
	public void printPath(GraphNode node) {
		
		if(node.getParent()!=null)
		{
			printPath(node.getParent());
			System.out.print(node.getNode());
		}
		else
			System.out.print(node.getNode());
	}
	
	public int getMaxWeight(int row) {
		
		int maxWeight = 0;
		for (int i = 0; i < vertices; i++) {
			if(am.adjacencyMatrix[row][i]!=0)
			{
				maxWeight = am.adjacencyMatrix[row][i];
				break;
			}
		}
		
		for (int i = 0; i < vertices; i++) {
			if(am.adjacencyMatrix[row][i]!=0)
				maxWeight = Math.max(maxWeight, am.adjacencyMatrix[row][i]);
		}
		
		return maxWeight;
	}
	
	public int getIndexOfWeight(int minWeight, int row) {
		
		for (int i = 0; i < vertices; i++) {
			if(am.adjacencyMatrix[row][i]==minWeight)
				return i;
		}
		return -1;
	}
	
	public boolean zeroRowCheck(int i) {
		
		int count = 0;
		for (int k = 0; k < vertices; k++) {
			if(am.adjacencyMatrix[i][k]!=0)
				count++;
		}
		
		if(count==0)
			return true;
		
		return false;
	}
	
	public void printAdjacencyMatrix() {
		
		dag.convertToDirectedAcyclicGraph(am.adjacencyMatrix);
		
		for (int i = 0; i < vertices; i++) {
			
			for (int j = 0; j < vertices; j++) {
				System.out.print(am.adjacencyMatrix[i][j]*(-1)+" ");
			}
			System.out.println();
		}
	}
	
	public int getMinWeight(int row) {
		
		int minWeight = 0;
		for (int i = 0; i < vertices; i++) {
			if(am.adjacencyMatrix[row][i]!=0)
			{
				minWeight = am.adjacencyMatrix[row][i];
				break;
			}
		}
		
		for (int i = 0; i < vertices; i++) {
			if(am.adjacencyMatrix[row][i]!=0)
				minWeight = Math.min(minWeight, am.adjacencyMatrix[row][i]);
		}
		
		return minWeight;
	}
}