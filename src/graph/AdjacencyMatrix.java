package graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyMatrix extends GraphNode{

	int adjacencyMatrix[][];
	int rows;
	int cols;
	
	public AdjacencyMatrix(int vertices) {
		
		rows = vertices; cols = vertices;
		adjacencyMatrix = new int[rows][cols];
		
	}
	
	public void connectUndirectedEdges(int i, int j) {
		
		if(i>=0 && i<rows && j>=0 && j<cols)
		{
			
			adjacencyMatrix[i][j] = 1;
			adjacencyMatrix[j][i] = 1;
		}
		else
			System.out.println("Indices out of bounds");
	}
	
	public void connectDirectedEdges(int i, int j) {
		
		if(i>=0 && i<rows && j>=0 && j<cols)
			adjacencyMatrix[i][j] = 1;
		else
			System.out.println("Indices out of bounds");
	}
	
	public List<GraphNode> getNeighbours(GraphNode node, List<GraphNode> nodeList, int adjacencyMatrix[][]) {
		
		List<GraphNode> neighbours = new ArrayList<GraphNode>();
		int nodeIndex = node.getNodeIndex();
		for (int i = 0; i < cols; i++) {
			if(adjacencyMatrix[nodeIndex][i]!=0)
				neighbours.add(getNode(i, nodeList));
		}
		return neighbours;
	}
	
	public GraphNode getNode(int nodeIndex, List<GraphNode> nodeList) {
		
		for (GraphNode graphNode : nodeList) {
			if(graphNode.getNodeIndex()==nodeIndex)
				return graphNode;
		}
		return null;
	}
	
	public void connect_weighted_Undirected_Edges(int i, int j, int weight) {
		
		if(i>=0 && i<rows && j>=0 && j<cols)
		{	
			adjacencyMatrix[i][j] = weight;
			adjacencyMatrix[j][i] = weight;
		}
		else
			System.out.println("indices out of bounds");
	}
	
	public void connect_weighted_Directed_Edges(int i, int j, int weight) {
		
		if(i>=0 && i<rows && j>=0 && j<cols)
		{
			adjacencyMatrix[i][j] = weight;
		}
		else
			System.out.println("indices out of bounds");
	}
}

