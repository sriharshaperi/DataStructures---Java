package stack;

public class StackArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Array stack = new Array(10);
		
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		
		stack.pop();
		stack.pop();
		stack.pop();

		stack.traversal();
		
		System.out.println("Peek : "+stack.peek());
	}

}
class Array
{
	Integer stack[];
	int stackpeek;
	
	public Array(int size) {
		stack = new Integer[size];
	}
	
	public int size() {
		return stackpeek;
	}
	
	public boolean isFull() {
		return stackpeek > stack.length-1;
	}
	
	public boolean isEmpty() {
		return stackpeek < 0;
	}
	
	public void push(int data) {
		
		if(!isFull())
			stack[stackpeek++] = data;
		else
			System.out.println("Stack is Full\n");
	}
	
	public void pop() {
		
		if(!isEmpty())
			stackpeek--;
		else
			System.out.println("Stack is Empty\n");
	}
	
	public int peek() {
		
		if(stackpeek-1==-1)
			return -1;
		else
			return stack[stackpeek-1];
	}
	
	public void traversal() {
		
		System.out.println("Elements in the stack are : \n");
		for (int i = 0; i < stackpeek; i++) {
			System.out.print(stack[i]+" ");
		}
		System.out.println("\n");
	}
}