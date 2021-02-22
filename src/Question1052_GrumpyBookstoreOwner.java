public class Question1052_GrumpyBookstoreOwner {
	public static void main(String[] args) {

	}
}


class Solution1052 {
	public int maxSatisfied(int[] customers, int[] grumpy, int X) {
		int baseSatisfied = 0;
		int addSatisfied = 0;

		for(int i = 0; i < X; i++) {
			if(grumpy[i] == 0) {
			    baseSatisfied += customers[i];
			}
			if(grumpy[i] == 1) {
			    addSatisfied += customers[i];
			}
		}

		int left = 0;
		int right = X;
		int maxAddSatisfied = addSatisfied;

		while(right < customers.length) {
			if(grumpy[right] == 0) {
			    baseSatisfied += customers[right];
			}
			if(grumpy[right] == 1) {
			    addSatisfied += customers[right];
			}
			if(grumpy[left] == 1) {
			    addSatisfied -= customers[left];
			}
			if(addSatisfied > maxAddSatisfied) {
			    maxAddSatisfied = addSatisfied;
			}
			left++;
			right++;
		}

		return maxAddSatisfied + baseSatisfied;
	}
}