package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertUGtoDAC {

	public static void main(String[] args) {
		
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		UndirectedGraphToDirectedAcyclicGraph dac = new UndirectedGraphToDirectedAcyclicGraph(nodeList, 5);
		
		dac.createVertices();
		
		dac.am.connect_weighted_Undirected_Edges(0, 1, 6);
		dac.am.connect_weighted_Undirected_Edges(0, 2, 7);
		dac.am.connect_weighted_Undirected_Edges(1, 2, 8);
		dac.am.connect_weighted_Undirected_Edges(1, 3, 7);
		dac.am.connect_weighted_Undirected_Edges(2, 4, 5);
		dac.am.connect_weighted_Undirected_Edges(3, 2, 9);
		dac.am.connect_weighted_Undirected_Edges(4, 3, 6);
		
		
		
		System.out.println("Undirected Graph : \n");
		for (int i = 0; i < dac.vertices; i++) {
			for (int j = 0; j < dac.vertices; j++) {
				System.out.print(dac.am.adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
		
		
		dac.convertToDirectedAcyclicGraph(dac.am.adjacencyMatrix);
		
		System.out.println("\nDirected Acyclic Graph : \n");
		for (int i = 0; i < dac.vertices; i++) {
			for (int j = 0; j < dac.vertices; j++) {
				System.out.print(dac.am.adjacencyMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}

}
class UndirectedGraphToDirectedAcyclicGraph
{
	List<GraphNode> nodeList;
	int vertices;
	AdjacencyList al;
	AdjacencyMatrix am;
	int adjM[][];
	
	public UndirectedGraphToDirectedAcyclicGraph(List<GraphNode> nodeList, int vertices) {
		am = new AdjacencyMatrix(vertices);
		al = new AdjacencyList(nodeList);
		this.nodeList = nodeList;
		this.vertices = vertices;
	}
	
	public Stack<GraphNode> getTopSortedStack() {
		
		Stack<GraphNode> stack = new Stack<>();
		for (GraphNode graphNode : nodeList) {
			if(!graphNode.isVisited())
				executeTopologicalSort(graphNode, stack);
		}
		return stack;
	}
	
	public void executeTopologicalSort(GraphNode node, Stack<GraphNode> stack) {
		
		List<GraphNode> neighbours = node.getNeighbours();
		if(neighbours!=null)
		{
			for (GraphNode graphNode : neighbours) {
				
				if(!graphNode.isVisited())
				{
					graphNode.setVisited(true);
					executeTopologicalSort(graphNode, stack);
				}
			}
		}
		node.setVisited(true);
		if(!stack.contains(node))
			stack.push(node);
	}
	
	public void convertToDirectedAcyclicGraph(int adjacencyMatrix[][]) {
		
		Stack<GraphNode> sortedStack = getTopSortedStack();
		while (!sortedStack.isEmpty()) {
			
			GraphNode current = sortedStack.pop();
			List<GraphNode> neighbours = am.getNeighbours(current, nodeList, adjacencyMatrix);
			
			if(neighbours!=null)
			{
				for (GraphNode graphNode : neighbours)
					adjacencyMatrix[graphNode.getNodeIndex()][current.getNodeIndex()] = 0;
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
}