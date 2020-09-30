package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {

	public static void main(String[] args) {
	
		LevelOrder l = new LevelOrder();
		l.iterativeBFS(l.root);

	}

}
class LevelOrder
{
	TreeNode root;
	
	public LevelOrder() {
	
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
	
	public void iterativeBFS(TreeNode node) {
		
		if(node==null)
			return;
		
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(node);
		
		while (!queue.isEmpty()) {
			
			TreeNode current = queue.poll();
			System.out.print(current.data+" ");
			
			if(current.left!=null)
				queue.offer(current.left);
			
			if(current.right!=null)
				queue.offer(current.right);
		}
	}
}