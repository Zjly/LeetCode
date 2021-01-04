import java.util.LinkedList;
import java.util.List;

public class Question830_PositionsOfLargeGroups {
	public static void main(String[] args) {

	}
}

class Solution830 {
	public List<List<Integer>> largeGroupPositions(String s) {
		LinkedList<List<Integer>> linkedList = new LinkedList<>();
		int begin = -1;
		int length = 1;
		char last = ' ';
		for(int i = 0; i < s.length(); i++) {
			char current = s.charAt(i);
			if(current != last) {
				if(length >= 3) {
					LinkedList<Integer> list = new LinkedList<>();
					list.add(begin);
					list.add(begin + length - 1);
					linkedList.add(list);
				}
				begin = i;
				length = 1;
				last = current;
			} else {
				length++;
			}
		}

		if(length >= 3) {
			LinkedList<Integer> list = new LinkedList<>();
			list.add(begin);
			list.add(begin + length - 1);
			linkedList.add(list);
		}

		return linkedList;
	}
}