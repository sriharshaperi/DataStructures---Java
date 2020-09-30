package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAdjacencyMatrix {

	public static void main(String[] args) {
	
		AdjacencyMatrixBFS bfs = new AdjacencyMatrixBFS(8);
		
		bfs.createVertices();
		
		bfs.am.connectUndirectedEdges(5, 7);
		bfs.am.connectUndirectedEdges(7, 3);
		bfs.am.connectUndirectedEdges(3, 5);
		bfs.am.connectUndirectedEdges(4, 1);
		bfs.am.connectUndirectedEdges(6, 1);
		bfs.am.connectUndirectedEdges(2, 7);
		bfs.am.connectUndirectedEdges(4, 2);
		bfs.am.connectUndirectedEdges(1, 7);
		
		bfs.executeBFS();
		
	}
}
class AdjacencyMatrixBFS
{
	AdjacencyMatrix am;
	List<GraphNode> nodes;

	int vertices;
	
	
	public AdjacencyMatrixBFS(int vertices) {
		am = new AdjacencyMatrix(vertices);
		this.vertices = vertices;
		nodes = new ArrayList<GraphNode>();
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodes.add(new GraphNode());
			nodes.get(i).setNode((char)(65+i));
			nodes.get(i).setNodeIndex(i);
		}
	}
	
	public void executeBFS() {
		
		System.out.println("BFS traversal of the Adjacency Matrix : \n");
		for (GraphNode node : nodes) {
			
			if(!node.isVisited())
				traversal(node);
		}
	}
	
	public void traversal(GraphNode node) {
	
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(node);
		
		while (!queue.isEmpty()) 
		{
			GraphNode current = queue.poll();
			current.setVisited(true);
			System.out.print(current.getNode());
			
			List<GraphNode> neighbours = getNeighbours(current);
			
			for (GraphNode neighbour : neighbours) {
				
				if(!neighbour.isVisited())
				{
					queue.offer(neighbour);
					neighbour.setVisited(true);
				}
			}
		}
	}
	
	private List<GraphNode> getNeighbours(GraphNode node) {
		
		List<GraphNode> neighbours = new ArrayList<GraphNode>();
		
		for (int i = 0; i < am.cols; i++) {
			
			if(am.adjacencyMatrix[node.getNodeIndex()][i]==1)
				neighbours.add(nodes.get(i));
		}
		
		return neighbours;
	}
}