package heap;

public class HeapifyTopToBottom {

	public void heapifyMinHeap(Integer heap[], int index, int sizeOfHeap) {
		
		int left = 2*index;
		int right = 2*index+1;
		int smallestChild = 0;
		
		if(sizeOfHeap < left)
			return;
		
		else if(sizeOfHeap==left)
		{
			if(heap[index] > heap[left])
			{
				int temp = heap[index];
				heap[index] = heap[left];
				heap[left] = temp;
			}
			return;
		}
		else
		{
			if(heap[left] < heap[right])
				smallestChild = left;
			else
				smallestChild = right;
			
			if(heap[index] > heap[smallestChild])
			{
				int temp = heap[smallestChild];
				heap[smallestChild] = heap[index];
				heap[index] = temp;
			}
			
			heapifyMinHeap(heap, smallestChild, sizeOfHeap);
		}
	}
	
	public void heapifyMaxHeap(Integer heap[], int index, int sizeOfHeap) {
	
		int left = 2*index;
		int right = 2*index+1;
		int largestChild = 0;
		
		if(sizeOfHeap < left)
			return;
		
		else if(sizeOfHeap==left)
		{
			if(heap[index] < heap[left])
			{
				int temp = heap[index];
				heap[index] = heap[left];
				heap[left] = temp;
			}
			return;
		}
		else
		{
			if(heap[left] > heap[right])
				largestChild = left;
			else
				largestChild = right;
			
			if(heap[index] < heap[largestChild])
			{
				int temp = heap[largestChild];
				heap[largestChild] = heap[index];
				heap[index] = temp;
			}
			
			heapifyMaxHeap(heap, largestChild, sizeOfHeap);
		}
	}
}
