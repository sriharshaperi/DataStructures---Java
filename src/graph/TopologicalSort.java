package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class TopologicalSort {

	public static void main(String[] args) {
		
		List<GraphNode> nodes = new ArrayList<GraphNode>();
		Topological top = new Topological(nodes, 5);
		
		top.createVertices();
		
		top.al.connectUndirectedEdges(0, 1);
		top.al.connectUndirectedEdges(0, 2);
		top.al.connectUndirectedEdges(1, 3);
		top.al.connectUndirectedEdges(1, 2);
		top.al.connectUndirectedEdges(2, 4);
		top.al.connectUndirectedEdges(3, 2);
		top.al.connectUndirectedEdges(4, 3);
		
		top.execcuteTopologiocalSort();
	}
}
class Topological
{	
	List<GraphNode> nodes;
	AdjacencyList al;
	int vertices;
	
	public Topological(List<GraphNode> nodes, int vertices) {
		al = new AdjacencyList(nodes);
		this.vertices = vertices;
		this.nodes = nodes;
	}
	
	public void execcuteTopologiocalSort() {
		
		Stack<GraphNode> stack = new Stack<>();

		for (GraphNode graphNode : nodes) {
			if(!graphNode.isVisited())
				sort(graphNode, stack);
		}
		
		System.out.println("Topological sort of the directed graph : \n");
		while (!stack.isEmpty())
			System.out.print(stack.pop().getNode());
	}
	
	public void sort(GraphNode node, Stack<GraphNode> stack) {
		
		List<GraphNode> neighbours = node.getNeighbours();
		if(neighbours!=null)
		{
			for (GraphNode graphNode : neighbours) {
				
				if(!graphNode.isVisited())
				{
					graphNode.setVisited(true);
					sort(graphNode, stack);
				}
			}
		}
		
		node.setVisited(true);
		if(!stack.contains(node))
			stack.push(node);
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodes.add(new GraphNode());
			nodes.get(i).setNode((char)(65+i));
			nodes.get(i).setNodeIndex(i);
		}
	}
}
