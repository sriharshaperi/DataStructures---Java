package graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ConvertUGtoDAGwithAL {

	public static void main(String[] args) {
		
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		UGtoDAGwithAL dag = new UGtoDAGwithAL(nodeList, 5);
		
		dag.createVertices();
		
		dag.al.connectUndirectedEdges(0, 1);
		dag.al.connectUndirectedEdges(0, 2);
		dag.al.connectUndirectedEdges(1, 2);
		dag.al.connectUndirectedEdges(1, 3);
		dag.al.connectUndirectedEdges(3, 2);
		dag.al.connectUndirectedEdges(2, 4);
		dag.al.connectUndirectedEdges(4, 3);
		
		System.out.println("Undirected Graph : \n");
		dag.printAdjacencyList();
	
		dag.convertToDAG();
		
		System.out.println("Directed Acyclic Graph : \n");
		dag.printAdjacencyList();
	}

}
class UGtoDAGwithAL
{
	List<GraphNode> nodeList;
	int vertices;
	AdjacencyList al;
	
	public UGtoDAGwithAL(List<GraphNode> nodeList, int vertices) {
		this.nodeList = nodeList;
		this.vertices = vertices;
		al = new AdjacencyList(nodeList);
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
	
	public void convertToDAG() {
		
		Stack<GraphNode> stack = getTopSortedStack();
		while (!stack.isEmpty()) {
			
			GraphNode current = stack.pop();
			List<GraphNode> neighbours = current.getNeighbours();
			if(neighbours!=null)
			{
				for (GraphNode graphNode : neighbours)
				{
					if(graphNode.getNeighbours().contains(current))
						graphNode.getNeighbours().remove(current);
				}
			}
		}
	}
	
	public void printAdjacencyList() {
		
		for (GraphNode graphNode : nodeList) {
			System.out.println("Node : "+graphNode.getNode()+"\n");
			
			if(graphNode.getNeighbours()!=null)
			{
				System.out.print("Neighbours : ");
				for (GraphNode neighbour : graphNode.getNeighbours()) {
					System.out.print(neighbour.getNode()+" ");
				}
				System.out.println("\n");
			}
			else
				System.out.println("No Neighbours for "+graphNode.getNode()+"\n");
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