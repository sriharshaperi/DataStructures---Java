package arrays;

public class TwoDArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{4,3,7,5},{9,4,6,8},{7,3,1,8},{10,6,4,2}};
		int minCost = MinimumCost.getminimumCost(array);
		System.out.println(minCost);
	}

}
class MinimumCost
{
	public static int getminimumCost(int[][] array) {
		
		int[][] temp = new int[array.length][array.length];
		
		temp[0][0] = array[0][0];
		
		for (int i = 1; i < temp.length; i++) {
			temp[0][i] = temp[0][i-1] + array[0][i];
		}
		
		for (int i = 1; i < temp.length; i++) {
			temp[i][0] = temp[i-1][0] + array[i][0];		
		}
		
		for (int i = 1; i < temp.length; i++) {
			for (int j = 1; j < temp.length; j++)
				temp[i][j] = array[i][j] + Math.min(temp[i][j-1], temp[i-1][j]);
		}
		getPath(temp);
		printArray(temp);
		
		return temp[temp.length-1][temp.length-1];
	}
	
	private static void getPath(int[][] array) {
		
		int i = array.length-1, j = array.length-1;
		
		System.out.println("\n");
		System.out.print(array[i][j]+" ");
		while (i>=1 && j>=1) {
			
			if(Math.min(array[i][j-1], array[i-1][j])==array[i][j-1])
			{
				System.out.print(array[i][j-1]+" ");
				j--;
			}
			else
			{
				System.out.print(array[i-1][j]+" ");
				i--;
			}
		}
		System.out.print(array[0][0]);
		System.out.println("\n");
	}
	
	private static void printArray(int array[][]){
		
		for (int i = 0; i < array.length; i++) {
			
			for (int j = 0; j < array.length; j++)
				System.out.print(array[i][j]+" ");
			System.out.println();
		}
		System.out.println("\n");
	}
}