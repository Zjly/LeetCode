public class Question1128_NumberOfEquivalentDominoPairs {
	public static void main(String[] args) {

	}
}

class Solution1128 {
	public int numEquivDominoPairs(int[][] dominoes) {
		int result = 0;
		int[][] nums = new int[9][9];

		for(int[] domino : dominoes) {
			int a = domino[0];
			int b = domino[1];
			int p;

			if(a > b) {
			    p = a;
			    a = b;
			    b = p;
			}
			result += nums[a - 1][b - 1];
			nums[a - 1][b - 1]++;
		}
		return result;
	}
}
