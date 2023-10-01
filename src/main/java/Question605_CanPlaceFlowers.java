/**
 * 605. 种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * <p>
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 * <p>
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 * <p>
 * 示例 2:
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * <p>
 * 注意:
 * 数组内已种好的花不会违反种植规则。
 * 输入的数组长度范围为 [1, 20000]。
 * n 是非负整数，且不会超过输入数组的大小。
 */

public class Question605_CanPlaceFlowers {
	public static void main(String[] args) {
		Solution605 solution605 = new Solution605();
		int[] flowerbed = new int[]{0};
		int n = 1;
		System.out.println(solution605.canPlaceFlowers(flowerbed, n));
	}
}

class Solution605 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int length = flowerbed.length;

		if(n == 0) {
			return true;
		}

		if(n > length / 2 + 1) {
			return false;
		}

		if(length == 1) {
			return flowerbed[0] == 0 && n == 1;
		}

		int lastFlower = -2;
		for(int i = 0; i < length - 1; i++) {
			if(flowerbed[i] == 1) {
				lastFlower = i;
				continue;
			}

			if(flowerbed[i] == 0 && lastFlower != i - 1 && flowerbed[i + 1] != 1) {
				n--;
				lastFlower = i;

				if(n == 0) {
					return true;
				}
			}
		}

		if(lastFlower != length - 2 && flowerbed[length - 1] == 0) {
			return n == 1;
		}

		return false;
	}
}

class Solution605_2 {
	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		int length = flowerbed.length;

		for (int i = 0; i < length; i++) {
			if (flowerbed[i] == 1) {
				continue;
			}

			if (i > 0 && flowerbed[i - 1] == 1) {
				continue;
			}

			if (i < length - 1 && flowerbed[i + 1] == 1) {
				continue;
			}

			flowerbed[i] = 1;
			count++;
		}

		return count >= n;
	}
}