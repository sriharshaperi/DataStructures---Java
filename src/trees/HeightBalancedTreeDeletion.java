package trees;

public class HeightBalancedTreeDeletion {

	public static void main(String[] args) {
		
		AVLTreeDeletion avl = new AVLTreeDeletion();
		
		
		System.out.println("root of BST before balancing : "+avl.avl.root.data);
		
		
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 6);
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 7);
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 8);
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 9);
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 10);
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 11);
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 12);
		avl.avl.root = avl.avl.balancedInsert(avl.avl.root, 13);
		
		
		avl.avl.root = avl.delete(avl.avl.root, 9);
		avl.avl.root = avl.delete(avl.avl.root, 10);
		
		System.out.println("\nroot of BST after balancing : "+avl.avl.root.data);
		
		System.out.println("\nHeight of the balanced BST after deletion operation : "+avl.getHeight(avl.avl.root));
		
		System.out.println("\nElements after deletion are : \n");
		avl.traversal(avl.avl.root);			
	}

}
class AVLTreeDeletion
{
	TreeNode root;
	AVLTreeInsertion avl;
	
	public AVLTreeDeletion() {
		avl = new AVLTreeInsertion();
		root = new TreeNode(avl.root.data);
	}
	
	public int getHeight(TreeNode node) {
		
		if(node==null)
			return -1;
		
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
	}
	
	public TreeNode leftRotation(TreeNode node) {
		
		TreeNode newNode = node.right;
		TreeNode newSubtree = newNode.left;
		newNode.left = node;
		node.right = newSubtree;
		
		node.height = getHeight(node);
		newNode.height = getHeight(newNode);
		
		return newNode;
	}
	
	public TreeNode rightRotation(TreeNode node) {
		
		TreeNode newRoot = node.left;
		TreeNode newSubtree = newRoot.right;
		newRoot.right = node;
		node.left = newSubtree;
		
		node.height = getHeight(node);
		newRoot.height = getHeight(newRoot);
		
		return newRoot;
	}
	
	public boolean valueExists(TreeNode node, int data) {
		
		if(node==null)
			return false;
		
		if(data < node.data)
			return valueExists(node.left, data);
		
		else if(data > node.data)
			return valueExists(node.right, data);
		
		else if(data==node.data)
			return true;
		
		return false;
	}
	
	public TreeNode getNode(TreeNode node, int data) {
		
		if(node==null)
			return null;
		
		if(data < node.data)
			node.left =  getNode(node.left, data);
		
		else if(data > node.data)
			node.right =  getNode(node.right, data);
		
		else if(data==node.data)
			return node;
		
		return null;
	}
	
	public TreeNode getInOrderSuccessor(TreeNode node, int data) {
		
		if(valueExists(node, data))
		{
			TreeNode temp = node;
			
			if(temp.right!=null)
			{
				temp = temp.right;
				
				while (temp.left!=null) 
					temp = temp.left;
				
				return temp;
			}
			else
			{
				TreeNode successor = null;
				TreeNode ancestor = node;
				TreeNode current = getNode(node, data);
				
				while (ancestor!=current) {
					
					if(current.data < ancestor.data)
					{
						successor = ancestor;
						ancestor = ancestor.left;
					}
					else
						ancestor = ancestor.right;
				}
				
				return successor;
			}
		}
		else
			return null;
	}
	
	public TreeNode delete(TreeNode node, int data) {
		
		if(node==null)
			return null;
		
		TreeNode temp = null;
		
		if(data < node.data)
			node.left = delete(node.left, data);
		
		else if(data > node.data)
			node.right = delete(node.right, data);
		
		else
		{
			if(node.left==null && node.right==null)
				return node = null;
			
			else if(node.left==null)
			{
				temp = node;
				node = node.right;
			}
			
			else if(node.right==null)
			{
				temp = node;
				node = node.left;
			}
			else
			{
				temp = getInOrderSuccessor(node, data);
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}
			
			int balanceFactor = getHeight(node.left) - getHeight(node.right);
			
			if(balanceFactor<=-1 && balanceFactor>=1)
			{
				if(balanceFactor>1 && data < node.left.data)
				{
					return rightRotation(node);
				}
				else if(balanceFactor>1 && data > node.left.data)
				{
					node.left = leftRotation(node.left);
					return rightRotation(node);
				}
				else if(balanceFactor<-1 && data < node.right.data)
				{
					node.right = rightRotation(node.right);
					return leftRotation(node);
				}
				else if(balanceFactor<-1 && data > node.right.data)
				{
					return leftRotation(node);
				}
			}
		}
		
		return node;
	}
	
	public void traversal(TreeNode node) {
		
		if(node==null)
			return;
		
		traversal(node.left);
		System.out.print(node.data+" ");
		traversal(node.right);
	}
}