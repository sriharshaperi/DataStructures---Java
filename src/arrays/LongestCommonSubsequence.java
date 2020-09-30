package arrays;

import java.util.Stack;

public class LongestCommonSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] array = {{4,3,7,5},{9,4,6,8},{7,3,1,8},{10,6,4,2}};
		
		String s1 = "harshperi";
		String s2 = "harrypotter";
		
		int lcs = LCS.getLongestCommonSubsequence(s1, s2);
		System.out.println(lcs);
	}

}
class LCS
{
	public static int getLongestCommonSubsequence(String s1, String s2) {
		
		
		int temp[][] = new int[s1.length()][s2.length()];
		
		for (int i = 1; i<s1.length(); i++) {
			
			for (int j = 1; j<s2.length(); j++) {
				
				if(s1.charAt(i)==s2.charAt(j))
					temp[i][j] = 1 + temp[i-1][j-1];
				else
					temp[i][j] = Math.max(temp[i][j-1], temp[i-1][j]);
			}
		}
		getLCS(temp, s1, s2);		
		System.out.println("\n");
		
		return temp[s1.length()-1][s2.length()-1];
	}
	
	public static void getLCS(int array[][], String s1, String s2) {
		
		Stack<Character> charStack = new Stack<>();
		
		int i = s1.length()-1, j = s2.length()-1;
		
		while (array[i][j]!=0) {
			
			if(array[i][j]>array[i][j-1])
			{
				charStack.push(s2.charAt(j));
				i--;
				j--;
			}
			else
				j--;
		}
		
		while (!charStack.isEmpty())
			System.out.print(charStack.pop()+" ");
	}
}