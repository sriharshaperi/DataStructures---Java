package trees;

import java.util.Stack;

public class InOrderTraversal {

	public static void main(String[] args) {
	
		InOrder in = new InOrder();
		
		System.out.println("Recursive Traversal : \n");
		in.recursive(in.root);
		System.out.println();
		
		System.out.println("\nIterative Traversal : \n");
		in.iterative(in.root);
		System.out.println();
		
	}

}
class InOrder
{
	TreeNode root;
	Insertion in;
	
	public InOrder() {
		in = new Insertion();
		
		root = new TreeNode(100);
		root.left = new TreeNode(80);
		root.right = new TreeNode(120);
		root.left.left = new TreeNode(60);
		root.left.right = new TreeNode(90);
		root.right.left = new TreeNode(105);
		root.right.right = new TreeNode(130);
		root.left.left.left = new TreeNode(40);
		root.left.left.right = new TreeNode(75);
		root.left.left.left.right = new TreeNode(55);
		root.right.left.left = new TreeNode(102);
		root.right.right.right = new TreeNode(140);
		root.right.right.right.left = new TreeNode(135);
	}
	
	public void recursive(TreeNode node) {
		
		if(node==null)
			return;
		
		recursive(node.left);
		System.out.print(node.data+" ");
		recursive(node.right);
	}
	
	public void iterative(TreeNode node) {
		
		if(node==null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		TreeNode temp = node;
		while (!stack.isEmpty() || temp!=null) {
			
			if(temp!=null)
			{
				stack.push(temp);
				temp = temp.left;
			}
			else
			{
				temp = stack.pop();
				System.out.print(temp.data+" ");
				temp = temp.right;
			}
		}
	}
}
