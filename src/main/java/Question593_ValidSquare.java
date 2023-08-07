import java.util.Arrays;

public class Question593_ValidSquare {
	public static void main(String[] args) {

	}
}

class Solution593 {
	public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
		int[] length = new int[6];
		length[0] = distance(p1, p2);
		length[1] = distance(p1, p3);
		length[2] = distance(p1, p4);
		length[3] = distance(p2, p3);
		length[4] = distance(p2, p4);
		length[5] = distance(p3, p4);
		Arrays.sort(length);

		if(length[0] == length[1] && length[1] == length[2] && length[2] == length[3] && length[4] == length[5] && length[0] != 0) {
			return length[0] * length[0] * 4 == length[4] * length[4];
		}

		return false;
	}

	public int distance(int[] p1, int[] p2) {
		return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
	}
}
