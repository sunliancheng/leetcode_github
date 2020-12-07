package LC200_400.LC200_250;

import java.util.ArrayList;

public class LC207_Course_Schedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; ++i)
            graph[i] = new ArrayList();
        boolean[] dp = new boolean[numCourses];
        boolean visited[] = new boolean[numCourses];
        for(int i = 0; i < prerequisites.length; ++i)
            graph[prerequisites[i][1]].add(prerequisites[i][0]);

        for(int i = 0; i < numCourses; ++i)
            if(!dfs(graph, i, visited, dp))
                return false;
        return true;
    }

    //dfs to check whether the graph has cycle
    public boolean dfs(ArrayList[] graph, int course, boolean[] visited, boolean[] dp) {
        if(visited[course])
            return dp[course];
        else
            visited[course] = true;
        for(int i = 0; i < graph[course].size(); ++i)
            if(!dfs(graph, (int) graph[course].get(i), visited, dp)) {
                dp[course] = false;
                return false;
            }
        visited[course] = false;
        dp[course] = true;
        return true;
    }
}
