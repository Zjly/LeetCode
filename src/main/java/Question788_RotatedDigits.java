import java.util.ArrayList;

/**
 * 788. 旋转数字
 * 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
 * <p>
 * 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
 * <p>
 * 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入: 10
 * 输出: 4
 * 解释:
 * 在[1, 10]中有四个好数： 2, 5, 6, 9。
 * 注意 1 和 10 不是好数, 因为他们在旋转之后不变。
 * <p>
 * <p>
 * 提示：
 * <p>
 * N 的取值范围是 [1, 10000]。
 */

public class Question788_RotatedDigits {
	public static void main(String[] args) {
		Solution788 solution788 = new Solution788();
		int n = 7842;
		System.out.println(solution788.rotatedDigits(n));
	}
}

class Solution788 {
	public int rotatedDigits(int n) {
		int count = 0;
		boolean[] rotate = {true, true, true, false, false, true, true, false, true, true};
		boolean[] notSame = {false, false, true, false, false, true, true, false, false, true};

		if(n < 10) {
			for(int i = 1; i <= n; i++) {
				if(notSame[i]) {
					count++;
				}
			}

			return count;
		}

		ArrayList<Integer> nums = new ArrayList<>();
		int p = n;
		while(p != 0) {
			nums.add(p % 10);
			p /= 10;
		}

		int[] rotateCount = new int[nums.size() - 1];
		int[] notSameCount = new int[nums.size() - 1];
		rotateCount[0] = 7;
		notSameCount[0] = 4;

		for(int i = 1; i < rotateCount.length; i++) {
			rotateCount[i] = rotateCount[i - 1];
			notSameCount[i] = notSameCount[i - 1];

			for(int j = 1; j <= 9; j++) {
				if(rotate[j]) {
					if(notSame[j]) {
						notSameCount[i] += rotateCount[i - 1];
					} else {
						notSameCount[i] += notSameCount[i - 1];
					}

					rotateCount[i] += rotateCount[i - 1];
				}
			}
		}

		for(int i = 0; i < nums.size(); i++) {
			int num = nums.get(i);
			boolean rotateOthers = true;
			boolean notSameOthers = false;
			for(int j = i + 1; j < nums.size(); j++) {
				rotateOthers = rotateOthers && rotate[nums.get(j)];
				notSameOthers = notSameOthers || notSame[nums.get(j)];
			}

			if(i == 0) {
				for(int j = 0; j <= num; j++) {
					if(rotateOthers && rotate[j] && (notSameOthers || notSame[j])) {
						count += 1;
					}
				}
			} else {
				for(int j = 0; j <= num - 1; j++) {
					if(rotateOthers && rotate[j]) {
						if(notSameOthers || notSame[j]) {
						    count += rotateCount[i - 1];
						} else {
							count += notSameCount[i - 1];
						}
					}
				}
			}
		}

		return count;
	}
}
