import java.util.LinkedList;
import java.util.Queue;

public class Question933_NumberOfRecentCalls {
	public static void main(String[] args) {

	}
}

class RecentCounter {
	Queue<Integer> queue;

	public RecentCounter() {
		queue = new LinkedList<>();
	}

	public int ping(int t) {
		queue.offer(t);
		while(!queue.isEmpty() && queue.peek() < t - 3000) {
		    queue.poll();
		}
		return queue.size();
	}
}

/*
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */