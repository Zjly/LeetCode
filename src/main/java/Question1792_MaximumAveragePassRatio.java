import java.util.PriorityQueue;

public class Question1792_MaximumAveragePassRatio {
	public static void main(String[] args) {
		Solution1792 solution1792 = new Solution1792();
		int[][] classes = {{13609, 17094}, {24079, 89827}};
		int extraStudents = 22159;
		System.out.println(solution1792.maxAverageRatio(classes, extraStudents));
	}
}

class Solution1792 {
	public double maxAverageRatio(int[][] classes, int extraStudents) {
		PriorityQueue<Classes> priorityQueue = new PriorityQueue<>((a, b) -> a.ratio < b.ratio ? 1 : -1);
		for(int[] c : classes) {
			priorityQueue.add(new Classes(c[1], c[0]));
		}

		for(int i = 0; i < extraStudents; i++) {
			Classes c = priorityQueue.poll();
			c.update();
			priorityQueue.offer(c);
		}

		double d = 0;
		while(!priorityQueue.isEmpty()) {
			Classes c = priorityQueue.poll();
			d += 1.0 * c.y / c.x;
		}

		return d / classes.length;
	}

	class Classes {
		int x;
		int y;
		double ratio;

		public Classes(int x, int y) {
			this.x = x;
			this.y = y;
			ratio = 1.0 * (x - y) / (1.0 * x * (x + 1));
		}

		public void update() {
			x++;
			y++;
			ratio = 1.0 * (x - y) / (1.0 * x * (x + 1));
		}
	}
}