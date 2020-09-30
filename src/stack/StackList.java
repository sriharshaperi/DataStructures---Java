package stack;

public final class StackList {

	public static void main(String[] args) {
				
		Stack stack = new Stack();
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		stack.pop();
		stack.pop();
		stack.pop();
		
		stack.traversal();
		
		if(!stack.isEmpty())
			System.out.println("\nPeek : "+stack.peek());
		else
			System.out.println("\nStack is Empty");
	}

}
class Node
{
	Node next;
	Node previous;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}
class Stack
{
	Node head;
	int stackSize;
	
	public int size() {
		return stackSize;
	}
	
	public void push(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head = node;
			stackSize++;
		}
		else
		{
			node.next = head;
			head = node;
			stackSize++;
		}
	}
	
	public void pop() {
		
		if(head==null)
			return;
		
		head = head.next;
		stackSize--;
	}
	
	public void traversal() {
		
		if(head==null)
			return;
		
		Node temp = head;
		
		System.out.println("Elements in the stack are : \n");
		while (temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println();
	}
	
	public int peek() {
		return head.data;
	}
	
	public boolean isEmpty() {
		return head==null;
	}
}