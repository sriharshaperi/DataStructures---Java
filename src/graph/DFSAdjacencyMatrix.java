package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class DFSAdjacencyMatrix {

	public static void main(String[] args) {
		
		AdjacencyMatrixDFS dfs = new AdjacencyMatrixDFS(5);
		
		dfs.createVertices();
		
		dfs.am.connectUndirectedEdges(0, 1);
		dfs.am.connectUndirectedEdges(0, 3);
		dfs.am.connectUndirectedEdges(1, 2);
		dfs.am.connectUndirectedEdges(1, 3);
		dfs.am.connectUndirectedEdges(2, 3);
		dfs.am.connectUndirectedEdges(3, 4);
		dfs.am.connectUndirectedEdges(4, 2);
		
		dfs.executeDFS();
	}

}
class AdjacencyMatrixDFS
{
	AdjacencyMatrix am;
	List<GraphNode> nodes;
	int vertices;
	
	public AdjacencyMatrixDFS(int vertices) {
		am = new AdjacencyMatrix(vertices);
		nodes = new ArrayList<GraphNode>();
		this.vertices = vertices;
	}
	
	public List<GraphNode> getNeighbours(GraphNode node) {
		
		List<GraphNode> neighbours = new ArrayList<GraphNode>();
		
		for (int i = 0; i < vertices; i++) {
			
			if(am.adjacencyMatrix[node.getNodeIndex()][i]==1)
				neighbours.add(nodes.get(i));
		}
		return neighbours;
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodes.add(new GraphNode());
			nodes.get(i).setNode((char)(65+i));
			nodes.get(i).setNodeIndex(i);
		}
	}
	
	public void executeDFS() {
		
		System.out.println("DFS travesal using Adjacency Matrix : \n");
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
			
			List<GraphNode> neighbours = getNeighbours(current);
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