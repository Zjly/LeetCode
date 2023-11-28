import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1670. 设计前中后队列
 * 提示
 * 中等
 * 83
 * 相关企业
 * 请你设计一个队列，支持在前，中，后三个位置的 push 和 pop 操作。
 * <p>
 * 请你完成 FrontMiddleBack 类：
 * <p>
 * FrontMiddleBack() 初始化队列。
 * void pushFront(int val) 将 val 添加到队列的 最前面 。
 * void pushMiddle(int val) 将 val 添加到队列的 正中间 。
 * void pushBack(int val) 将 val 添加到队里的 最后面 。
 * int popFront() 将 最前面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popMiddle() 将 正中间 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * int popBack() 将 最后面 的元素从队列中删除并返回值，如果删除之前队列为空，那么返回 -1 。
 * 请注意当有 两个 中间位置的时候，选择靠前面的位置进行操作。比方说：
 * <p>
 * 将 6 添加到 [1, 2, 3, 4, 5] 的中间位置，结果数组为 [1, 2, 6, 3, 4, 5] 。
 * 从 [1, 2, 3, 4, 5, 6] 的中间位置弹出元素，返回 3 ，数组变为 [1, 2, 4, 5, 6] 。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["FrontMiddleBackQueue", "pushFront", "pushBack", "pushMiddle", "pushMiddle", "popFront", "popMiddle", "popMiddle", "popBack", "popFront"]
 * [[], [1], [2], [3], [4], [], [], [], [], []]
 * 输出：
 * [null, null, null, null, null, 1, 3, 4, 2, -1]
 * <p>
 * 解释：
 * FrontMiddleBackQueue q = new FrontMiddleBackQueue();
 * q.pushFront(1);   // [1]
 * q.pushBack(2);    // [1, 2]
 * q.pushMiddle(3);  // [1, 3, 2]
 * q.pushMiddle(4);  // [1, 4, 3, 2]
 * q.popFront();     // 返回 1 -> [4, 3, 2]
 * q.popMiddle();    // 返回 3 -> [4, 2]
 * q.popMiddle();    // 返回 4 -> [2]
 * q.popBack();      // 返回 2 -> []
 * q.popFront();     // 返回 -1 -> [] （队列为空）
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= val <= 109
 * 最多调用 1000 次 pushFront， pushMiddle， pushBack， popFront， popMiddle 和 popBack 。
 */

public class Question1670_设计前中后队列 {
}

/**
 * @author Zhang Lei
 * @date 2023/11/28 20:05
 */
class FrontMiddleBackQueue {
    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public FrontMiddleBackQueue() {
        deque1 = new ArrayDeque<>();
        deque2 = new ArrayDeque<>();
    }

    public void pushFront(int val) {
        if (deque1.size() != deque2.size()) {
            deque2.addFirst(deque1.pollLast());
        }

        deque1.addFirst(val);
    }

    public void pushMiddle(int val) {
        if (deque1.size() != deque2.size()) {
            deque2.addFirst(deque1.pollLast());
        }

        deque1.addLast(val);
    }

    public void pushBack(int val) {
        if (deque1.isEmpty()) {
            deque1.addLast(val);
            return;
        }


        if (deque1.size() == deque2.size()) {
            deque1.addLast(deque2.pollFirst());
        }

        deque2.addLast(val);
    }

    public int popFront() {
        if (deque1.isEmpty()) {
            return -1;
        }

        int result = deque1.pollFirst();

        if (deque1.size() != deque2.size()) {
            deque1.addLast(deque2.pollFirst());
        }

        return result;
    }

    public int popMiddle() {
        if (deque1.isEmpty()) {
            return -1;
        }

        int result = deque1.pollLast();

        if (deque1.size() != deque2.size()) {
            deque1.addLast(deque2.pollFirst());
        }

        return result;
    }

    public int popBack() {
        if (deque1.isEmpty()) {
            return -1;
        }

        if (deque2.isEmpty()) {
            return deque1.pollLast();
        }

        int result = deque2.pollLast();

        if (deque1.size() != deque2.size() + 1) {
            deque2.addFirst(deque1.pollLast());
        }

        return result;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */