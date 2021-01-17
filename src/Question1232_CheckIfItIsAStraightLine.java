public class Question1232_CheckIfItIsAStraightLine {
	public static void main(String[] args) {
		int[][] coordinates = new int[][]{{-4,-3},{1,0},{3,-1},{0,-1},{-5,2}};
		Solution1232 solution1232 = new Solution1232();
		System.out.println(solution1232.checkStraightLine(coordinates));
	}
}

class Solution1232 {
	public boolean checkStraightLine(int[][] coordinates) {
		double k = 0;
		boolean isZero = false;

		for(int i = 0; i < coordinates.length - 1; i++) {
			int X1 = coordinates[i][0];
			int Y1 = coordinates[i][1];

			int X2 = coordinates[i + 1][0];
			int Y2 = coordinates[i + 1][1];

			double deltaX = X2 - X1;
			double deltaY = Y2 - Y1;

			if(isZero) {
				if(deltaX == 0) {
					continue;
				}
				return false;
			}

			if(deltaX == 0) {
				if(i != 0) {
					return false;
				}
				isZero = true;
			} else {
				double p = deltaY / deltaX;
				if(k != p && i != 0) {
					return false;
				}
				if(i == 0) {
					k = p;
				}
			}
		}
		return true;
	}
}
