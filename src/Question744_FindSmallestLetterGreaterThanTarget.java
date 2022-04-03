/**
 * 744. 寻找比目标字母大的最小字母
 * 给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
 * <p>
 * 在比较时，字母是依序循环出现的。举个例子：
 * <p>
 * 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a'
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入: letters = ["c", "f", "j"]，target = "a"
 * 输出: "c"
 * 示例 2:
 * <p>
 * 输入: letters = ["c","f","j"], target = "c"
 * 输出: "f"
 * 示例 3:
 * <p>
 * 输入: letters = ["c","f","j"], target = "d"
 * 输出: "f"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= letters.length <= 104
 * letters[i] 是一个小写字母
 * letters 按非递减顺序排序
 * letters 最少包含两个不同的字母
 * target 是一个小写字母
 */

public class Question744_FindSmallestLetterGreaterThanTarget {
	public static void main(String[] args) {

	}
}

class Solution744 {
	public char nextGreatestLetter(char[] letters, char target) {
		if(target >= letters[letters.length - 1]) {
		    return letters[0];
		}

		int left = 0;
		int right = letters.length - 1;
		while(left <= right) {
		    int mid = (left + right) / 2;
			if(letters[mid] <= target) {
			    left = mid + 1;
			} else if(letters[mid] > target) {
			    right = mid - 1;
			}
		}

		return letters[left];
	}
}