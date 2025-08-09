package programmers;

import java.util.*;

class AddServers {

    static class Server implements Comparable<Server> {

        public int time, cnt;

        public Server(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Server s) {
            return this.time - s.time;
        }
    }

    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int server = 0;

        PriorityQueue<Server> pq = new PriorityQueue<>();

        for (int i = 0; i < 24; i++) {

            while (!pq.isEmpty() && pq.peek().time + k <= i) {
                Server s = pq.poll();
                server -= s.cnt;
            }

            int need = players[i] / m;

            if (need > server) {
                int add = need - server;
                server += add;
                answer += add;
                pq.offer(new Server(i, add));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        AddServers s = new AddServers();
        System.out.println(s.solution(new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}, 3, 5));
    }
}