import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/**
 * 341. 扁平化嵌套列表迭代器
 * 给你一个嵌套的整型列表。请你设计一个迭代器，使其能够遍历这个整型列表中的所有整数。
 * 列表中的每一项或者为一个整数，或者是另一个列表。其中列表的元素也可能是整数或是其他列表。
 * <p>
 * 示例 1:
 * 输入: [[1,1],2,[1,1]]
 * 输出: [1,1,2,1,1]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,1,2,1,1]。
 * <p>
 * 示例 2:
 * 输入: [1,[4,[6]]]
 * 输出: [1,4,6]
 * 解释: 通过重复调用 next 直到 hasNext 返回 false，next 返回的元素的顺序应该是: [1,4,6]。
 */

public class Question341_FlattenNestedListIterator {
	public static void main(String[] args) {

	}
}

/*
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 */

interface NestedInteger {
	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	// 如果此嵌套整数包含单个整数而不是嵌套列表，则返回true。
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// 如果嵌套整数包含单个整数，则返回该嵌套整数包含的单个整数
	// Return null if this NestedInteger holds a nested list
	// 如果此嵌套整数包含嵌套列表，则返回null
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// @如果该嵌套整数包含嵌套列表，则返回该嵌套整数包含的嵌套列表
	// Return null if this NestedInteger holds a single integer
	// 如果此嵌套整数包含单个整数，则返回null
	public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
	Stack<NestedInteger> stack;

	public NestedIterator(List<NestedInteger> nestedList) {
		stack = new Stack<>();

		for(int i = nestedList.size() - 1; i >= 0; i--) {
			if(!isEmpty(nestedList.get(i))) {
				stack.push(nestedList.get(i));
			}
		}
	}

	@Override
	public Integer next() {
		NestedInteger nestedInteger = stack.pop();

		while(!nestedInteger.isInteger()) {
			List<NestedInteger> nestedIntegerList = nestedInteger.getList();
			for(int i = nestedIntegerList.size() - 1; i >= 0; i--) {
				if(!isEmpty(nestedIntegerList.get(i))) {
					stack.push(nestedIntegerList.get(i));
				}
			}
			nestedInteger = stack.pop();
		}

		return nestedInteger.getInteger();
	}

	@Override
	public boolean hasNext() {
		return !stack.empty();
	}

	public boolean isEmpty(NestedInteger nestedInteger) {
		if(nestedInteger.isInteger()) {
		    return false;
		}
		List<NestedInteger> nestedIntegerList = nestedInteger.getList();
		for(NestedInteger integer : nestedIntegerList) {
			if(!isEmpty(integer)) {
				return false;
			}
		}
		return true;
	}
}

/*
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
