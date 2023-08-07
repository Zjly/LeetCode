import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

public class Question264_UglyNumberII {
	public static void main(String[] args) {
		int n = 11;
		Solution264 solution264 = new Solution264();
		System.out.println(solution264.nthUglyNumber(n));
	}
}

class Solution264 {
	public int nthUglyNumber(int n) {
		HashSet<Long> hashSet = new HashSet<>();
		PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
		hashSet.add(1L);
		priorityQueue.offer(1L);
		long p = 0;
		for(int i = 0; i < n; i++) {
			p = priorityQueue.poll();
			if(!hashSet.contains(p * 2)) {
				priorityQueue.offer(p * 2);
				hashSet.add(p * 2);
			}
			if(!hashSet.contains(p * 3)) {
				priorityQueue.offer(p * 3);
				hashSet.add(p * 3);
			}
			if(!hashSet.contains(p * 5)) {
				priorityQueue.offer(p * 5);
				hashSet.add(p * 5);
			}
		}

		return (int)p;
	}
}
