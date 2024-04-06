package ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Ch01 {
    public int solution(int n, int[][] flights, int s, int e, int k) {
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] costs = new int[n];
        Arrays.fill(costs, 100000000);
        for (int[] x : flights) {
            graph.get(x[0]).add(new int[]{x[1], x[2]});
        }
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{s, 0});
        costs[s] = 0;
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                int[] cur = q.poll();

                int now = cur[0];
                int cost = cur[1];

                for (int[] x : graph.get(now)) {
                    int next = x[0];
                    int nextCost = x[1];
                    if (next + nextCost < costs[next]) {
                        costs[next] = cost + nextCost;
                        q.offer(new int[]{next, nextCost});
                    }
                }
            }

            L++;

            if(L>k){
                break;
            }
        }

        return costs[e]==100000000 ? -1 : costs[e];
    }

    public static void main(String[] args) {
        Ch01 T = new Ch01();
        System.out.println(T.solution(5, new int[][]{{0, 1, 10}, {1, 2, 20}, {0, 2, 70}, {0, 3, 100}, {1, 3, 80}, {2, 3, 10}, {2, 4, 30}, {3, 4, 10}}, 0, 3, 1));
        System.out.println(T.solution(4, new int[][]{{0, 1, 10}, {0, 2, 10}, {1, 3, 5}, {2, 3, 3}}, 0, 3, 0));
        System.out.println(T.solution(8, new int[][]{{0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 7, 2));
        System.out.println(T.solution(10, new int[][]{{1, 8, 50}, {0, 8, 30}, {1, 0, 10}, {2, 8, 10}, {0, 3, 10}, {1, 5, 10}, {1, 7, 100}, {0, 1, 10}, {0, 2, 10}, {5, 7, 30}, {3, 7, 10}, {1, 3, 5}, {2, 3, 3}}, 1, 8, 2));
    }
}
