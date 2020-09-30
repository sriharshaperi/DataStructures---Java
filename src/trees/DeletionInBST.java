package trees;

public class DeletionInBST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Deletion dl = new Deletion();
		
		dl.in.insertIterative(5);
		dl.in.insertIterative(6);
		dl.in.insertIterative(4);
		dl.in.insertIterative(3);
		dl.in.insertIterative(2);
		dl.in.insertIterative(1);
		
		dl.delete(dl.in.root, 2);
		
		dl.in.inOrderTraversal(dl.in.root);
		
		
	}

}
class Deletion
{
	TreeNode root;
	Insertion in;
	
	public Deletion() {
		in = new Insertion();
		root = new TreeNode(in.root.data);
	}
	
	public TreeNode delete(TreeNode node, int value) {
		
		if(node==null)
			return null;
		
		TreeNode temp = null;
		
		if(value < node.data)
			node.left = delete(node.left, value);
		
		else if(value > node.data)
			node.right = delete(node.right, value);
	
		else if(value==node.data)
		{
			if(node.left==null && node.right==null)
				node = null;
			
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
				temp = getInOrderSuccessor(node, value);
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}
		}
		
		return node;
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