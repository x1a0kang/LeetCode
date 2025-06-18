import java.util.ArrayList;
import java.util.List;

public class CanFinish {
    public static void main(String[] args) {
        CanFinish canFinish = new CanFinish();
        System.out.println(canFinish.canFinish(2, new int[][]{{1, 0}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites.length == 0) {
            return true;
        }
        // 因为课程号是从0到numCourses-1，可以用数组索引来表示课程号
        // 入度表
        int[] inDegree = new int[numCourses];
        // 记录当前节点指向的节点，邻接表
        List<List<Integer>> adjacencyList = new ArrayList<>();
        // 先初始化邻接表
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        // 遍历prerequisites，填充入度表和邻接表
        for (int[] prerequisite : prerequisites) {
            inDegree[prerequisite[0]]++;
            adjacencyList.get(prerequisite[1]).add(prerequisite[0]);
        }

        // 入度为0的节点先入队列
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                list.add(i);
            }
        }
        int curr;
        // BFS
        while (!list.isEmpty()) {
            curr = list.removeFirst();
            // 每从队列中取出一个，课程数减1
            numCourses--;
            // 遍历当前节点指向的节点
            List<Integer> nextList = adjacencyList.get(curr);
            for (int next : nextList) {
                // 入度减一
                inDegree[next]--;
                // 入度为0的节点加入队列
                if (inDegree[next] == 0) {
                    list.add(next);
                }
            }
        }
        return numCourses == 0;
    }
}
