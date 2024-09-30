package programmers;

import java.util.*;

public class HikingCourse {

    static class Path implements Comparable<Path> {
        int node;
        int intensity;

        public Path(int node, int intensity) {
            this.node = node;
            this.intensity = intensity;
        }

        @Override
        public int compareTo(Path o) {
            return this.intensity - o.intensity;
        }
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        Set<Integer> summitSet = new HashSet<>();
        for (int summit : summits) {
            summitSet.add(summit);
        }
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            graph.get(path[0]).add(new int[]{path[1], path[2]});
            graph.get(path[1]).add(new int[]{path[0], path[2]});
        }

        PriorityQueue<Path> pq = new PriorityQueue<>();
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        for (int gate : gates) {
            pq.offer(new Path(gate, 0));
            intensity[gate] = 0;
        }

        while (!pq.isEmpty()) {
            Path cur = pq.poll();
            int curNode = cur.node;
            int curIntensity = cur.intensity;

            // 현재 경로가 이미 더 높은 intensity라면 스킵
            if (curIntensity > intensity[curNode]) {
                continue;
            }

            if (summitSet.contains(curNode)) {
                continue;
            }

            for (int[] next : graph.get(cur.node)) {
                int nextNode = next[0];
                int weight = next[1];
                int newIntensity = Math.max(curIntensity, weight);

                if (intensity[nextNode] > newIntensity) {
                    intensity[nextNode] = newIntensity;
                    pq.offer(new Path(nextNode, newIntensity));
                }
            }
        }

        int minSummit = Integer.MAX_VALUE;
        int minIntensity = Integer.MAX_VALUE;
        Arrays.sort(summits);  // 산봉우리가 여러 개일 경우 작은 번호 우선

        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minSummit = summit;
                minIntensity = intensity[summit];
            }
        }

        return new int[]{minSummit, minIntensity};
    }

    public static void main(String[] args) {
        HikingCourse s = new HikingCourse();
        for (int x : s.solution(6, new int[][]{{1, 2, 3}, {2, 3, 5}, {2, 4, 2}, {2, 5, 4}, {3, 4, 4}, {4, 5, 3}, {4, 6, 1}, {5, 6, 1}}
                , new int[]{1, 3}, new int[]{5})) {
            System.out.println(x);
        }
    }
}
