public class Question766_ToeplitzMatrix {
	public static void main(String[] args) {

	}
}

class Solution766 {
	public boolean isToeplitzMatrix(int[][] matrix) {
		int row = matrix.length;
		int column = matrix[0].length;

		for(int i = 0; i < row; i++) {
			int num = matrix[i][0];
			int r = i;
			int c = 0;
			while(r + 1 < row && c + 1 < column) {
				r++;
				c++;
				if(matrix[r][c] != num) {
				    return false;
				}
			}
		}

		for(int i = 1; i < column; i++) {
			int num = matrix[0][i];
			int r = 0;
			int c = i;
			while(r + 1 < row && c + 1 < column) {
				r++;
				c++;
				if(matrix[r][c] != num) {
					return false;
				}
			}
		}

		return true;
	}
}
