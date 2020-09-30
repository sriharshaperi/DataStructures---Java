package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LongestSubstringWithoutRepetition {

	public static void main(String[] args) {
		
		StringBuffer s = new StringBuffer("gjhsdgcbjhjjbsddjvfdjsdf");
		int len = LSWR.getLCWRLength(s);
		System.out.println(len);
	}
}
class LSWR
{
	public static int getLCWRLength(StringBuffer s) {
		
		Set<Character> charSet = new HashSet<Character>();
		List<StringBuffer> subStrings = new ArrayList<StringBuffer>();
		
		for (int i = 0; i < s.length(); i++) {
			
			StringBuffer sb = new StringBuffer();
			
			for (int j = i; j < s.length(); j++) {
				
				if(!charSet.contains(s.charAt(j)))
				{
					charSet.add(s.charAt(j));
					sb.append(s.charAt(j));
				}
				else
					break;
			}
			subStrings.add(sb);
			charSet.clear();
			sb = null;
		}
		
		Comparator<StringBuffer> comparator = new Comparator<StringBuffer>() {
			
			@Override
			public int compare(StringBuffer o1, StringBuffer o2) {
				
				if(o1.length()<o2.length())
					return 1;
				else
					return -1;
			}
		};
		
		Collections.sort(subStrings, comparator);
		getSubstring(subStrings.get(0));
		
		return subStrings.get(0).length();	
	}
	
	private static StringBuffer getSubstring(StringBuffer s) {
		System.out.println(s+"\n");
		return s;
	}
}