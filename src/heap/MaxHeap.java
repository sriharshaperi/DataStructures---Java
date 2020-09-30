package heap;

public class MaxHeap {

	public static void main(String[] args) {
	
		MaxHeapConstruction maxHeap = new MaxHeapConstruction(6);
		
		maxHeap.insertIntoMaxHeap(5);
		maxHeap.insertIntoMaxHeap(6);
		maxHeap.insertIntoMaxHeap(2);
		maxHeap.insertIntoMaxHeap(1);
		maxHeap.insertIntoMaxHeap(4);
		maxHeap.insertIntoMaxHeap(3);
		
		maxHeap.deleteFromMaxHeap();
		maxHeap.deleteFromMaxHeap();
		maxHeap.deleteFromMaxHeap();
		maxHeap.deleteFromMaxHeap();
		maxHeap.deleteFromMaxHeap();
		maxHeap.deleteFromMaxHeap();
		maxHeap.deleteFromMaxHeap();
		
		maxHeap.levelOrderTraversal();
	}
}
class MaxHeapConstruction
{
	Integer heap[];
	int sizeOfHeap;
	HeapifyBottomToTop bt;
	HeapifyTopToBottom tb;
	
	public MaxHeapConstruction(int size) {
		heap = new Integer[size+1];
		bt = new HeapifyBottomToTop();
		tb = new HeapifyTopToBottom();
	}
	
	public void insertIntoMaxHeap(int value) {
		
		if(!isFull())
		{
			heap[sizeOfHeap+1] = value;
			sizeOfHeap++;
			bt.heapifyMaxHeap(heap, sizeOfHeap);
		}
		else
		{
			System.out.println("\nHeap is full");
			return;
		}
	}
	
	public void deleteFromMaxHeap() {
		
		if(!isEmpty())
		{
			
			int temp = heap[1];
			System.out.println("\nRemoved "+temp+" from the max heap.");
			heap[1] = heap[sizeOfHeap];
			sizeOfHeap--;
			
			tb.heapifyMaxHeap(heap, 1, sizeOfHeap);
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
		for (int i = 1; i < sizeOfHeap; i++) {
			System.out.print(heap[i]+" ");
		}
	}
}