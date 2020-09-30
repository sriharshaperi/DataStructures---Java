package trees;

public class BinaryTreeUsingArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BinaryTreeArray bt = new BinaryTreeArray(10);
		
		bt.insert(1);
		bt.insert(2);
		bt.insert(3);
		bt.insert(4);
		bt.insert(5);
		bt.insert(6);
		bt.insert(7);
		
		bt.delete(4);
		bt.delete(3);
		bt.delete(4);
		
		bt.treeTraversal();
		
		System.out.println("Does element exist : "+bt.search(7));
	}

}
class BinaryTreeArray
{
	Integer tree[];
	int treeSize;
	int index;
	
	public BinaryTreeArray(int size) {
		tree = new Integer[size];
	}
	
	public int getTreeHeight() {
		return treeSize;
	}
	
	public void insert(int data) {
		
		if(tree[0]==null)
		{
			tree[0] = data;
			treeSize++;
			return;
		}
		else if(2*index+1 <= tree.length)
		{
			if(tree[2*index+1]==null)
				tree[2*index+1] = data;
			
			else if(tree[2*index+2]==null)
			{
				tree[2*index+2] = data;
				index++;
			}
			
			treeSize++;
		}
		else if(index <= tree.length-1)
		{
			tree[index] = data;
			index++;
			treeSize++;
		}
		else
			System.out.println("Tree size is full\n");
	}
	
	public boolean search(int data) {
		
		for (int i = 0; i < treeSize; i++) {
			if(tree[i]==data)
				return true;
		}
		return false;
	}
	
	public int getIndex(int data) {
		
		for (int i = 0; i < treeSize; i++) {
			if(tree[i]==data)
				return i;
		}
		return -1;
	}
	
	public void delete(int data) {
		
		int index = getIndex(data);
			
			if(index!=-1)
			{
				int temp = tree[treeSize-1];
				tree[treeSize-1] = tree[index];
				tree[index] = temp;
				treeSize--;
			}
			else
				System.out.println("Value does not exist.\n");
	}
	
	public void treeTraversal() {
		
		if(tree==null)
			return;
		
		System.out.println("Elements in the Binary Tree are : \n");
		for (int i = 0; i < treeSize; i++) {
			System.out.print(tree[i]+" ");
		}
		System.out.println("\n");
	}
}