package heap;

public class MinHeap {

	public static void main(String[] args) {
	
		MinHeapConstruction minHeap = new MinHeapConstruction(6);
		
		minHeap.insertIntoMinHeap(6);
		minHeap.insertIntoMinHeap(3);
		minHeap.insertIntoMinHeap(5);
		minHeap.insertIntoMinHeap(1);
		minHeap.insertIntoMinHeap(4);
		minHeap.insertIntoMinHeap(2);
		
		minHeap.deleteFromMinHeap();
		minHeap.deleteFromMinHeap();
		minHeap.deleteFromMinHeap();
		minHeap.deleteFromMinHeap();
		
		minHeap.levelOrderTraversal();
	}

}
class MinHeapConstruction
{
	Integer heap[];
	int sizeOfHeap;
	HeapifyBottomToTop bt;
	HeapifyTopToBottom tb;
	
	public MinHeapConstruction(int size) {
		heap = new Integer[size+1];
		bt = new HeapifyBottomToTop();
		tb = new HeapifyTopToBottom();
	}
	
	public void insertIntoMinHeap(int value) {
		
		if(!isFull())
		{
			heap[sizeOfHeap+1] = value;
			sizeOfHeap++;
			bt.heapifyMinHeap(heap, sizeOfHeap);
		}
		else
		{
			System.out.println("\nHeap is full");
			return;
		}
	}
	
	public void deleteFromMinHeap() {
		
		if(!isEmpty())
		{
			
			int temp = heap[1];
			System.out.println("\nRemoved "+temp+" from the max heap.");
			heap[1] = heap[sizeOfHeap];
			sizeOfHeap--;
			
			tb.heapifyMinHeap(heap, 1, sizeOfHeap);
		}
		else
		{
			System.out.println("\nHeap is Empty");
			return;
		}
	}
	
	public boolean isEmpty() {
		return sizeOfHeap < 1;
	}
	
	public int peek() {
		return heap[1];
	}
	
	public boolean isFull() {
		return sizeOfHeap > heap.length-1; 
	}
	
	public void levelOrderTraversal() {
		
		System.out.println("\nElements of the Max Heap are : \n");
		for (int i = 1; i <= sizeOfHeap; i++) {
			System.out.print(heap[i]+" ");
		}
	}
}