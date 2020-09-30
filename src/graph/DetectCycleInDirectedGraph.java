package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInDirectedGraph {

	public static void main(String[] args) {
		
		List<GraphNode> nodeList = new ArrayList<GraphNode>();
		DiectedGraphCycle dgc = new DiectedGraphCycle(nodeList, 50);
		
		dgc.createVertices();
		
		dgc.al.connectUndirectedEdges(0, 1);
		dgc.al.connectUndirectedEdges(0, 2);
		dgc.al.connectUndirectedEdges(0, 3);
		dgc.al.connectUndirectedEdges(0, 4);
		dgc.al.connectUndirectedEdges(1, 2);
		dgc.al.connectUndirectedEdges(2, 4);
		dgc.al.connectUndirectedEdges(4, 3);
		
		boolean hasCycles = dgc.hasCycle();
		System.out.println(hasCycles);
	}

}
class DiectedGraphCycle
{
	List<GraphNode> nodeList;
	int vertices;
	AdjacencyList al;
	
	public DiectedGraphCycle(List<GraphNode> nodeList, int vertices) {
		this.vertices = vertices;
		this.nodeList = nodeList;
		al = new AdjacencyList(nodeList);
		
		for (GraphNode graphNode : nodeList)
			graphNode.setCycleFlag(-1);
	}
	
	public boolean hasCycle() {
		
		Queue<GraphNode> queue = new LinkedList<GraphNode>();
		List<GraphNode> cycles = new ArrayList<GraphNode>();
		
		for (GraphNode graphNode : nodeList) {
			
			graphNode.setCycleFlag(0);
			queue.add(graphNode);
			graphNode.setCycleFlag(1);
			
			while (!queue.isEmpty()) {
				
				GraphNode current = queue.remove();
				List<GraphNode> neighbours = current.getNeighbours();
				if(neighbours!=null)
				{
					for (GraphNode neighbour : neighbours) {
						
						if(neighbour.getCycleFlag()==-1)
						{
							neighbour.setCycleFlag(0);
							queue.add(graphNode);
							neighbour.setCycleFlag(1);
						}
						else if(neighbour.getCycleFlag()==0 && !cycles.contains(neighbour))
							cycles.add(neighbour);
					}
				}
			}
		}
//		printCycleList(cycles);
		
		if(cycles.size()==0)
			return false;
		else
			return true;
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodeList.add(new GraphNode());
			nodeList.get(i).setNode((char)(65+i));
			nodeList.get(i).setNodeIndex(i);
		}
	}
	
	public void printCycleList(List<GraphNode> list) {
		
		System.out.println("Cycle is occuring at these nodes : \n");
		for (GraphNode graphNode : list)
			System.out.print(graphNode.getNode()+" ");
		System.out.println("\n");
	}
}