import java.util.*;

import static java.util.Arrays.asList;

/**
 * 690. 员工的重要性
 * 给定一个保存员工信息的数据结构，它包含了员工唯一的id，重要度 和 直系下属的id。
 * 比如，员工1是员工2的领导，员工2是员工3的领导。他们相应的重要度为15, 10, 5。那么员工1的数据结构是[1, 15, [2]]，员工2的数据结构是[2, 10, [3]]，员工3的数据结构是[3, 5, []]。注意虽然员工3也是员工1的一个下属，但是由于并不是直系下属，因此没有体现在员工1的数据结构中。
 * 现在输入一个公司的所有员工信息，以及单个员工id，返回这个员工和他所有下属的重要度之和。
 * <p>
 * 示例 1:
 * 输入: [[1, 5, [2, 3]], [2, 3, []], [3, 3, []]], 1
 * 输出: 11
 * 解释:
 * 员工1自身的重要度是5，他有两个直系下属2和3，而且2和3的重要度均为3。因此员工1的总重要度是 5 + 3 + 3 = 11。
 * <p>
 * 注意:
 * 一个员工最多有一个直系领导，但是可以有多个直系下属
 * 员工数量不超过2000。
 */

public class Question690_EmployeeImportance {
	public static void main(String[] args) {
		Employee690 employee1 = new Employee690(1, 5, asList(2, 3));
		Employee690 employee2 = new Employee690(2, 3, Collections.emptyList());
		Employee690 employee3 = new Employee690(3, 3, Collections.emptyList());

		List<Employee690> employees = new ArrayList<>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);

		Solution690 solution690 = new Solution690();
		System.out.println(solution690.getImportance(employees, 1));
	}
}

// Definition for Employee.
class Employee690 {
	public int id;
	public int importance;
	public List<Integer> subordinates;

	public Employee690(int id, int importance, List<Integer> subordinates) {
		this.id = id;
		this.importance = importance;
		this.subordinates = subordinates;
	}
}

class Solution690 {
	public int getImportance(List<Employee690> employees, int id) {
		// 建立哈希表
		HashMap<Integer, Employee690> hashMap = new HashMap<>();
		for(Employee690 employee : employees) {
			hashMap.put(employee.id, employee);
		}

		// 重要值总和
		int importance = 0;

		// 创建队列
		LinkedList<Integer> linkedList = new LinkedList<>();
		Employee690 thisEmployees = hashMap.get(id);
		linkedList.add(thisEmployees.id);

		// 使用BFS进行逐层计算
		while(linkedList.size() != 0) {
			thisEmployees = hashMap.get(linkedList.pollFirst());
			importance += thisEmployees.importance;
			linkedList.addAll(thisEmployees.subordinates);
		}

		return importance;
	}
}
