/**
 * 677. 键值映射
 * 实现一个 MapSum 类，支持两个方法，insert 和 sum：
 * MapSum() 初始化 MapSum 对象
 * void insert(String key, int val) 插入 key-val 键值对，字符串表示键 key ，整数表示值 val 。如果键 key 已经存在，那么原来的键值对将被替代成新的键值对。
 * int sum(string prefix) 返回所有以该前缀 prefix 开头的键 key 的值的总和。
 * <p>
 * 示例：
 * 输入：
 * ["MapSum", "insert", "sum", "insert", "sum"]
 * [[], ["apple", 3], ["ap"], ["app", 2], ["ap"]]
 * 输出：
 * [null, null, 3, null, 5]
 * <p>
 * 解释：
 * MapSum mapSum = new MapSum();
 * mapSum.insert("apple", 3);
 * mapSum.sum("ap");           // return 3 (apple = 3)
 * mapSum.insert("app", 2);
 * mapSum.sum("ap");           // return 5 (apple + app = 3 + 2 = 5)
 * <p>
 * 提示：
 * 1 <= key.length, prefix.length <= 50
 * key 和 prefix 仅由小写英文字母组成
 * 1 <= val <= 1000
 * 最多调用 50 次 insert 和 sum
 */

public class Question677_MapSumPairs {
	public static void main(String[] args) {

	}
}

class MapSum {
	TrieNode root;

	public MapSum() {
		root = new TrieNode();
	}

	public void insert(String key, int val) {
		TrieNode p = root;
		for(int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);

			if(p.children[c - 'a'] == null) {
				p.children[c - 'a'] = new TrieNode();
			}

			p = p.children[c - 'a'];
			if(i == key.length() - 1) {
			    p.val = val;
			}
		}
	}

	public int sum(String prefix) {
		TrieNode p = root;
		for(int i = 0; i < prefix.length(); i++) {
			char c = prefix.charAt(i);

			if(p.children[c - 'a'] == null) {
			    return 0;
			}

			p = p.children[c - 'a'];
		}

		return getSum(p);
	}

	public int getSum(TrieNode p) {
		int sum = p.val;
		for(int i = 0; i < 26; i++) {
			if(p.children[i] != null) {
			    sum += getSum(p.children[i]);
			}
		}

		return sum;
	}

	static class TrieNode {
		int val;
		TrieNode[] children = new TrieNode[26];

		public TrieNode() {

		}

		public TrieNode(int val) {
			this.val = val;
		}
	}
}

/*
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */