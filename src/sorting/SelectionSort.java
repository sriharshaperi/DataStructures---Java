package sorting;

public class SelectionSort {

	public static void main(String[] args) {
		
		int unsorted[] = {6,4,7,9,2,1,8,3,5,0};
		int sorted[] = Selection.getSortedArray(unsorted);
		
		System.out.println("Elements of the sorted array are : \n");
		for (int i : sorted)
			System.out.print(i+" ");
		

	}

}
class Selection
{
	public static int[] getSortedArray(int array[]) {
		
		for (int i = 0; i < array.length; i++) {
			
			int min = array[i];
			
			for (int j = i+1; j < array.length; j++) {
				
				if(array[j]<array[i])
				{
					int temp = array[j];
					array[j] = array[i];
					array[i] = temp;
				}
			}
		}
		
		return array;
	}
}