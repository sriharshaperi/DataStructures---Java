package sorting;

public class MergeSort {

	public static void main(String[] args) {
		
		int unsorted[] = {5,7,8,9,3,1,6,4,2,0};
		int sorted[] = Merge.mergesort(unsorted);
		
		System.out.println("Elements of the sorted array are : \n");
		for (int i : sorted)
			System.out.print(i+" ");
	}

}
class Merge
{
	public static int[] mergesort(int array[]) {
		
		if(array.length<=1)
			return array;
		
		int mid = array.length/2;
		
		int leftArray[] = new int[mid];
		int rightArray[] = array.length%2==0 ? new int[mid] : new int[mid+1];
		
		for (int i = 0; i < leftArray.length; i++)
			leftArray[i] = array[i];
		
		for (int i = 0; i < rightArray.length; i++)
			rightArray[i] = array[mid+i];
		
		int left[] = mergesort(leftArray);
		int right[] = mergesort(rightArray);
		
		int result[] = merge(left, right);
		
		return result;
	}
	
	private static int[] merge(int left[], int right[]) {
		
		int result[] = new int[left.length + right.length];
		int leftPointer = 0, rightPointer = 0, resultPointer = 0;
		
		while (leftPointer < left.length || rightPointer < right.length) 
		{
			if(leftPointer < left.length && rightPointer < right.length)
			{
				if(left[leftPointer] < right[rightPointer])
					result[resultPointer++] = left[leftPointer++];
				else
					result[resultPointer++] = right[rightPointer++];
			}
			else if(leftPointer < left.length)
				result[resultPointer++] = left[leftPointer++];
			
			else if(rightPointer < right.length)
				result[resultPointer++] = right[rightPointer++];
		}
		
		return result;
	}
}