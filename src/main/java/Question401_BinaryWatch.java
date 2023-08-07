import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 401. 二进制手表
 * 二进制手表顶部有 4 个 LED 代表 小时（0-11），底部的 6 个 LED 代表 分钟（0-59）。每个 LED 代表一个 0 或 1，最低位在右侧。
 * 例如，下面的二进制手表读取 "3:25" 。
 * 给你一个整数 turnedOn ，表示当前亮着的 LED 的数量，返回二进制手表可以表示的所有可能时间。你可以 按任意顺序 返回答案。
 * 小时不会以零开头：
 * 例如，"01:00" 是无效的时间，正确的写法应该是 "1:00" 。
 * 分钟必须由两位数组成，可能会以零开头：
 * 例如，"10:2" 是无效的时间，正确的写法应该是 "10:02" 。
 * <p>
 * 示例 1：
 * 输入：turnedOn = 1
 * 输出：["0:01","0:02","0:04","0:08","0:16","0:32","1:00","2:00","4:00","8:00"]
 * <p>
 * 示例 2：
 * 输入：turnedOn = 9
 * 输出：[]
 * <p>
 * 提示：
 * 0 <= turnedOn <= 10
 */

public class Question401_BinaryWatch {
	public static void main(String[] args) {
		Solution401 solution401 = new Solution401();
		int turnedOn = 7;
		System.out.println(solution401.readBinaryWatch(turnedOn));
	}
}

class Solution401 {
	public List<String> readBinaryWatch(int turnedOn) {
		ArrayList<String> result = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> hashMap = new HashMap<>();
		for(int i = 0; i < 60; i++) {
			int oneCount = Integer.bitCount(i);
			ArrayList<Integer> countArrayList = hashMap.getOrDefault(oneCount, new ArrayList<>());
			countArrayList.add(i);
			hashMap.put(oneCount, countArrayList);
		}

		for(int hour = 0; hour <= turnedOn; hour++) {
			int minute = turnedOn - hour;
			ArrayList<Integer> hourAL = hashMap.getOrDefault(hour, new ArrayList<>());
			ArrayList<Integer> minuteAL = hashMap.getOrDefault(minute, new ArrayList<>());
			for(int hourInteger : hourAL) {
				if(hourInteger > 11) {
					continue;
				}
				String hourS = String.valueOf(hourInteger);
				for(int minuteInteger : minuteAL) {
					String minuteS;
					if(minuteInteger < 10) {
						minuteS = "0" + minuteInteger;
					} else {
						minuteS = String.valueOf(minuteInteger);
					}
					result.add(hourS + ":" + minuteS);
				}
			}
		}

		return result;
	}
}