package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AdjacencyList {

	List<GraphNode> nodeList;
	
	public AdjacencyList(List<GraphNode> nodeList) {
		this.nodeList = nodeList;
	}
	
	public void connectUndirectedEdges(int i, int j) {
		
		if(i>=0 && i<nodeList.size() && j>=0 && j<nodeList.size())
		{
			GraphNode first = nodeList.get(i);
			GraphNode second = nodeList.get(j);
			
			first.getNeighbours().add(second);
			second.getNeighbours().add(first);
		}
		else
			System.out.println("indices out of bounds");
	}
	
	public void connectDirectedEdges(int i, int j) {
		
		if(i>=0 && i<nodeList.size() && j>=0 && j<nodeList.size())
		{
			GraphNode first = nodeList.get(i);
			GraphNode second = nodeList.get(j);
			
			first.getNeighbours().add(second);
		}
		else
			System.out.println("indices out of bounds");
	}
	
	public void connect_Weighted_Undirected_Edges(int i, int j, int weight) {
		
		if(i>=0 && i<nodeList.size() && j>=0 && j<nodeList.size())
		{
			
			GraphNode first = nodeList.get(i);
			GraphNode second = nodeList.get(j);
			
				first.getNeighbours().add(second);
				first.getWeightedMap().put(second, weight);
				second.getNeighbours().add(first);
				second.getWeightedMap().put(first, weight);
		}
		else
			System.out.println("indices out of bounds");
	}
	
	public void connect_Weighted_Directed_Edges(int i, int j, int weight) {
		
		if(i>=0 && i<nodeList.size() && j>=0 && j<nodeList.size())
		{
			
			GraphNode first = nodeList.get(i);
			GraphNode second = nodeList.get(j);
			
			first.getNeighbours().add(second);
			first.getWeightedMap().put(second, weight);
		}
		else
			System.out.println("indices out of bounds");
	}
}
