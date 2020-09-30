package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class NumberOfPaths {

	public static void main(String[] args) {
		
		List<GraphNode> nodList = new ArrayList<GraphNode>();
		Paths paths = new Paths(nodList, 5);
		
		paths.createVertices();
		
		paths.al.connect_Weighted_Undirected_Edges(0, 1, 6);
		paths.al.connect_Weighted_Undirected_Edges(0, 2, 7);
		paths.al.connect_Weighted_Undirected_Edges(1, 2, 4);
		paths.al.connect_Weighted_Undirected_Edges(1, 3, 9);
		paths.al.connect_Weighted_Undirected_Edges(2, 3, 5);
		paths.al.connect_Weighted_Undirected_Edges(2, 4, 8);
		paths.al.connect_Weighted_Undirected_Edges(3, 4, 16);
		
		paths.dag.convertToDAG();
		
		System.out.println("Number Of Paths from "+nodList.get(1).getNode()+" to "+nodList.get(4).getNode()+" : "+paths.getNumberOfPaths(nodList.get(1), nodList.get(4)));
		
		Map<String, Integer> shortest = paths.getShortestPath(nodList.get(1), nodList.get(4));
		shortest.forEach((k,v)-> System.out.println("\nShotest Path : "+k+", Shortest Distance : "+v));
		
		Map<String, Integer> longest = paths.getLongestPath(nodList.get(1), nodList.get(4));
		longest.forEach((k,v)-> System.out.println("\nLongest Path : "+k+", Longest Distance : "+v));
		
		
	} 
}
class Paths
{
	List<GraphNode> nodeList;
	AdjacencyList al;
	int vertices;
	int sum;
	UGtoDAGwithAL dag;
	
	public Paths(List<GraphNode> nodeList, int vertices) {
		al = new AdjacencyList(nodeList);
		this.nodeList = nodeList;
		this.vertices = vertices;
		dag = new UGtoDAGwithAL(nodeList, vertices);
	}
	
	public List<List<Integer>> getListOfPossiblePaths(GraphNode source, GraphNode destination) {
		
		List<List<Integer>> pathsList = new ArrayList<List<Integer>>();
		Queue<List<Integer>> queue = new LinkedList<List<Integer>>();
		
		int sourceIndex = source.getNodeIndex();
		int destIndex = destination.getNodeIndex();
	
		queue.offer(Arrays.asList(sourceIndex));	
		while (!queue.isEmpty()) {
			
			List<Integer> currentPath = queue.poll();
			int lastIndexOfPath = currentPath.get(currentPath.size()-1);
			
			if(lastIndexOfPath==destIndex)
				pathsList.add(new ArrayList<Integer>(currentPath));
			else
			{
				GraphNode node = nodeList.get(lastIndexOfPath);
				List<GraphNode> neighbours = node.getNeighbours();
				
				if(neighbours!=null)
				{
					for (GraphNode graphNode : neighbours) {
						List<Integer> addToCurrentPath = new ArrayList<Integer>(currentPath);
						addToCurrentPath.add(graphNode.getNodeIndex());
						queue.offer(addToCurrentPath);
					}
				}
			}
		}
		return pathsList;
	}
	
	public void printPath(GraphNode node) {
		
		if(node!=null)
		{
			printPath(node.getParent());
			System.out.print(node.getNode());
		}
	}
	
	public void createVertices() {
		
		for (int i = 0; i < vertices; i++) {
			
			nodeList.add(new GraphNode());
			nodeList.get(i).setNode((char)(65+i));
			nodeList.get(i).setNodeIndex(i);
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
	
	public Map<String, Integer> getPathsCollectionUnweighted(GraphNode source, GraphNode destination) {
		
		Map<String, Integer> pathsCollection = new HashMap<String, Integer>();
		String path = "";
		
		List<List<Integer>> allPaths = getListOfPossiblePaths(source, destination);
		
		for (List<Integer> list : allPaths) {
			
			for (Integer nodeIndex : list)
				path += nodeList.get(nodeIndex).getNode();
			
			pathsCollection.put(path, path.length()-1);
			path = "";
		}
		
		return pathsCollection;
	}
	
	public Map<String, Integer> getPathsCollectionWeighted(GraphNode source, GraphNode destination) {
		
		Map<String, Integer> pathsCollection = new HashMap<String, Integer>();
		String path = "";
		
		List<List<Integer>> allPaths = getListOfPossiblePaths(source, destination);
		
		for (List<Integer> list : allPaths) {
			
			for (Integer nodeIndex : list)
				path += nodeList.get(nodeIndex).getNode();
			
			pathsCollection.put(path, getTotalCostOfPath(list));
			path = "";
		}
		
		return pathsCollection;
	}
	
	public int getTotalCostOfPath(List<Integer> list) {
		
		List<Integer> temp = new ArrayList<Integer>();
		temp.addAll(list);
		int cost = 0;

		if(temp.size()>=2)
		{
			while (temp.size()!=1) {
				
				GraphNode first = nodeList.get(temp.get(0));
				GraphNode second = nodeList.get(temp.get(1));
				cost += first.getWeightedMap().get(second);
				temp.remove(0);
			}
		}
		
		return cost;
	}
	
	public Map<String, Integer> getShortestPath(GraphNode source, GraphNode destination) {
		
		Map<String, Integer> pair = new HashMap<String, Integer>();
		String path = null;
		
		Map<String, Integer> shortest = getPathsCollectionWeighted(source, destination);

		Set<Integer> distanceSet = new HashSet<Integer>(shortest.values());
		Set<String> pathSet = new HashSet<String>(shortest.keySet());
		List<Integer> distanceList = new ArrayList<Integer>(distanceSet);

		
		int min = distanceList.get(0);
		for (Integer val : distanceList) {
			min = Math.min(min, val);
		}
		
		for (String string : pathSet) {
			if(shortest.get(string)==min)
				path = string;
		}
		
		pair.put(path, min);
		
		return pair;
	}
	
	public Map<String, Integer> getLongestPath(GraphNode source, GraphNode destination) {
		
		Map<String, Integer> pair = new HashMap<String, Integer>();
		String path = null;
		
		Map<String, Integer> longest = getPathsCollectionWeighted(source, destination);

		Set<Integer> distanceSet = new HashSet<Integer>(longest.values());
		Set<String> pathSet = new HashSet<String>(longest.keySet());
		List<Integer> distanceList = new ArrayList<Integer>(distanceSet);

		
		int max = distanceList.get(0);
		for (Integer val : distanceList) {
			max = Math.max(max, val);
		}
		
		for (String string : pathSet) {
			if(longest.get(string)==max)
				path = string;
		}
		pair.put(path, max);
		
		return pair;
		
	}
	
	public int getNumberOfPaths(GraphNode source, GraphNode destination) {
		
		return getPathsCollectionWeighted(source, destination).size();
	}
}