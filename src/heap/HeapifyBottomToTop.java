package heap;

public class HeapifyBottomToTop {

	public void heapifyMinHeap(Integer heap[], int index) {
		
		int parent = index/2;
		
		if(index<=1)
			return;
		else
		{
			if(heap[parent] > heap[index])
			{
				int temp = heap[parent];
				heap[parent] = heap[index];
				heap[index] = temp;
			}
			heapifyMinHeap(heap, parent);
		}
	}
	
	public void heapifyMaxHeap(Integer heap[], int index) {
		
		int parent = index/2;
		
		if(index<=1)
			return;
		else
		{
			if(heap[parent] < heap[index])
			{
				int temp = heap[parent];
				heap[parent] = heap[index];
				heap[index] = temp;
			}
			heapifyMaxHeap(heap, parent);
		}
	}
}