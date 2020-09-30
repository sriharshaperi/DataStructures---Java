package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SSSPUsingBFS {

	public static void main(String[] args) {
		
			List<GraphNode> nodes = new ArrayList<GraphNode>();
			SSSP_BFS bfs_sssp = new SSSP_BFS(nodes, 8);
			
			bfs_sssp.createVertices();
			
			bfs_sssp.al.connectDirectedEdges(4, 6);
			bfs_sssp.al.connectDirectedEdges(5, 1);
			bfs_sssp.al.connectDirectedEdges(6, 7);
			bfs_sssp.al.connectDirectedEdges(6, 1);
			bfs_sssp.al.connectDirectedEdges(0, 4);
			bfs_sssp.al.connectDirectedEdges(5, 3);
			bfs_sssp.al.connectDirectedEdges(7, 1);
			bfs_sssp.al.connectDirectedEdges(6, 2);
			
			bfs_sssp.getSSSP_Using_BFS();
	}

}
class SSSP_BFS
{
	List<GraphNode> nodes;
	AdjacencyList al;
	int vertices;
	
	public SSSP_BFS(List<GraphNode> nodes, int vertices) {
		al = new AdjacencyList(nodes);
		this.vertices = vertices;
		this.nodes = nodes;
	}
	
	public void getSSSP_Using_BFS() {
		
		System.out.println("Printing shortest path from a particular node : \n");
		for (GraphNode graphNode : nodes) {
			if(!graphNode.isVisited())
				traverse(graphNode);
		}
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			nodes.add(new GraphNode());
			nodes.get(i).setNode((char)(65+i));
			nodes.get(i).setNodeIndex(i);
		}
	}
	
	public void traverse(GraphNode node) {
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		queue.add(node);
		
		while (!queue.isEmpty()) {
			
			GraphNode current = queue.poll();
			current.setVisited(true);
			printPath(current);
			
			List<GraphNode> neighbours = current.getNeighbours();
			
			if(neighbours!=null)
			{
				for (GraphNode graphNode : neighbours) {
					
					if(!graphNode.isVisited())
					{
						graphNode.setVisited(true);
						graphNode.setParent(current);
						queue.offer(graphNode);
					}
				}
			}
		}
	}
	
	public void printPath(GraphNode node) {
		
		System.out.print("Node : "+node.getNode()+", Path : ");
		fetchPath(node);
		System.out.println();
	}
	
	public void fetchPath(GraphNode node) {
		
		if(node.getParent()!=null)
			fetchPath(node.getParent());
		
		System.out.print(node.getNode());
	}
}