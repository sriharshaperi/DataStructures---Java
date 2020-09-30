package arrays;

import java.util.Stack;

public class LongestCommonSubstring {

	public static void main(String[] args) {
		
		String s1 = "harshperi";
		String s2 = "harryPotter";
		
		int lcs = Substring.getLongestCommonSubstring(s1, s2);
		System.out.println(lcs);
	}
}
class Substring
{
	public static int getLongestCommonSubstring(String s1, String s2) {
		
		int temp[][] = new int[s1.length()][s2.length()];
		
		for (int i = 0; i < s1.length(); i++) {
			
			 for (int j = 0; j < s2.length(); j++) {
				
				if(i==0 || j==0)
				{
					if(s1.charAt(i)==s2.charAt(j))
						temp[i][j] = 1;
				}
				else
				{
					if(s1.charAt(i)==s2.charAt(j))
						temp[i][j] = 1 + temp[i-1][j-1];
					else
						temp[i][j] = 0;
				}
			}
		}
		
		int maxLength = temp[s1.length()-1][s2.length()-1];
		
		 for (int i = s1.length()-1; i>=0; i--) {
			
			for (int j = s2.length()-1; j>=0; j--) {
				
				if(temp[i][j]>maxLength)
					maxLength = temp[i][j];
			}
		}
		 
		 getSubstring(temp, s1, s2, maxLength);
		 System.out.println("\n");
		
		return maxLength;
	}
	
	private static void getSubstring(int array[][], String s1, String s2, int maxlength) {
		
		Stack<Character> charStack = new Stack<>();
		
		int index1 = 0, index2 = 0;
		
		for (int k = 0; k < array.length; k++) {
			
			for (int l = 0; l < array.length; l++) {
				
				if(array[k][l]==maxlength)
					index1 = k;
					index2 = l;
			}
		}
		
		int i = index1, j = index2;
		
		while (i>=0 && j>=0) {
			
			charStack.push(s1.charAt(i));
			i--;
			j--;
		}
		
		while (!charStack.isEmpty())
			System.out.print(charStack.pop()+" ");
	}
}