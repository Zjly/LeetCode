import java.util.HashMap;

public class Question205_IsomorphicStrings {
	public static void main(String[] args) {

	}
}

class Solution205 {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> sTot = new HashMap<>();
		HashMap<Character, Character> tTos = new HashMap<>();

		
		for(int i = 0; i < s.length(); i++) {
			char c1 = s.charAt(i);
			char c2 = t.charAt(i);
			
			if(sTot.containsKey(c1)) {
			    int key = sTot.get(c1);
			    if(c2 != key) {
			        return false;
			    }
			} else {
			    sTot.put(c1, c2);
			}

			if(tTos.containsKey(c2)) {
				int key = tTos.get(c2);
				if(c1 != key) {
					return false;
				}
			} else {
				tTos.put(c2, c1);
			}
		}

		return true;
	}
}