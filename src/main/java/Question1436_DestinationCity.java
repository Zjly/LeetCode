import java.util.HashMap;
import java.util.List;

/**
 * 1436. 旅行终点站
 * 给你一份旅游线路图，该线路图中的旅行线路用数组 paths 表示，其中 paths[i] = [cityAi, cityBi] 表示该线路将会从 cityAi 直接前往 cityBi 。请你找出这次旅行的终点站，即没有任何可以通往其他城市的线路的城市。
 * <p>
 * 题目数据保证线路图会形成一条不存在循环的线路，因此恰有一个旅行终点站。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
 * 输出："Sao Paulo"
 * 解释：从 "London" 出发，最后抵达终点站 "Sao Paulo" 。本次旅行的路线是 "London" -> "New York" -> "Lima" -> "Sao Paulo" 。
 * 示例 2：
 * <p>
 * 输入：paths = [["B","C"],["D","B"],["C","A"]]
 * 输出："A"
 * 解释：所有可能的线路是：
 * "D" -> "B" -> "C" -> "A".
 * "B" -> "C" -> "A".
 * "C" -> "A".
 * "A".
 * 显然，旅行终点站是 "A" 。
 * 示例 3：
 * <p>
 * 输入：paths = [["A","Z"]]
 * 输出："Z"
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= paths.length <= 100
 * paths[i].length == 2
 * 1 <= cityAi.length, cityBi.length <= 10
 * cityAi != cityBi
 * 所有字符串均由大小写英文字母和空格字符组成。
 */

public class Question1436_DestinationCity {
	public static void main(String[] args) {

	}
}

class Solution1436 {
	public String destCity(List<List<String>> paths) {
		HashMap<String, Boolean> hashMap = new HashMap<>();
		for(List<String> path : paths) {
			hashMap.put(path.get(0), false);

			if(!hashMap.containsKey(path.get(1))) {
				hashMap.put(path.get(1), true);
			}
		}

		for(HashMap.Entry<String, Boolean> entry : hashMap.entrySet()) {
			if(entry.getValue()) {
			    return entry.getKey();
			}
		}

		return "";
	}
}