import java.util.ArrayList;

public class Question59_SpiralMatrixII {
	public static void main(String[] args) {

	}
}

class Solution59 {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];

		int distance = 0;
		int num = 1;

		while(num <= n * n) {
			for(int i = distance; i <= n - 1 - distance; i++) {
				result[distance][i] = num;
				num++;
			}

			if(num > n * n) {
				break;
			}

			for(int i = 1 + distance; i <= n - 1 - distance; i++) {
				result[i][n - 1 - distance] = num;
				num++;
			}

			if(num > n * n) {
				break;
			}

			for(int i = n - 2 - distance; i >= distance; i--) {
				result[n - 1 - distance][i] = num;
				num++;
			}

			if(num > n * n) {
				break;
			}

			for(int i = n - 2 - distance; i >= 1 + distance; i--) {
				result[i][distance] = num;
				num++;
			}

			distance++;
		}

		return result;
	}
}
