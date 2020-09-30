package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSAdjacencyList {

	public static void main(String[] args) {
		
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		AdjacencyListDFS dfs = new AdjacencyListDFS(nodes, 8);
		
		dfs.createVertices();
		
		dfs.al.connectDirectedEdges(5, 7);
		dfs.al.connectDirectedEdges(4, 1);
		dfs.al.connectDirectedEdges(1, 7);
		dfs.al.connectDirectedEdges(5, 1);
		dfs.al.connectDirectedEdges(7, 6);
		dfs.al.connectDirectedEdges(5, 3);
		dfs.al.connectDirectedEdges(0, 3);
		dfs.al.connectDirectedEdges(5, 4);
		
		dfs.executeDFS();
	}
}
class AdjacencyListDFS
{
	AdjacencyList al;
	List<GraphNode> nodes;
	int vertices;
	
	public AdjacencyListDFS(List<GraphNode> nodes, int vertices) {
		
		al = new AdjacencyList(nodes);
		this.vertices = vertices;
		this.nodes = nodes;
	}
	
	public void executeDFS() {
		
		System.out.println("DFS using adjacency list : \n");
		for (GraphNode graphNode : nodes) {
			
			if(!graphNode.isVisited())
				traverse(graphNode);
		}
	}
	
	public void traverse(GraphNode node) {
		
		Stack<GraphNode> stack = new Stack<>();
		stack.push(node);
		
		while (!stack.isEmpty()) {
			
			GraphNode current = stack.pop();
			current.setVisited(true);
			System.out.print(current.getNode());
			
			List<GraphNode> neighbours = current.getNeighbours();
			if(neighbours!=null)
			{
				for (GraphNode graphNode : neighbours) {
					if(!graphNode.isVisited())
					{
						stack.push(graphNode);
						graphNode.setVisited(true);
					}
				}
			}
		}
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodes.add(new GraphNode());
			nodes.get(i).setNode((char)(65+i));
			nodes.get(i).setNodeIndex(i);
		}
	}
}