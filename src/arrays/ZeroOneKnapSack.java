package arrays;

public class ZeroOneKnapSack {

	public static void main(String[] args) {
		
		int profits[] = {12,40,6,8};
		int weights[] = {1,2,3,4};
		int capacity  = 5;
		int size = weights.length;
		
		int zok = ZOK.getMaxProfit(profits, weights, capacity, size);
		System.out.println(zok);
	}
	
}
class ZOK
{
	public static int getMaxProfit(int profits[], int weights[], int capacity, int size) {
	
		int temp[][] = new int[size+1][capacity+1];
		
		for (int i = 0; i < size+1; i++) {
			
			for (int j = 0; j < capacity+1; j++) {
				
				if(i==0 || j==0)
					temp[i][j] = 0;
				else
					break;
			}
		}
		
		for (int i = 1; i < size+1; i++) {
			
			for (int j = 1; j < capacity+1; j++) {
				
				if(weights[i-1]<=j)
				{
					temp[i][j] = Math.max(profits[i-1] + temp[i-1][j - weights[i-1]], temp[i-1][j]);
				}
				else
					temp[i][j] = temp[i-1][j];
			}
		}
		
		
		for (int i = 0; i < size+1; i++) {
			
			for (int j = 0; j < capacity+1; j++) {
				
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("\n");
		
		return temp[size][capacity];
	}
}