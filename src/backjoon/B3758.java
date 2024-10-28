package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B3758 {

    static class Team implements Comparable<Team> {

        int id, score, cnt, time;

        public Team(int id, int score, int cnt, int time) {
            this.id = id;
            this.score = score;
            this.cnt = cnt;
            this.time = time;
        }

        @Override
        public int compareTo(Team o) {
            if (this.score == o.score && this.cnt == o.cnt)
                return this.time - o.time;
            else if (this.score == o.score)
                return this.cnt - o.cnt;
            else
                return o.score - this.score;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int[][] score = new int[n + 1][k + 1];
            int[] total = new int[n + 1];
            int[] count = new int[n + 1];
            int[] last = new int[n + 1];

            for (int l = 0; l < m; l++) {
                st = new StringTokenizer(br.readLine());
                int i = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                if (s > score[i][j]) {
                    total[i] = total[i] - score[i][j] + s;
                    score[i][j] = s;
                }
                count[i]++;
                last[i] = l;
            }
            ArrayList<Team> list = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                list.add(new Team(i, total[i], count[i], last[i]));
            }
            Collections.sort(list);
            int answer = 1;

            for (Team team : list) {
                if (team.id == t) {
                    System.out.println(answer);
                    break;
                }
                answer++;
            }
        }
    }
}
