package arrays;

import java.util.Stack;

public class LongestPalindromicSubsequence {

	public static void main(String[] args) {
		
		String s = "harshpera";
		int lps = LPS.getLPSLength(s);
		System.out.println(lps);
	}

}
class LPS
{
	public static int getLPSLength(String s) {
		
		int temp[][] = new int[s.length()][s.length()];
		
		for (int i = 0; i < temp.length; i++)
			temp[i][i] = 1;
		
		for (int i = 0; i < temp.length-1; i++)
			temp[i][i+1] = 1;
		
		for (int len = 2; len < temp.length; len++) {
			
		B:	for (int j = 0; j < temp.length; j++) {
				
				if(len+j<temp.length)
				{
					if(s.charAt(j)==s.charAt(len+j))
						temp[j][len+j] = 2 + temp[j+1][(len+j)-1];
					else
						temp[j][len+j] = Math.max(temp[j][(len+j)-1], temp[j+1][len+j]);
				}
				else
				 break B;
			}
		}
		
		getLPS(temp, s);
		System.out.println("\n");
		
		return temp[0][s.length()-1];
	}
	
	private static void getLPS(int array[][], String s) {
		
		Stack<Character> charStack = new Stack<>();
		
		int i = 0, j = array.length-1;
		
		while (array[i][j]!=array[i+1][j-1]) {
			
			if(array[i][j]>array[i+1][j])
			{
				System.out.print(s.charAt(i)+" ");
				
				if(array[i+1][j-1]!=0)
					charStack.push(s.charAt(j));
				i++;
				j--;
			}
			else
				i++;
		}
		
		while (!charStack.isEmpty())
			System.out.print(charStack.pop()+" ");
	}
}