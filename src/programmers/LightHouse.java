package programmers;

import java.util.ArrayList;

public class LightHouse {
    static int answer;
    static ArrayList<ArrayList<Integer>> graph;

    int dfs(int cur, int prev) {
        if (graph.get(cur).size() == 1 && graph.get(cur).get(0) == prev) {
            return 1;
        }

        int res = 0;
        for (int i = 0; i < graph.get(cur).size(); i++) {
            int next = graph.get(cur).get(i);
            if (next == prev)
                continue;
            res += dfs(next, cur);
        }

        if (res == 0)
            return 1;
        answer++;
        return 0;
    }

    public int solution(int n, int[][] lighthouse) {
        answer = 0;
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] house : lighthouse) {
            graph.get(house[0]).add(house[1]);
            graph.get(house[1]).add(house[0]);
        }

        dfs(1,0);
        return answer;
    }
}
