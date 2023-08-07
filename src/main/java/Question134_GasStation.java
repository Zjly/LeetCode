public class Question134_GasStation {
	public static void main(String[] args) {
		Solution134 solution134 = new Solution134();
		int[] gas = {1, 2, 3, 4, 5, 5, 70};
		int[] cost = {2, 3, 4, 3, 9, 6, 2};
		System.out.println(solution134.canCompleteCircuit(gas, cost));
	}
}

class Solution134 {
	public int canCompleteCircuit(int[] gas, int[] cost) {
		// 计算差距数组
		int[] remain = new int[gas.length];
		for(int i = 0; i < gas.length; i++) {
			remain[i] = gas[i] - cost[i];
		}

		// 遍历每一个起点
		for(int i = 0; i < gas.length; i++) {
			int j = i;
			int result = 0;
			int count = 0;

			// 找出一条能够完成的路线
			while(count != gas.length) {
				result += remain[j];
				j = (j + 1) >= gas.length ? j + 1 - gas.length : j + 1;
				if(result < 0) {
					break;
				}
				count++;
			}

			// 找到起点
			if(count == gas.length) {
				return i;
			}

		}
		return -1;
	}
}
