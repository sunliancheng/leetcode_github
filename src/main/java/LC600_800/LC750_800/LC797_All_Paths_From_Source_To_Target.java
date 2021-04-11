package LC600_800.LC750_800;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LC797_All_Paths_From_Source_To_Target {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> re = new ArrayList<>();
        dfs(0, new HashSet<>(),graph, new ArrayList<>(), re);
        return re;
    }

    public void dfs(int idx, Set<Integer> set , int[][] graph, List<Integer> path, List<List<Integer>> re) {
        if (set.contains(idx)) return;
        path.add(idx);
        if (idx == graph.length - 1) {
            re.add(new ArrayList<>(path));
            path.remove(path.size() - 1);
            return;
        } else {
            set.add(idx);
            for (int i : graph[idx]) {
                dfs(i, set, graph, path, re);
            }
            path.remove(path.size() - 1);
            set.remove(idx);
        }
    }


}
