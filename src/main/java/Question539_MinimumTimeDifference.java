/*
539. 最小时间差
给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。

 

示例 1：

输入：timePoints = ["23:59","00:00"]
输出：1
示例 2：

输入：timePoints = ["00:00","23:59","00:00"]
输出：0
 

提示：

2 <= timePoints.length <= 2 * 104
timePoints[i] 格式为 "HH:MM"
 */

import java.util.ArrayList;
import java.util.List;

public class Question539_MinimumTimeDifference {
	public static void main(String[] args) {
		Solution539 solution539 = new Solution539();
		ArrayList<String> arrayList = new ArrayList<>();
		arrayList.add("00:00");
		arrayList.add("23:59");
		arrayList.add("00:00");
		System.out.println(solution539.findMinDifference(arrayList));
	}
}

class Solution539 {
	public int findMinDifference(List<String> timePoints) {
		boolean[] times = new boolean[1440];

		for(String time : timePoints) {
			String[] s = time.split(":");
			int hour = Integer.parseInt(s[0]);
			int minute = Integer.parseInt(s[1]);
			if(!times[hour * 60 + minute]) {
				times[hour * 60 + minute] = true;
			} else {
			    return 0;
			}
		}

		int first = -1;
		int last = -1;
		int pre = -100000;
		int minDifference = Integer.MAX_VALUE;
		for(int i = 0; i < times.length; i++) {
			if(times[i]) {
				if(first == -1) {
					first = i;
				}
				last = i;
				minDifference = Math.min(minDifference, i - pre);
				pre = i;
			}
		}

		minDifference = Math.min(minDifference, first + 1440 - last);
		return minDifference;
	}
}