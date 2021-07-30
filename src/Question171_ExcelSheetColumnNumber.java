/**
 * 171. Excel 表列序号
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回该列名称对应的列序号。
 * <p>
 * 例如，
 * A -> 1
 * B -> 2
 * C -> 3
 * ...
 * Z -> 26
 * AA -> 27
 * AB -> 28
 * ...
 * <p>
 * 示例 1:
 * 输入: columnTitle = "A"
 * 输出: 1
 * <p>
 * 示例 2:
 * 输入: columnTitle = "AB"
 * 输出: 28
 * <p>
 * 示例 3:
 * 输入: columnTitle = "ZY"
 * 输出: 701
 * <p>
 * 示例 4:
 * 输入: columnTitle = "FXSHRXW"
 * 输出: 2147483647
 */

public class Question171_ExcelSheetColumnNumber {
	public static void main(String[] args) {

	}
}

class Solution171 {
	public int titleToNumber(String columnTitle) {
		int column = 0;
		for(int i = 0; i < columnTitle.length(); i++) {
			char c = columnTitle.charAt(i);
			column += (c - 'A' + 1) * Math.pow(26, columnTitle.length() - i - 1);
		}
		return column;
	}
}
