package sorting;

public class QuickSort {

	public static void main(String[] args) {
		
		int unsorted[] = {5,6,7,2,1,4,3,9,8,0};
		Quick.getSortedArray(unsorted, 0, unsorted.length-1);
		
		System.out.println("Elements of the sorted array are : \n");
		for (int i : unsorted)
			System.out.print(i+" ");
	}

}
class Quick
{
	private static int partition(int unsorted[], int left, int right) {
		
		int pivot = unsorted[(left+right)/2];
		
		while (left<=right) 
		{
			while (unsorted[left] < pivot)
				left++;
			
			while (unsorted[right] > pivot)
				right--;
			
			if(left<=right)
			{
				int temp = unsorted[left];
				unsorted[left] = unsorted[right];
				unsorted[right] = temp;
				
				left++;
				right--;
			}
		}
		
		return left;
	}
	
	public static void getSortedArray(int unsorted[], int left, int right) {
		
		int index = partition(unsorted, left, right);
		
		if(left<=right)
		{
			if(left < index-1)
				getSortedArray(unsorted, left, index-1);
			
			if(index < right)
				getSortedArray(unsorted, index, right);
		}
	}
}