package trees;

public class HeightBalancedTreeInsertion {

	public static void main(String[] args) {
		
		AVLTreeInsertion avl = new AVLTreeInsertion();
		
		System.out.println("Root node of BST before balancing : "+avl.root.data);
		
		avl.root = avl.balancedInsert(avl.root, 14);
		avl.root = avl.balancedInsert(avl.root, 15);
		avl.root = avl.balancedInsert(avl.root, 16);
		
		
		System.out.println("\nHeight of the balanced BST : "+avl.getMaxHeight(avl.root));
		
		System.out.println("\nElements are : \n");
		avl.traversal(avl.root);
		
		System.out.println("\n");
		System.out.println("Root node of BST after balancing : "+avl.root.data);
		
	}

}
class AVLTreeInsertion
{
	TreeNode root;
	
	public AVLTreeInsertion() {
		root = new TreeNode(5);
	}
	
	public int getMaxHeight(TreeNode node) {
		
		if(node==null)
			return -1;
		
		return Math.max(getMaxHeight(node.left), getMaxHeight(node.right)) + 1;
	}
	
	public TreeNode balancedInsert(TreeNode node, int data) {
		
		if(node==null)
			return node = new TreeNode(data);
		
		if(data < node.data)
			node.left = balancedInsert(node.left, data);
		
		else if(data > node.data)
			node.right = balancedInsert(node.right, data);
		
		node.height = getMaxHeight(node);
		
		int balanceFactor = 0;
		balanceFactor = getMaxHeight(node.left) - getMaxHeight(node.right);
		
			if(!(balanceFactor>=-1 && balanceFactor<=1))
			{
				if(balanceFactor > 1 && data < node.left.data)
				{
					return rightRotation(node);
				}
				else if(balanceFactor > 1 && data > node.left.data)
				{
					node.left = leftRotation(node.left);
					return rightRotation(node);
				}
				else if(balanceFactor < -1 && data < node.right.data)
				{
					node.right = rightRotation(node.right);
					return leftRotation(node);
				}
				else if(balanceFactor < -1 && data > node.right.data)
				{
					return leftRotation(node);
				}
			}
			
		return node;
	}
	
	public TreeNode rightRotation(TreeNode currentDisbalancedNode) {
		
		TreeNode newRoot = currentDisbalancedNode.left;
		TreeNode newRootSubtree = newRoot.right;
		newRoot.right = currentDisbalancedNode;
		currentDisbalancedNode.left = newRootSubtree;
		
		currentDisbalancedNode.height = getMaxHeight(currentDisbalancedNode);
		newRoot.height = getMaxHeight(newRoot);
		
		return newRoot;
	}
	
	public TreeNode leftRotation(TreeNode currentDisbalancedNode) {
		
		TreeNode newRoot = currentDisbalancedNode.right;
		TreeNode newRootSubtree = newRoot.left;
		newRoot.left = currentDisbalancedNode;
		currentDisbalancedNode.right = newRootSubtree;
		
		currentDisbalancedNode.height = getMaxHeight(currentDisbalancedNode);
		newRoot.height = getMaxHeight(newRoot);
		
		return newRoot;
	}
	
	public void traversal(TreeNode node) {
		
		if(node==null)
			return;
		
		traversal(node.left);
		System.out.print(node.data+" ");
		traversal(node.right);
	}
}