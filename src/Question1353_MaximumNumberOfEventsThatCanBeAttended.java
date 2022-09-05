import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 1353. 最多可以参加的会议数目
 * 给你一个数组 events，其中 events[i] = [startDayi, endDayi] ，表示会议 i 开始于 startDayi ，结束于 endDayi 。
 * <p>
 * 你可以在满足 startDayi <= d <= endDayi 中的任意一天 d 参加会议 i 。注意，一天只能参加一个会议。
 * <p>
 * 请你返回你可以参加的 最大 会议数目。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * <p>
 * 输入：events = [[1,2],[2,3],[3,4]]
 * 输出：3
 * 解释：你可以参加所有的三个会议。
 * 安排会议的一种方案如上图。
 * 第 1 天参加第一个会议。
 * 第 2 天参加第二个会议。
 * 第 3 天参加第三个会议。
 * 示例 2：
 * <p>
 * 输入：events= [[1,2],[2,3],[3,4],[1,2]]
 * 输出：4
 * <p>
 * <p>
 * 提示：​​​​​​
 * <p>
 * 1 <= events.length <= 105
 * events[i].length == 2
 * 1 <= startDayi <= endDayi <= 105
 */

public class Question1353_MaximumNumberOfEventsThatCanBeAttended {
	public static void main(String[] args) {

	}
}

class Solution1353 {
	public int maxEvents(int[][] events) {
		Arrays.sort(events, (a, b) -> {
			if(a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		int currentDay = events[0][0];
		int eventsCount = 0;
		int index = 0;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

		while(index < events.length || !priorityQueue.isEmpty()) {
		    while(index < events.length && events[index][0] == currentDay) {
		        priorityQueue.offer(events[index][1]);
				index++;
		    }

			while(!priorityQueue.isEmpty() && priorityQueue.peek() < currentDay) {
				priorityQueue.poll();
			}
			
			if(!priorityQueue.isEmpty()) {
			    priorityQueue.poll();
				eventsCount++;
			}

			currentDay++;
		}

		return eventsCount;
	}
}
