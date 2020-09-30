package trees;

import java.util.Stack;

public class PreOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PreOrder p = new PreOrder();
		
		p.iterative(p.root);
		System.out.println("\n");
		p.recursive(p.root);
	}

}
class PreOrder
{
	TreeNode root;
	
	public PreOrder() {
		
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
		
		System.out.print(node.data+" ");
		recursive(node.left);
		recursive(node.right);
	}
	
	public void iterative(TreeNode node) {
		
		if(node==null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		
		stack.push(node);
		
		while (!stack.isEmpty()) {
			
			TreeNode current = stack.pop();
			System.out.print(current.data+" ");
			
			if(current.right!=null)
				stack.push(current.right);
			
			if(current.left!=null)
				stack.push(current.left);
		}
	}
}