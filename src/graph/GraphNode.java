package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GraphNode implements Comparable<GraphNode>
{
	private List<GraphNode> vertices;
	private List<GraphNode> neighbours = new ArrayList<GraphNode>();;
	private Character node;
	private boolean isVisited;
	private GraphNode parent;
	private int nodeIndex;
	private HashMap<GraphNode, Integer> weightedMap = new HashMap<GraphNode, Integer>();;
	private int distance;
	private int cycleFlag;
	
	public int getCycleFlag() {
		return cycleFlag;
	}

	public void setCycleFlag(int cycleFlag) {
		this.cycleFlag = cycleFlag;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public HashMap<GraphNode, Integer> getWeightedMap() {
		return weightedMap;
	}

	public void setWeightedMap(HashMap<GraphNode, Integer> weightedMap) {
		this.weightedMap = weightedMap;
	}

	public int getNodeIndex() {
		return nodeIndex;
	}

	public void setNodeIndex(int nodeIndex) {
		this.nodeIndex = nodeIndex;
	}

	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public GraphNode getParent() {
		return parent;
	}

	public void setParent(GraphNode parent) {
		this.parent = parent;
	}
	
	public List<GraphNode> getVertices() {
		return vertices;
	}

	public void setVertices(List<GraphNode> vertices) {
		this.vertices = vertices;
	}

	public List<GraphNode> getNeighbours() {
		return neighbours;
	}

	public void setNeighbours(List<GraphNode> neighbours) {
		this.neighbours = neighbours;
	}

	public Character getNode() {
		return node;
	}

	public void setNode(Character node) {
		this.node = node;
	}
	
	public GraphNode() {
		this.distance = Integer.MAX_VALUE;
	}

	@Override
	public int compareTo(GraphNode o) {
		return this.distance - o.distance;
	}
}
