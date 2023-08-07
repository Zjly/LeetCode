import java.util.ArrayList;
import java.util.List;

public class Question1823_FindTheWinnerOfTheCircularGame {
	public static void main(String[] args) {

	}
}

class Solution1823 {
	public int findTheWinner(int n, int k) {
		List<Integer> list = new ArrayList<>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}

		int p = 0;
		while(list.size() != 1) {
			p = (p + k - 1) % list.size();
			list.remove(p);
		}

		return list.get(0);
	}
}