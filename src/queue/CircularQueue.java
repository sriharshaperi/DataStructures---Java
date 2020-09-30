package queue;

public class CircularQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		CQUsingArray queue = new CQUsingArray(6);
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		queue.offer(4);
		queue.offer(5);
		queue.offer(6);
		
		
		queue.traverseQueue();
	}

}
class CQUsingArray
{
	Integer queue[];
	private int offerPointer;
	private int pollPointer;
	
	public CQUsingArray(int size) {
		queue = new Integer[size];
	}
	
	public boolean isFull() {
		return offerPointer > queue.length-1 && pollPointer==0;
	}
	
	public boolean isEmpty() {
		return pollPointer-1==offerPointer;	
	}
	
	public void offer(int data) {
		
		if(isFull())
			System.out.println("Queue is Full");
		
		else
		{
			if(offerPointer > queue.length-1 && pollPointer > 0)
				offerPointer = 0;
			
			queue[offerPointer++] = data;
		}
	}
	
	public void poll() {
		
		if(isEmpty())
			System.out.println("Queue is Empty");
		
		else
		{
			if(pollPointer > queue.length-1 && offerPointer > 0)
				pollPointer  = 0;
	
				pollPointer++;
		}
	}
	
	public int peek() {
		return queue[pollPointer];
	}
	
	public void traverseQueue() {
		
			for (int i = pollPointer; i < offerPointer; i++)
				System.out.print(queue[i]+" ");
	}
}