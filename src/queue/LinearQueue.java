package queue;

public class LinearQueue {

	public static void main(String[] args) {
		
		QueueUsingArray queue = new QueueUsingArray(10);
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		queue.offer(6);
		queue.offer(7);
		queue.offer(8);
		queue.offer(9);
		queue.offer(10);
		
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		queue.poll();
		
		queue.traverseQueue();
		
		System.out.println("\n");
		System.out.println(queue.peek());
	}

}
class QueueUsingArray
{
	Integer queue[];
	int sizeOfQueue;
	private int offerPointer;
	private int pollPointer;
	
	public QueueUsingArray(int size) {
		queue = new Integer[size];
	}
	
	public int size() {
		return pollPointer;
	}
	
	public boolean isEmpty() {
		return pollPointer >= offerPointer ? true : false;
	}
	
	public boolean isFull() {
		return offerPointer > queue.length-1 ? true : false;
	}
	
	public void offer(int data) {
		
		if(!isFull())
			queue[offerPointer++] = data;
		else
			System.out.println("\nQueue is Full");
	}
	
	public void poll() {
		
		if(!isEmpty())
			pollPointer++;
		else
			System.out.println("\nQueue is Empty");
	}
	
	public int peek() {
		return queue[pollPointer];
	}
	
	public void traverseQueue() {
		
		if(!isEmpty())
		{
			System.out.println("Elements in the Queue are : \n");
			for (int i = pollPointer; i < offerPointer; i++) {
				System.out.print(queue[i]+" ");
			}
		}
	}
}
