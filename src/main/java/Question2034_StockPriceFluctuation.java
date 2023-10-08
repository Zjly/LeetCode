import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeSet;

/**
 * 2034. 股票价格波动
 * 给你一支股票价格的数据流。数据流中每一条记录包含一个 时间戳 和该时间点股票对应的 价格 。
 * <p>
 * 不巧的是，由于股票市场内在的波动性，股票价格记录可能不是按时间顺序到来的。某些情况下，有的记录可能是错的。如果两个有相同时间戳的记录出现在数据流中，前一条记录视为错误记录，后出现的记录 更正 前一条错误的记录。
 * <p>
 * 请你设计一个算法，实现：
 * <p>
 * 更新 股票在某一时间戳的股票价格，如果有之前同一时间戳的价格，这一操作将 更正 之前的错误价格。
 * 找到当前记录里 最新股票价格 。最新股票价格 定义为时间戳最晚的股票价格。
 * 找到当前记录里股票的 最高价格 。
 * 找到当前记录里股票的 最低价格 。
 * 请你实现 StockPrice 类：
 * <p>
 * StockPrice() 初始化对象，当前无股票价格记录。
 * void update(int timestamp, int price) 在时间点 timestamp 更新股票价格为 price 。
 * int current() 返回股票 最新价格 。
 * int maximum() 返回股票 最高价格 。
 * int minimum() 返回股票 最低价格 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["StockPrice", "update", "update", "current", "maximum", "update", "maximum", "update", "minimum"]
 * [[], [1, 10], [2, 5], [], [], [1, 3], [], [4, 2], []]
 * 输出：
 * [null, null, null, 5, 10, null, 5, null, 2]
 * <p>
 * 解释：
 * StockPrice stockPrice = new StockPrice();
 * stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
 * stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
 * stockPrice.current();     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
 * stockPrice.maximum();     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
 * stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
 * // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
 * stockPrice.maximum();     // 返回 5 ，更正后最高价格为 5 。
 * stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
 * stockPrice.minimum();     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= timestamp, price <= 109
 * update，current，maximum 和 minimum 总 调用次数不超过 105 。
 * current，maximum 和 minimum 被调用时，update 操作 至少 已经被调用过 一次 。
 */

public class Question2034_StockPriceFluctuation {
	public static void main(String[] args) {

	}
}

class StockPrice {
	int current;
	HashMap<Integer, Integer> timePriceMap;
	PriorityQueue<int[]> maxPriorityQueue;
	PriorityQueue<int[]> minPriorityQueue;

	public StockPrice() {
		current = 0;
		timePriceMap = new HashMap<>();
		maxPriorityQueue = new PriorityQueue<>((a, b) -> b[0] - a[0]);
		minPriorityQueue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
	}

	public void update(int timestamp, int price) {
		current = Math.max(current, timestamp);
		timePriceMap.put(timestamp, price);
		maxPriorityQueue.offer(new int[]{price, timestamp});
		minPriorityQueue.offer(new int[]{price, timestamp});
	}

	public int current() {
		return timePriceMap.get(current);
	}

	public int maximum() {
		while (true) {
			int[] priceTime = maxPriorityQueue.peek();
			int price = priceTime[0], timestamp = priceTime[1];
			if (timePriceMap.get(timestamp) == price) {
				return price;
			}
			maxPriorityQueue.poll();
		}
	}

	public int minimum() {
		while (true) {
			int[] priceTime = minPriorityQueue.peek();
			int price = priceTime[0], timestamp = priceTime[1];
			if (timePriceMap.get(timestamp) == price) {
				return price;
			}
			minPriorityQueue.poll();
		}
	}
}

class StockPrice_2 {
	int maxTimestamp;
	TreeSet<int[]> treeSet;
	Map<Integer, Integer> map;

	public StockPrice_2() {
		maxTimestamp = 0;
		/* 代码中使用了 TreeSet<int[]> 这个数据结构，它是一个有序集合，可以按照自定义的比较器来排序元素。你的比较器是 (a, b) -> a[1] -
		b[1]，也就是说，你只根据数组的第二个元素（也就是价格）来比较两个数组。这样做有一个问题，就是如果两个数组的第二个元素相同，
		那么它们会被认为是相等的，而 TreeSet 不允许有重复的元素。所以，如果你有两个不同的时间戳，但是价格相同，那么 TreeSet 只会保留一个，
		而丢弃另一个。这可能导致你在查询最大或最小价格时候得到错误的结果。
		 */
		treeSet = new TreeSet<>((a, b) -> {
			if (a[1] > b[1]) {
			    return 1;
			} else if (a[1] == b[1]) {
			    return a[0] - b[0];
			} else {
			    return -1;
			}
		});
		map = new HashMap<>();
	}

	public void update(int timestamp, int price) {
		if (map.containsKey(timestamp)) {
			int oldPrice = map.get(timestamp);
			treeSet.remove(new int[]{timestamp, oldPrice});
		}

		if (timestamp >= maxTimestamp) {
			maxTimestamp = timestamp;
		}

		map.put(timestamp, price);
		treeSet.add(new int[]{timestamp, price});
	}

	public int current() {
		return map.get(maxTimestamp);
	}

	public int maximum() {
		return treeSet.last()[1];
	}

	public int minimum() {
		return treeSet.first()[1];
	}
}