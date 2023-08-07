/**
 * 273. 整数转换英文表示
 * 将非负整数 num 转换为其对应的英文表示。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：num = 123
 * 输出："One Hundred Twenty Three"
 * 示例 2：
 * <p>
 * 输入：num = 12345
 * 输出："Twelve Thousand Three Hundred Forty Five"
 * 示例 3：
 * <p>
 * 输入：num = 1234567
 * 输出："One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 示例 4：
 * <p>
 * 输入：num = 1234567891
 * 输出："One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= num <= 231 - 1
 */

public class Question273_IntegerToEnglishWords {
	public static void main(String[] args) {
		Solution273 solution273 = new Solution273();
		int num = 1000111000;
		System.out.println(solution273.numberToWords(num));
	}
}

class Solution273 {
	public String numberToWords(int num) {
		if(num == 0) {
		    return "Zero";
		}

		int A = num / 1000000000;
		int B = (num / 1000000) % 1000;
		int C = (num / 1000) % 1000;
		int D = num % 1000;

		StringBuilder stringBuilder = new StringBuilder();
		if(A != 0) {
		    stringBuilder.append(getEnglishWords(A));
			stringBuilder.append(" ");
			stringBuilder.append("Billion");
		}

		if(B != 0) {
		    if(A != 0) {
			    stringBuilder.append(" ");
		    }
			stringBuilder.append(getEnglishWords(B));
			stringBuilder.append(" ");
			stringBuilder.append("Million");
		}

		if(C != 0) {
		    if(A != 0 || B != 0) {
			    stringBuilder.append(" ");
		    }
			stringBuilder.append(getEnglishWords(C));
			stringBuilder.append(" ");
			stringBuilder.append("Thousand");
		}

		if(D != 0) {
			if(A != 0 || B != 0 || C != 0) {
				stringBuilder.append(" ");
			}
			stringBuilder.append(getEnglishWords(D));
		}

		return stringBuilder.toString();
	}

	public String getEnglishWords(int num) {
		int H = num / 100;
		int T = (num / 10) % 10;
		int S = num % 10;
		int TS = num % 100;

		StringBuilder stringBuilder = new StringBuilder();

		// 加入百位数
		if(H != 0) {
			stringBuilder.append(getSNum(H));
			stringBuilder.append(" ");
			stringBuilder.append("Hundred");
		}

		// 加入个十位数
		if(TS != 0) {
			if(H != 0) {
				stringBuilder.append(" ");
			}

			// 在10到19之间
			if(TS >= 10 && TS <= 19) {
				stringBuilder.append(getTSNum(TS));
			} else {
				// 加入十位数
				if(T != 0) {
					stringBuilder.append(getTNum(T * 10));
				}

				if(S != 0) {
					if(T != 0) {
						stringBuilder.append(" ");
					}
					stringBuilder.append(getSNum(S));
				}
			}
		}

		return stringBuilder.toString();
	}

	public String getSNum(int num) {
		switch(num) {
			case 1:
				return "One";
			case 2:
				return "Two";
			case 3:
				return "Three";
			case 4:
				return "Four";
			case 5:
				return "Five";
			case 6:
				return "Six";
			case 7:
				return "Seven";
			case 8:
				return "Eight";
			case 9:
				return "Nine";
			default:
				return "";
		}
	}

	public String getTSNum(int num) {
		switch(num) {
			case 10:
				return "Ten";
			case 11:
				return "Eleven";
			case 12:
				return "Twelve";
			case 13:
				return "Thirteen";
			case 14:
				return "Fourteen";
			case 15:
				return "Fifteen";
			case 16:
				return "Sixteen";
			case 17:
				return "Seventeen";
			case 18:
				return "Eighteen";
			case 19:
				return "Nineteen";
			default:
				return "";
		}
	}

	public String getTNum(int num) {
		switch(num) {
			case 20:
				return "Twenty";
			case 30:
				return "Thirty";
			case 40:
				return "Forty";
			case 50:
				return "Fifty";
			case 60:
				return "Sixty";
			case 70:
				return "Seventy";
			case 80:
				return "Eighty";
			case 90:
				return "Ninety";
			default:
				return "";
		}
	}
}