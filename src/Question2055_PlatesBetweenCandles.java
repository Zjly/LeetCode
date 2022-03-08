import java.util.ArrayList;
import java.util.Arrays;

/**
 * 2055. 蜡烛之间的盘子
 * 给你一个长桌子，桌子上盘子和蜡烛排成一列。给你一个下标从 0 开始的字符串 s ，它只包含字符 '*' 和 '|' ，其中 '*' 表示一个 盘子 ，'|' 表示一支 蜡烛 。
 * <p>
 * 同时给你一个下标从 0 开始的二维整数数组 queries ，其中 queries[i] = [lefti, righti] 表示 子字符串 s[lefti...righti] （包含左右端点的字符）。对于每个查询，你需要找到 子字符串中 在 两支蜡烛之间 的盘子的 数目 。如果一个盘子在 子字符串中 左边和右边 都 至少有一支蜡烛，那么这个盘子满足在 两支蜡烛之间 。
 * <p>
 * 比方说，s = "||**||**|*" ，查询 [3, 8] ，表示的是子字符串 "*||**|" 。子字符串中在两支蜡烛之间的盘子数目为 2 ，子字符串中右边两个盘子在它们左边和右边 都 至少有一支蜡烛。
 * 请你返回一个整数数组 answer ，其中 answer[i] 是第 i 个查询的答案。
 * <p>
 * <p>
 * <p>
 * 示例 1:
 * <p>
 * ex-1
 * <p>
 * 输入：s = "**|**|***|", queries = [[2,5],[5,9]]
 * 输出：[2,3]
 * 解释：
 * - queries[0] 有两个盘子在蜡烛之间。
 * - queries[1] 有三个盘子在蜡烛之间。
 * 示例 2:
 * <p>
 * ex-2
 * <p>
 * 输入：s = "***|**|*****|**||**|*", queries = [[1,17],[4,5],[14,17],[5,11],[15,16]]
 * 输出：[9,0,0,0,0]
 * 解释：
 * - queries[0] 有 9 个盘子在蜡烛之间。
 * - 另一个查询没有盘子在蜡烛之间。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 3 <= s.length <= 105
 * s 只包含字符 '*' 和 '|' 。
 * 1 <= queries.length <= 105
 * queries[i].length == 2
 * 0 <= lefti <= righti < s.length
 */

