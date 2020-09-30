package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFSAdjacencyList {

	public static void main(String[] args) {
		
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		AdjacencyListBFS bfs = new AdjacencyListBFS(nodes, 8);
		
		bfs.createVertices();
		
		bfs.al.connectDirectedEdges(4, 5);
		bfs.al.connectDirectedEdges(3, 7);
		bfs.al.connectDirectedEdges(6, 5);
		bfs.al.connectDirectedEdges(4, 1);
		bfs.al.connectDirectedEdges(5, 3);
		bfs.al.connectDirectedEdges(7, 2);
		bfs.al.connectDirectedEdges(0, 6);
		bfs.al.connectDirectedEdges(0, 5);
		
		bfs.executeBFS();
	}

}
class AdjacencyListBFS
{
	AdjacencyList al;
	List<GraphNode> nodes;
	int vertices;
	
	public AdjacencyListBFS(List<GraphNode> nodes, int vertices) {
		al = new AdjacencyList(nodes);
		this.nodes = nodes;
		this.vertices = vertices;
	}
	
	public void executeBFS() {
	
		System.out.println("BFS using adjacency list : \n");
		for (GraphNode graphNode : nodes) {
			
			if(!graphNode.isVisited())
				traverse(graphNode);
		}
	}
	
	public void traverse(GraphNode node) {
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			
			GraphNode current = queue.poll();
			current.setVisited(true);
			System.out.print(current.getNode());
			
			List<GraphNode> neighbours = current.getNeighbours();
			
			if(neighbours!=null)
			{
				for (GraphNode graphNode : neighbours) {
					
					if(!graphNode.isVisited())
					{
						queue.offer(graphNode);
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
