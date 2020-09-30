package trees;

public class BSTUsingArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		BSTArray bst = new BSTArray(10);
		
		bst.insert(5);
		bst.insert(6);
		bst.insert(2);
		bst.insert(4);
		bst.insert(7);
		bst.insert(3);
		bst.insert(1);
		
//		bst.traversal();
		
		for (Integer i : bst.bst) {
			System.out.print(i+" ");
		}
	}

}
class BSTArray
{
	Integer bst[];
	int treeSize;
	
	public BSTArray(int size) {
		bst = new Integer[size];
	}
	
	public int size() {
		return treeSize;
	}
	
	public boolean isEmpty() {
		return treeSize < 0;
	}
	
	public boolean isFull() {
		return treeSize > bst.length-1;
	}
	
	public void deleteTree() {
		bst = null;
		System.out.println("Tree has been deleted\n");
	}
	
	public boolean search(int data) {
		
		if(bst==null)
			return false;
		
		if(data==bst[0])
			return true;
		
		else if(data < bst[0])
		{
			int i = 1;
			
			if(data==bst[i])
				return true;
			
			while (bst[i]!=null) {
				
				if(data < bst[i])
				{
					i = 2*i + 1;
					if(data==bst[i])
						return true;
				}
				
				else if(data > bst[i])
				{
					i = 2*i + 2;
					if(data==bst[i])
						return true;
				}
			}
			return false;
		}
		else if(data > bst[0])
		{
			int i = 2;
			
			if(data==bst[i])
				return true;
			
			while (bst[i]!=null) {
				
				if(data < bst[i])
				{
					i = 2*i + 1;
					if(data==bst[i])
						return true;
				}
				
				else if(data > bst[i])
				{
					i = 2*i + 2;
					if(data==bst[i])
						return true;
				}
			}
			return false;
		}
		return false;
	}
	
	public void insert(int data) {
		
		if(!isFull())
		{
			if(bst[0]==null)
			{
				bst[0] = data;
				treeSize++;
				return;
			}
			else if(data < bst[0])
			{
				int i = 1;
				
				while (bst[i]!=null) {
					
					if(data < bst[i])
						i = 2*i + 1;
					
					else if(data > bst[i])
						i = 2*i + 2;
				}
				bst[i] = data;
				
				int p = i/2;
				while (i>0) {
					
					if(bst[p] < bst[2*p+1])
					{
						int temp = bst[p];
						bst[p] = bst[2*p+1];
						bst[2*p+1] = temp;
					}
					
					if(bst[p] > bst[2*p+2])
					{
						int temp = bst[p];
						bst[p] = bst[2*p+2];
						bst[2*p+2] = temp;
					}
					
					i = p;
					p = i/2;
				}
				
				treeSize++;
			}
			else if(data > bst[0])
			{
				int i = 2;
				
				while (bst[i]!=null) {
					
					if(data < bst[i])
						i = 2*i + 1;
					
					else if(data > bst[i])
						i = 2*i + 2;
				}
				bst[i] = data;
				
				int p = i/2;
				while (i>0) {
					
					if(bst[p] < bst[2*p+1])
					{
						int temp = bst[p];
						bst[p] = bst[2*p+1];
						bst[2*p+1] = temp;
					}
					
					if(bst[p] > bst[2*p+2])
					{
						int temp = bst[p];
						bst[p] = bst[2*p+2];
						bst[2*p+2] = temp;
					}
					
					i = p;
					p = i/2;
				}
				
				treeSize++;
			}
		}
		else
			System.out.println("Tree size is Full\n");
	}
	
	public void traversal() {
	
		System.out.println("Elements of the Binary search tree are : \n");
		for (int i = 0; i < treeSize; i++) {
			System.out.print(bst[i]+" ");
		}
		System.out.println("\n");
	}
}