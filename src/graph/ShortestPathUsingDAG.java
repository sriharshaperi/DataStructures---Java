package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ShortestPathUsingDAG {

	public static void main(String[] args) {
	
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		ShortestPath sp = new ShortestPath(nodeList, 5);
		
		sp.createVertices();
		
		sp.am.connect_weighted_Undirected_Edges(0, 1, 4);
		sp.am.connect_weighted_Undirected_Edges(0, 2, 8);
		sp.am.connect_weighted_Undirected_Edges(1, 2, 7);
		sp.am.connect_weighted_Undirected_Edges(1, 3, 3);
		sp.am.connect_weighted_Undirected_Edges(3, 2, 5);
		sp.am.connect_weighted_Undirected_Edges(2, 4, 9);
		sp.am.connect_weighted_Undirected_Edges(4, 3, 6);
		
		System.out.println("Directed Acyclic Graph : \n");
		sp.printAdjacencyMatrix();
		System.out.println("\n");
		sp.getShortestPath(nodeList.get(4), nodeList.get(0));
		
	}
}
class ShortestPath
{
	List<GraphNode> nodeList;
	int vertices;
	AdjacencyMatrix am;
	UndirectedGraphToDirectedAcyclicGraph dac;
	
	public ShortestPath(List<GraphNode> nodeList, int vertices) {
		this.vertices = vertices;
		this.nodeList = nodeList;
		am = new AdjacencyMatrix(vertices);
		dac = new UndirectedGraphToDirectedAcyclicGraph(nodeList, vertices);
	}
	
	public void getShortestPath(GraphNode node1, GraphNode node2) {
		
		dac.convertToDirectedAcyclicGraph(am.adjacencyMatrix);
		
		int i = node1.getNodeIndex();
		int j = node2.getNodeIndex();
		int distance = 0;
		String path = "";
		int n = vertices - 1;
		boolean pathFlag = true;
		
		if(am.adjacencyMatrix[i][j]!=0)
		{
			System.out.print("Minimum Distance from "+node1.getNode()+" to "+node2.getNode()+" : "+am.adjacencyMatrix[i][j]+", Shortest Path : ");
			System.out.println(node1.getNode()+""+node2.getNode());
		}
		else
		{
			if(zeroRowCheck(i, j))
				System.out.println("No Paths Found");
			else
			{
				if(i > j)
				{
					while (i > j) {
						
						int minWeight = getMinWeight(i);
						int index = getIndexOfMinWeight(minWeight, i);
						
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
						System.out.print("Minimum Distance from "+node1.getNode()+" to "+node2.getNode()+" : "+distance+", Shortest Path : ");
						System.out.println(node1.getNode()+""+path);
					}
				}
				else if(i < j)
				{
					while (i < j) {
						
						
						int maxWeight = getMinWeight(i);
						int index = getIndexOfMinWeight(maxWeight, i);
						
						if(index<i)
						{
							System.out.println("No Paths Found\n");
							pathFlag = false;
							break;
						}
						distance += maxWeight;
						path += nodeList.get(index).getNode();
						
						i = i + (index-i);
						
						if(index==j)
							break;
					}
					
					if(pathFlag)
					{
						System.out.print("Minimum Distance from "+node1.getNode()+" to "+node2.getNode()+" : "+distance+", Shortest Path : ");
						System.out.println(node1.getNode()+""+path);
					}
				}
				else
					System.out.println("No Paths Found\n");
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
	
	public int getIndexOfMinWeight(int minWeight, int row) {
		
		for (int i = 0; i < vertices; i++) {
			if(am.adjacencyMatrix[row][i]==minWeight)
				return i;
		}
		return -1;
	}
	
	public boolean zeroRowCheck(int i, int j) {
		
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
		
		dac.convertToDirectedAcyclicGraph(am.adjacencyMatrix);
		
		for (int i = 0; i < vertices; i++) {
			
			for (int j = 0; j < vertices; j++) {
				System.out.print(am.adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}