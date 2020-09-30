package queue;

public class QueueList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Queue queue = new Queue();
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		
		queue.poll();
		
		queue.traversal();
		
		System.out.println("Peek : "+queue.peek());
		System.out.println("Size : "+queue.size());
	}

}
class Node
{
	Node next;
	int data;
	
	public Node(int data) {
		this.data = data;
	}
}
class Queue
{
	Node head;
	int listSize;
	
	public int size() {
		return listSize;
	}
	
	public void offer(int data) {
		
		Node node = new Node(data);
		
		if(head==null)
		{
			head=node;
			listSize++;
		}
		else
		{
			Node temp = head;
			
			while (temp.next!=null) {
				temp = temp.next;
			}
			temp.next = node;
			listSize++;
		}
	}
	
	public void poll() {
		
		if(head==null)
			return;
		head = head.next;
		listSize--;
	}
	
	public int peek() {
		return head.data;
	}
	
	public void traversal() {
		
		if(head==null)
			return;
		
		Node temp = head;
		while (temp!=null) {
			System.out.print(temp.data+" ");
			temp = temp.next;
		}
		System.out.println("\n");
	}
}