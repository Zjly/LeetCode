import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * 460. LFU 缓存
 * 困难
 * 744
 * 相关企业
 * 请你为 最不经常使用（LFU）缓存算法设计并实现数据结构。
 * <p>
 * 实现 LFUCache 类：
 * <p>
 * LFUCache(int capacity) - 用数据结构的容量 capacity 初始化对象
 * int get(int key) - 如果键 key 存在于缓存中，则获取键的值，否则返回 -1 。
 * void put(int key, int value) - 如果键 key 已存在，则变更其值；如果键不存在，请插入键值对。当缓存达到其容量 capacity 时，则应该在插入新项之前，移除最不经常使用的项。在此问题中，当存在平局（即两个或更多个键具有相同使用频率）时，应该去除 最久未使用 的键。
 * 为了确定最不常使用的键，可以为缓存中的每个键维护一个 使用计数器 。使用计数最小的键是最久未使用的键。
 * <p>
 * 当一个键首次插入到缓存中时，它的使用计数器被设置为 1 (由于 put 操作)。对缓存中的键执行 get 或 put 操作，使用计数器的值将会递增。
 * <p>
 * 函数 get 和 put 必须以 O(1) 的平均时间复杂度运行。
 * <p>
 * <p>
 * <p>
 * 示例：
 * <p>
 * 输入：
 * ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
 * [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
 * 输出：
 * [null, null, null, 1, null, -1, 3, null, -1, 3, 4]
 * <p>
 * 解释：
 * // cnt(x) = 键 x 的使用计数
 * // cache=[] 将显示最后一次使用的顺序（最左边的元素是最近的）
 * LFUCache lfu = new LFUCache(2);
 * lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
 * lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
 * lfu.get(1);      // 返回 1
 * // cache=[1,2], cnt(2)=1, cnt(1)=2
 * lfu.put(3, 3);   // 去除键 2 ，因为 cnt(2)=1 ，使用计数最小
 * // cache=[3,1], cnt(3)=1, cnt(1)=2
 * lfu.get(2);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,1], cnt(3)=2, cnt(1)=2
 * lfu.put(4, 4);   // 去除键 1 ，1 和 3 的 cnt 相同，但 1 最久未使用
 * // cache=[4,3], cnt(4)=1, cnt(3)=2
 * lfu.get(1);      // 返回 -1（未找到）
 * lfu.get(3);      // 返回 3
 * // cache=[3,4], cnt(4)=1, cnt(3)=3
 * lfu.get(4);      // 返回 4
 * // cache=[3,4], cnt(4)=2, cnt(3)=3
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= capacity <= 104
 * 0 <= key <= 105
 * 0 <= value <= 109
 * 最多调用 2 * 105 次 get 和 put 方法
 */

public class Question460_LFU缓存 {
}

/**
 * @author Zhang Lei
 * @date 2023/9/25 19:26
 */
class LFUCache {
    class Node implements Comparable<Node> {
        int count;
        int time;
        int key;
        int value;
        
        @Override
        public int compareTo(Node o) {
            if (o.count == this.count) {
                return this.time - o.time;
            }

            return this.count - o.count;
        }
    }
    TreeSet<Node> treeSet;
    Map<Integer, Node> map;
    int capacity;
    int time;

    public LFUCache(int capacity) {
        treeSet = new TreeSet<>();
        map = new HashMap<>();
        this.capacity = capacity;
        time = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            treeSet.remove(node);
            node.count = node.count + 1;
            node.time = time++;
            treeSet.add(node);
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            treeSet.remove(node);
            node.value = value;
            node.count = node.count + 1;
            node.time = time++;
            treeSet.add(node);
            return;
        }

        if (capacity == treeSet.size()) {
            Node first = treeSet.first();
            map.remove(first.key);
            treeSet.remove(first);
        }

        Node node = new Node();
        node.count = 1;
        node.time = time++;
        node.key = key;
        node.value = value;
        map.put(key, node);
        treeSet.add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */