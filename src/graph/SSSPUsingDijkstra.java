package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class SSSPUsingDijkstra {

	public static void main(String[] args) {
		
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		Dijkstra d = new Dijkstra(nodes, 5);
		
		d.createVertices();
		
		d.al.connect_Weighted_Directed_Edges(0, 1, 235);
		d.al.connect_Weighted_Directed_Edges(0, 2, 481);
		d.al.connect_Weighted_Directed_Edges(1, 3, 912);
		d.al.connect_Weighted_Directed_Edges(1, 2, 533);
		d.al.connect_Weighted_Directed_Edges(3, 2, 874);
		d.al.connect_Weighted_Directed_Edges(2, 4, 647);
		d.al.connect_Weighted_Directed_Edges(4, 3, 257);
		
		d.getSSSP_Using_Dijkstra(nodes.get(3));
		
	}
}
class Dijkstra
{
	List<GraphNode> nodes;
	AdjacencyList al;
	int vertices;

	public Dijkstra(List<GraphNode> nodes, int vertices) {
		al = new AdjacencyList(nodes);
		this.nodes = nodes;
		this.vertices = vertices;
	}
	
	public void getSSSP_Using_Dijkstra(GraphNode node) {
		
		Queue<GraphNode> queue = new PriorityQueue<GraphNode>();
		node.setDistance(0);
		queue.addAll(nodes);
			
		while (!queue.isEmpty()) 
		{
			GraphNode current = queue.poll();
			if(current.getNeighbours()!=null)
			{
				for (GraphNode graphNode : current.getNeighbours()) {
					
					if(queue.contains(graphNode))
					{
						if(graphNode.getDistance() > current.getDistance() + current.getWeightedMap().get(graphNode))
						{
							graphNode.setDistance(current.getDistance() + current.getWeightedMap().get(graphNode));
							graphNode.setParent(current);
							queue.remove(graphNode);
							queue.add(graphNode);
						}
					}
				}
			}
		}
		
		for (GraphNode graphNode : nodes)
		{
			printpath(graphNode);
			System.out.println();
		}
	}
	
	public void fetchPath(GraphNode node) {
		
		if(node.getParent()!=null)
			fetchPath(node.getParent());
		
		System.out.print(node.getNode());
	}
	
	public void printpath(GraphNode node) {
		
			System.out.print("Node : "+node.getNode()+", Distance : "+node.getDistance()+", Path : ");
			fetchPath(node);
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodes.add(new GraphNode());
			nodes.get(i).setNode((char)(65+i));
			nodes.get(i).setNodeIndex(i);
		}
	}
}