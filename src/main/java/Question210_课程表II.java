import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * 210. 课程表 II
 * 相关企业
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * <p>
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：numCourses = 2, prerequisites = [[1,0]]
 * 输出：[0,1]
 * 解释：总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 示例 2：
 * <p>
 * 输入：numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * 输出：[0,2,1,3]
 * 解释：总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 示例 3：
 * <p>
 * 输入：numCourses = 1, prerequisites = []
 * 输出：[0]
 * <p>
 * <p>
 * 提示：
 * 1 <= numCourses <= 2000
 * 0 <= prerequisites.length <= numCourses * (numCourses - 1)
 * prerequisites[i].length == 2
 * 0 <= ai, bi < numCourses
 * ai != bi
 * 所有[ai, bi] 互不相同
 */

public class Question210_课程表II {
    Solution210 solution210 = new Solution210();

    @Test
    public void test() {
        int numCourses = 2;
        int[][] prerequisites = {{0, 1}, {1, 0}};
        System.out.println(Arrays.toString(solution210.findOrder(numCourses, prerequisites)));
    }
}

/**
 * @author Zhang Lei
 * @date 2023/9/10 18:46
 */
class Solution210 {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] result = new int[numCourses];

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

        int index = 0;
        while (!deque.isEmpty()) {
            Integer point = deque.pollFirst();

            result[index] = point;
            index++;

            List<Integer> list = pointList.get(point);
            for (Integer endPoint : list) {
                inDegree[endPoint]--;
                if (inDegree[endPoint] == 0) {
                    deque.add(endPoint);
                }
            }
        }

        return index != numCourses ? new int[]{} : result;
    }
}