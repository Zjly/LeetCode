import java.util.*;

/**
 * 1233. 删除子文件夹
 * 你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。
 * <p>
 * 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。
 * <p>
 * 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。
 * <p>
 * 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * 输出：["/a","/c/d","/c/f"]
 * 解释："/a/b/" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
 * 示例 2：
 * <p>
 * 输入：folder = ["/a","/a/b/c","/a/b/d"]
 * 输出：["/a"]
 * 解释：文件夹 "/a/b/c" 和 "/a/b/d/" 都会被删除，因为它们都是 "/a" 的子文件夹。
 * 示例 3：
 * <p>
 * 输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * 输出: ["/a/b/c","/a/b/ca","/a/b/d"]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= folder.length <= 4 * 104
 * 2 <= folder[i].length <= 100
 * folder[i] 只包含小写字母和 '/'
 * folder[i] 总是以字符 '/' 起始
 * 每个文件夹名都是 唯一 的
 */

public class Question1233_RemoveSubFoldersFromTheFilesystem {
	public static void main(String[] args) {

	}
}

class Solution1233 {
	public List<String> removeSubfolders(String[] folder) {
		Trie trie = new Trie();
		for(String fold : folder) {
			trie.add(fold, fold.split("/"));
		}

		return trie.get();
	}

	static class Trie {
		TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		public void add(String fold, String[] foldList) {
			TrieNode p = root;

			for(int i = 1; i < foldList.length; i++) {
				String name = foldList[i];

				if(!p.children.containsKey(name)) {
				    p.children.put(name, new TrieNode());
				}

				p = p.children.get(name);

				if(p.fold != null) {
				    return;
				}

				if(i == foldList.length - 1) {
				    p.fold = fold;
				}
			}
		}

		public List<String> get() {
			List<String> result = new ArrayList<>();
			Queue<TrieNode> queue = new ArrayDeque<>();
			queue.offer(root);
			while(!queue.isEmpty()) {
			    int size = queue.size();
				for(int i = 0; i < size; i++) {
					TrieNode p = queue.poll();

					if(p.fold != null) {
					    result.add(p.fold);
					} else {
					    for(String key : p.children.keySet()) {
					    	queue.offer(p.children.get(key));
					    }
					}
				}
			}

			return result;
		}
	}

	static class TrieNode {
		String fold;
		HashMap<String, TrieNode> children;

		public TrieNode() {
			this.children = new HashMap<>();
		}
	}
}