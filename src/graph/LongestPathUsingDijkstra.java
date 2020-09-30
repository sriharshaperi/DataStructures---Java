package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class LongestPathUsingDijkstra {

	public static void main(String[] args) {
		
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		LPDijkstra lp = new LPDijkstra(nodeList, 5);
		
		lp.createVertices();
		
		lp.al.connect_Weighted_Undirected_Edges(0, 1, 5);
		lp.al.connect_Weighted_Undirected_Edges(0, 2, 4);
		lp.al.connect_Weighted_Undirected_Edges(1, 3, 6);
		lp.al.connect_Weighted_Undirected_Edges(2, 4, 9);
		lp.al.connect_Weighted_Undirected_Edges(3, 2, 8);
		lp.al.connect_Weighted_Undirected_Edges(1, 2, 7);
		lp.al.connect_Weighted_Undirected_Edges(4, 3, 3);
		
		lp.computeLonngestPath(nodeList.get(3));
	}

}
class LPDijkstra
{
	List<GraphNode> nodeList;
	AdjacencyList al;
	int vertices;
	
	public LPDijkstra(List<GraphNode> nodeList, int vertices) {
		this.nodeList = nodeList;
		this.vertices = vertices;
		al = new AdjacencyList(nodeList);
	}
	
	public void computeLonngestPath(GraphNode node) {
		
		Queue<GraphNode> queue = new PriorityQueue<GraphNode>();
		node.setDistance(0);
		queue.addAll(nodeList);
		
		while (!queue.isEmpty()) {
			
			GraphNode current = queue.poll();
			List<GraphNode> neighbours = current.getNeighbours();
			if(neighbours!=null)
			{
				for (GraphNode graphNode : neighbours) {
					
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
		
		for (GraphNode graphNode : nodeList)
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
		
			System.out.print("Node : "+node.getNode()+", Distance : "+node.getDistance()*(-1)+", Path : ");
			fetchPath(node);
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodeList.add(new GraphNode());
			nodeList.get(i).setNode((char)(65+i));
			nodeList.get(i).setNodeIndex(i);
		}
	}
}