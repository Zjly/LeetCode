/*
168. Excel表列名称
给定一个正整数，返回它在 Excel 表中相对应的列名称。

例如，
    1 -> A
    2 -> B
    3 -> C
    ...
    26 -> Z
    27 -> AA
    28 -> AB
    ...
示例 1:
输入: 1
输出: "A"

示例 2:
输入: 28
输出: "AB"

示例 3:
输入: 701
输出: "ZY"
 */

public class Question168_ExcelSheetColumnTitle {
	public static void main(String[] args) {
		Solution168 solution168 = new Solution168();
		System.out.println(solution168.convertToTitle(701));
	}
}

class Solution168 {
	public String convertToTitle(int columnNumber) {
		StringBuilder stringBuilder = new StringBuilder();
		int p;
		while(columnNumber != 0) {
			p = (columnNumber - 1) % 26 + 1;
			stringBuilder.append((char)(p + 'A' - 1));
			columnNumber = (columnNumber - p) / 26;
		}

		return stringBuilder.reverse().toString();
	}
}