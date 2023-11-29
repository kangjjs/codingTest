package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B8980 {

    private static class Post implements Comparable<Post> {
        int s, e, val;

        public Post(int s, int e, int val) {
            this.s = s;
            this.e = e;
            this.val = val;
        }

        @Override
        public int compareTo(Post o) {
            if (this.e == o.e)
                return this.s - o.s;
            return this.e - o.e;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int M = Integer.parseInt(br.readLine());
        ArrayList<Post> posts = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            posts.add(new Post(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(posts);
        int[] weight = new int[N + 1];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            weight[i] = C;
        }

        for (int i = 0; i < M; i++) {
            Post p = posts.get(i);
            int max = Integer.MAX_VALUE;

            for (int j = p.s; j < p.e; j++) {
                max = Math.min(max, weight[j]);
            }

            if (max > p.val) {
                for (int j = p.s; j < p.e; j++) {
                    weight[j] -= p.val;
                }
                result += p.val;
            } else {
                for (int j = p.s; j < p.e; j++) {
                    weight[j] -= max;
                }
                result += max;
            }
        }
        System.out.println(result);
    }
}
