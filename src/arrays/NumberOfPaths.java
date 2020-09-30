package arrays;

public class NumberOfPaths {

	public static void main(String[] args) {
		
		int[][] array = {{4,3,7,5},{9,4,6,8},{7,3,1,8},{10,6,4,2}};
		
		int numberOfPathsRecussive = NumberOfPathsToReachGivenCell.getNumberOfPaths(array.length-1, array.length-1, array);
		int numberOfPathsIterative = NumberOfPathsToReachGivenCell.getNumberOfPaths(array);
		System.out.println(numberOfPathsIterative);
		System.out.println(numberOfPathsRecussive);
	}

}
class NumberOfPathsToReachGivenCell
{
	public static int getNumberOfPaths(int array[][]) {

		int temp[][] = new int[array.length][array.length];
		
		for (int i = 1; i < temp.length; i++)
			temp[0][i] = 1;
		
		for (int i = 1; i < temp.length; i++)
			temp[i][0] = 1;
		
		temp[0][0] = 0;
		
		for (int i = 1; i < temp.length; i++) {
			
			for (int j = 1; j < temp.length; j++)
				temp[i][j] = temp[i-1][j] + temp[i][j-1];
		}
		
		return temp[temp.length-1][temp.length-1];
	}
	
	public static int getNumberOfPaths(int i, int j, int array[][]) {
		
		int temp[][] = new int[array.length][array.length];
				
		if(temp[i][j]!=0)
			return temp[i][j];
		
		else
		{
			if(i==0 && j==0)
				return 0;
		
			if(i==0 || j==0)
				return 1;
			
			temp[i][j] = getNumberOfPaths(i, j-1, temp) + getNumberOfPaths(i-1, j, temp);
		
			return temp[i][j];
		}
	}
}