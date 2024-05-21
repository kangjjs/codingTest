package programmers;

import java.util.HashMap;
import java.util.Map;

public class Donut {
    public int[] solution(int[][] edges) {
        Map<Integer, int[]> graph = new HashMap<>();
        for (int[] e : edges) {
            if (!graph.containsKey(e[0])) {
                graph.put(e[0], new int[]{0, 0});
            }

            if (!graph.containsKey(e[1])) {
                graph.put(e[1], new int[]{0, 0});
            }

            graph.get(e[0])[0] += 1;
            graph.get(e[1])[1] += 1;
        }

        int node = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;

        for (int x : graph.keySet()) {
            if (graph.get(x)[0] >= 2 && graph.get(x)[1] == 0) {
                node = x;
            } else if (graph.get(x)[0] >= 2 && graph.get(x)[1] >= 2) {
                eight++;
            } else if (graph.get(x)[0] == 0 && graph.get(x)[1] > 0) {
                stick++;
            }
        }

        donut = graph.get(node)[0]-eight-stick;
        return new int[]{node,donut,stick,eight};
    }
}
