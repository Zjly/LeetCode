import java.util.ArrayList;
import java.util.List;

public class Question438_FindAllAnagramsInAString {
	public static void main(String[] args) {
		Solution438 solution438 = new Solution438();
		String s = "abab";
		String p = "ab";
		System.out.println(solution438.findAnagrams(s, p));
	}
}

class Solution438 {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		int[] count = new int[26];
		
		if(s.length() < p.length()) {
		    return result;
		}

		for(int i = 0; i < p.length(); i++) {
			count[p.charAt(i) - 'a']++;
		}

		int index = 0;
		for(; index < p.length(); index++) {
			count[s.charAt(index) - 'a']--;
		}

		boolean zeroCount = true;
		for(int i = 0; i < 26; i++) {
			if(count[i] != 0) {
			    zeroCount = false;
				break;
			}
		}
		if(zeroCount) {
			result.add(0);
		}
		
		while(index < s.length()) {
			count[s.charAt(index - p.length()) - 'a']++;
			count[s.charAt(index) - 'a']--;

			zeroCount = true;
			for(int i = 0; i < 26; i++) {
				if(count[i] != 0) {
					zeroCount = false;
					break;
				}
			}
			if(zeroCount) {
				result.add(index - p.length() + 1);
			}

			index++;
		}

		return result;
	}
}