public class Question2055_PlatesBetweenCandles {
	public static void main(String[] args) {
		Solution2055 solution2055 = new Solution2055();
		String s = "**|*******************|**********************************************|************|*********|*****|*********************************************************************************************|***";
		int[][] queries = {{31, 96}, {14, 192}, {0, 180}, {13, 193}, {12, 192}, {11, 183}, {12, 189}, {65, 116}, {55, 160}, {100, 164}, {6, 183}, {4, 182}, {15, 183}, {0, 194}, {37, 63}, {10, 184}, {0, 183}, {5, 184}, {8, 185}, {13, 136}, {6, 192}, {5, 189}, {13, 183}, {8, 184}, {15, 188}, {0, 184}, {9, 191}, {4, 193}, {61, 83}, {1, 193}, {10, 194}, {15, 192}, {13, 184}, {2, 185}, {11, 190}, {11, 195}, {14, 188}, {12, 188}, {94, 116}, {3, 184}, {0, 189}, {4, 185}, {12, 193}, {3, 185}, {1, 181}, {6, 194}, {0, 185}, {10, 193}, {5, 187}, {10, 185}, {12, 182}, {23, 80}, {10, 191}, {10, 195}, {13, 189}, {6, 193}, {5, 183}, {2, 182}, {14, 181}, {3, 187}, {9, 187}, {4, 180}, {5, 190}, {4, 181}, {7, 184}, {3, 135}, {6, 189}, {14, 186}, {5, 195}, {11, 186}, {8, 186}, {30, 159}, {11, 192}, {61, 80}, {3, 181}, {5, 192}, {10, 187}, {2, 25}, {9, 194}, {43, 118}, {2, 189}, {8, 180}, {15, 193}, {13, 181}, {14, 182}, {105, 133}, {8, 195}, {0, 193}, {13, 192}, {3, 186}, {1, 189}, {24, 124}, {0, 181}, {136, 158}, {11, 193}, {14, 180}, {11, 180}, {54, 149}, {8, 191}, {11, 188}, {4, 188}, {2, 181}, {5, 188}, {11, 181}, {43, 175}, {12, 183}, {0, 186}, {6, 188}, {0, 191}, {15, 186}, {8, 187}, {7, 74}, {3, 180}, {27, 149}, {73, 153}, {52, 145}, {9, 188}, {7, 195}, {14, 193}, {77, 160}, {0, 187}, {10, 188}, {4, 187}, {62, 160}, {13, 190}, {12, 190}, {5, 191}, {14, 184}, {9, 186}, {7, 189}, {131, 148}, {9, 189}, {159, 179}, {20, 174}, {13, 180}, {4, 184}, {0, 192}, {2, 190}, {0, 195}, {10, 180}, {9, 182}, {9, 181}, {11, 194}, {12, 194}, {5, 185}, {3, 189}, {118, 160}, {5, 181}, {14, 122}, {25, 63}, {11, 189}, {3, 193}, {31, 176}, {58, 148}, {9, 183}, {11, 184}, {35, 181}, {12, 186}, {14, 190}, {8, 190}, {15, 194}, {1, 195}, {4, 194}, {2, 180}, {9, 190}, {3, 182}, {15, 181}, {13, 194}, {6, 182}, {42, 117}, {4, 186}, {13, 187}, {25, 103}, {6, 184}, {5, 180}, {21, 180}, {1, 187}, {15, 189}, {6, 180}, {44, 160}, {8, 182}, {15, 180}, {10, 182}, {1, 180}, {7, 185}, {8, 193}};
		System.out.println(Arrays.toString(solution2055.platesBetweenCandles(s, queries)));
	}
}

class Solution2055 {
	public int[] platesBetweenCandles(String s, int[][] queries) {
		int[] result = new int[queries.length];
		ArrayList<int[]> candlesLocation = new ArrayList<>();
		ArrayList<Integer> dp = new ArrayList<>();
		dp.add(0);

		int index = 0;
		while(index < s.length() - 1) {
			if(s.charAt(index) == '|' && s.charAt(index + 1) == '*') {
				int begin = index;
				int end = index + 1;
				while(end < s.length() && s.charAt(end) == '*') {
					end++;
				}

				if(end != s.length()) {
					candlesLocation.add(new int[]{begin, end});
					dp.add(dp.get(dp.size() - 1) + end - begin - 1);
				}

				index = end;
			} else {
				index++;
			}
		}

		for(int i = 0; i < result.length; i++) {
			int leftBound = queries[i][0];
			int rightBound = queries[i][1];

			int leftIndex;
			int rightIndex;

			{
				int left = 0;
				int right = candlesLocation.size() - 1;
				int mid;

				while(left <= right) {
					mid = (left + right) / 2;
					int midNum = candlesLocation.get(mid)[0];
					if(midNum < leftBound) {
						left = mid + 1;
					} else {
						right = mid - 1;
					}
				}

				leftIndex = left;
			}

			{
				int left = 0;
				int right = candlesLocation.size() - 1;
				int mid;

				while(left <= right) {
					mid = (left + right) / 2;
					int midNum = candlesLocation.get(mid)[1];
					if(midNum > rightBound) {
						right = mid - 1;
					} else {
						left = mid + 1;
					}
				}

				rightIndex = right;
			}

			if(leftIndex <= rightIndex && leftIndex >= 0 && candlesLocation.get(leftIndex)[1] <= rightBound && rightIndex <= candlesLocation.size() - 1 && candlesLocation.get(rightIndex)[0] >= leftBound) {
				result[i] = dp.get(rightIndex + 1) - dp.get(leftIndex);
			}
		}

		return result;
	}
}