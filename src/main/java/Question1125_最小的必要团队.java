import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 1125. 最小的必要团队
 * 作为项目经理，你规划了一份需求的技能清单 req_skills，并打算从备选人员名单 people 中选出些人组成一个「必要团队」（ 编号为 i 的备选人员 people[i] 含有一份该备选人员掌握的技能列表）。
 * <p>
 * 所谓「必要团队」，就是在这个团队中，对于所需求的技能列表 req_skills 中列出的每项技能，团队中至少有一名成员已经掌握。可以用每个人的编号来表示团队中的成员：
 * <p>
 * 例如，团队 team = [0, 1, 3] 表示掌握技能分别为 people[0]，people[1]，和 people[3] 的备选人员。
 * 请你返回 任一 规模最小的必要团队，团队成员用人员编号表示。你可以按 任意顺序 返回答案，题目数据保证答案存在。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：req_skills = ["java","nodejs","reactjs"], people = [["java"],["nodejs"],["nodejs","reactjs"]]
 * 输出：[0,2]
 * 示例 2：
 * <p>
 * 输入：req_skills = ["algorithms","math","java","reactjs","csharp","aws"], people = [["algorithms","math","java"],["algorithms","math","reactjs"],["java","csharp","aws"],["reactjs","csharp"],["csharp","math"],["aws","java"]]
 * 输出：[1,2]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= req_skills.length <= 16
 * 1 <= req_skills[i].length <= 16
 * req_skills[i] 由小写英文字母组成
 * req_skills 中的所有字符串 互不相同
 * 1 <= people.length <= 60
 * 0 <= people[i].length <= 16
 * 1 <= people[i][j].length <= 16
 * people[i][j] 由小写英文字母组成
 * people[i] 中的所有字符串 互不相同
 * people[i] 中的每个技能是 req_skills 中的技能
 * 题目数据保证「必要团队」一定存在
 */

public class Question1125_最小的必要团队 {
	public static void main(String[] args) {
		Solution1125 solution1125 = new Solution1125();
		String[] req_skills = {"algorithms", "math", "java", "reactjs", "csharp", "aws"};
		List<List<String>> people = new ArrayList<>();
		List<String> p1 = Arrays.asList("algorithms", "math", "java");
		List<String> p2 = Arrays.asList("algorithms", "math", "reactjs");
		List<String> p3 = Arrays.asList("java", "csharp", "aws");
		List<String> p4 = Arrays.asList("reactjs", "csharp");
		List<String> p5 = Arrays.asList("csharp", "math");
		List<String> p6 = Arrays.asList("aws", "java");
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		people.add(p6);
		System.out.println(Arrays.toString(solution1125.smallestSufficientTeam(req_skills, people)));
	}
}

class Solution1125 {
	public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
		int n = req_skills.length, m = people.size();
		HashMap<String, Integer> skill_index = new HashMap<>();
		for(int i = 0; i < n; ++i) {
			skill_index.put(req_skills[i], i);
		}
		List<Integer>[] dp = new List[1 << n];
		dp[0] = new ArrayList<>();
		for(int i = 0; i < m; ++i) {
			int cur_skill = 0;
			for(String s : people.get(i)) {
				cur_skill |= 1 << skill_index.get(s);
			}
			for(int prev = 0; prev < dp.length; ++prev) {
				if(dp[prev] == null) {
					continue;
				}
				int comb = prev | cur_skill;
				if(dp[comb] == null || dp[prev].size() + 1 < dp[comb].size()) {
					dp[comb] = new ArrayList<>(dp[prev]);
					dp[comb].add(i);
				}
			}
		}
		return dp[(1 << n) - 1].stream().mapToInt(i -> i).toArray();
	}
}