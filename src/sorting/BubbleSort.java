package sorting;

public class BubbleSort {

	public static void main(String[] args) {
		
		int unsorted[] = {5,6,9,2,1,4,7,3,8,0};
		int sorted[] = Bubble.getSortedArray(unsorted);
		
		System.out.println("Elements of the sorted array are : \n");
		for (int i : sorted)
			System.out.print(i+" ");
	}

}
class Bubble
{
	public static int[] getSortedArray(int unsorted[]) {
		
		for (int i = 0; i < unsorted.length; i++) {
			
			for (int j = 0; j < unsorted.length-i-1; j++) {
				
				if(unsorted[j]>unsorted[j+1])
				{
					int temp = unsorted[j];
					unsorted[j] = unsorted[j+1];
					unsorted[j+1] = temp;
				}
			} 
		}
		
		return unsorted;
	}
}