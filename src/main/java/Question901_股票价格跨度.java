import java.util.Stack;

/**
 * 901. 股票价格跨度
 * 设计一个算法收集某些股票的每日报价，并返回该股票当日价格的 跨度 。
 * <p>
 * 当日股票价格的 跨度 被定义为股票价格小于或等于今天价格的最大连续日数（从今天开始往回数，包括今天）。
 * <p>
 * 例如，如果未来 7 天股票的价格是 [100,80,60,70,60,75,85]，那么股票跨度将是 [1,1,1,2,1,4,6] 。
 * <p>
 * 实现 StockSpanner 类：
 * <p>
 * StockSpanner() 初始化类对象。
 * int next(int price) 给出今天的股价 price ，返回该股票当日价格的 跨度 。
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["StockSpanner", "next", "next", "next", "next", "next", "next", "next"]
 * [[], [100], [80], [60], [70], [60], [75], [85]]
 * 输出：
 * [null, 1, 1, 1, 2, 1, 4, 6]
 * <p>
 * 解释：
 * StockSpanner stockSpanner = new StockSpanner();
 * stockSpanner.next(100); // 返回 1
 * stockSpanner.next(80);  // 返回 1
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(70);  // 返回 2
 * stockSpanner.next(60);  // 返回 1
 * stockSpanner.next(75);  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
 * stockSpanner.next(85);  // 返回 6
 * <p>
 * 提示：
 * <p>
 * 1 <= price <= 105
 * 最多调用 next 方法 104 次
 */

public class Question901_股票价格跨度 {
}

/**
 * @author Zhang Lei
 * @date 2023/10/7 12:36
 */
class StockSpanner {
    Stack<int[]> stack;
    int index;

    public StockSpanner() {
        stack = new Stack<>();
        index = 0;
        stack.push(new int[]{Integer.MAX_VALUE, -1});
    }

    // 即求出每个值与上一个更大元素之间的下标之差
    public int next(int price) {
        while (stack.peek()[0] <= price) {
            stack.pop();
        }

        int next = index - stack.peek()[1];
        stack.push(new int[]{price, index++});
        return next;
    }
}

/*
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */