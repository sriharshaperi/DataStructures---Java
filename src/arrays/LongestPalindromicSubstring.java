package arrays;

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		
		String s = "malalayam";
		PalindromicSubstring.getLPSLength(s);
	}

}
class PalindromicSubstring
{
	public static void getLPSLength(String s) {
		
		int temp[][] = new int[s.length()][s.length()];
		
		for (int i = 0; i < temp.length; i++)
			temp[i][i] = 1;
		
		for (int i = 0; i < temp.length-1; i++) {
			
			if(s.charAt(i)==s.charAt(i+1))
				temp[i][i+1] = 1;
		}
		
		for (int i = 0; i < temp.length-2; i++)
		{
			if(s.charAt(i)==s.charAt(i+2))
				temp[i][i+2] = 1;
		}
		
		A: for (int i = 3; i < temp.length; i++) {
			
			B: for (int j = 0; j < temp.length; j++) {
				
				if(i+j<temp.length)
				{
					if(s.charAt(j)==s.charAt(j+i) && temp[j+1][(j+i)-1]==1)
						temp[j][j+i] = 1;
					else
						temp[j][j+i] = 0;
				}
				else
					break B;
			}
		}
		
		for (int i = 0; i < temp.length; i++) {
			
			for (int j = 0; j < temp.length; j++) {
				System.out.print(temp[i][j]+" ");
			}
			System.out.println();
		}
	}
}