package trees;

public class InsertionInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Insertion in = new Insertion();
		
		in.insertRecurssive(in.root, 10);
		in.insertRecurssive(in.root, 4);
		in.insertRecurssive(in.root, 6);
		in.insertRecurssive(in.root, 8);
		in.insertRecurssive(in.root, 5);
		in.insertRecurssive(in.root, 9);
		
		in.insertIterative(0);
		in.insertIterative(1);
		in.insertIterative(2);
		in.insertIterative(3);
		
		in.inOrderTraversal(in.root);
		
		System.out.println("\nValue exits? "+in.search(in.root, 3));
		System.out.println("\nInOrder Successor : "+in.getInOrderSuccessor(in.root, 4).data);
		
	}

}
class Insertion
{
	TreeNode root;
	
	public Insertion() {
		root = new TreeNode(7);
	}
	
	public TreeNode insertRecurssive(TreeNode node, int data) {
		
		if(node==null)
			return node = new TreeNode(data);
		
		if(data < node.data)
			node.left = insertRecurssive(node.left, data);
		
		else if(data > node.data)
			node.right = insertRecurssive(node.right, data);
		
		return node;
	}
	
	public TreeNode insertIterative(int data) {
		
		TreeNode node = new TreeNode(data);
		
		if(root==null)
			return root = node;
			
			TreeNode parent = null;
			TreeNode current = root;
			
			while (current!=null) {
				parent = current;
				if(data < current.data)
					current = current.left;
				
				else if(data > current.data)
					current = current.right;
			}
				if(data < parent.data)
					parent.left = node;
				else if(data > parent.data)
					parent.right = node;
				
		return	current;
	}
	
	public boolean search(TreeNode node, int data) {
		
		if(node==null)
			return false;
		
		if(data < node.data)
			return search(node.left, data);
		
		else if(data > node.data)
			return search(node.right, data);
		
		else if(data==node.data)
			return true;
		
		return false; 
	}
	
	public void inOrderTraversal(TreeNode node) {
		
		if(node==null)
			return;
		
		inOrderTraversal(node.left);
		System.out.print(node.data+" ");
		inOrderTraversal(node.right);
	}
	
	public TreeNode getInOrderSuccessor(TreeNode node, int data) {
		
		if(node==null)
			return null;
		
		if(search(node, data))
		{
			TreeNode current = getNode(node, data);
			
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
				
				while (ancestor != current) {
					
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
	
	public TreeNode getNode(TreeNode node, int data) {
		
		if(node==null)
			return null;
		
		if(data < node.data)
			return getNode(node.left, data);
		
		else if(data > node.data)
			return getNode(node.right, data);
		
		else if(data==node.data)
			return node;
		
		return null;
	}
}