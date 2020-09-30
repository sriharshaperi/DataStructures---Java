package trees;

public class TreeNode {

	TreeNode left;
	TreeNode right;
	int height;
	int data;
	boolean isVisited = false;
	
	public TreeNode(int data) {
		this.data = data;
	}
}
