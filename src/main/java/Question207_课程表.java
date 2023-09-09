import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 207. 课程表
 * 提示
 * 中等
 * 1.8K
 * 相关企业
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：true
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。
 * 示例 2：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
 * 输出：false
 * 解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= 5000
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * prerequisites[i] 中的所有课程对 互不相同
 */

public class Question207_课程表 {
}

/**
 * @author Zhang Lei
 * @date 2023/9/9 21:35
 */
class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> pointList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            pointList.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int beginPoint = prerequisite[1];
            int endPoint = prerequisite[0];
            pointList.get(beginPoint).add(endPoint);
            inDegree[endPoint]++;
        }

        Deque<Integer> deque = new ArrayDeque<>();

        // find in degree = 0
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                deque.add(i);
            }
        }

        int count = 0;
        while (!deque.isEmpty()) {
            count++;
            Integer point = deque.pollFirst();
            List<Integer> list = pointList.get(point);
            for (Integer endPoint : list) {
                inDegree[endPoint]--;
                if (inDegree[endPoint] == 0) {
                    deque.add(endPoint);
                }
            }
        }

        return numCourses == count;
    }
}