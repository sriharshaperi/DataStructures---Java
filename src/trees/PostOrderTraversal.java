package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PostOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PostOrder p = new PostOrder();
		p.iterative(p.root);
	}

}
class PostOrder
{
	TreeNode root;
	
	public PostOrder() {
		
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
	
	public void recurssive(TreeNode node) {
		
		if(node==null)
			return;
		
		recurssive(node.left);
		recurssive(node.right);
		System.out.println(node.data);
	}
	
	public void iterative(TreeNode node) {
		
		if(node==null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		List<TreeNode> list = new ArrayList<TreeNode>();
		stack.push(node);
		
		TreeNode temp = node;
		
		while (!stack.isEmpty()) {
			
			temp = stack.pop();
			list.add(0, temp);
			
			if(temp.left!=null)
				stack.push(temp.left);	
			
			if(temp.right!=null)
				stack.push(temp.right);
		}
		
		list.forEach(n-> System.out.print(n.data+" "));
	}
}