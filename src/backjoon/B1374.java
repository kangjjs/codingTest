package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1374 {

    static class Lecture implements Comparable<Lecture> {
        int num, st, et;

        public Lecture(int num, int st, int et) {
            this.num = num;
            this.st = st;
            this.et = et;
        }


        @Override
        public int compareTo(Lecture o) {
            if (this.st == o.st)
                return this.et - o.et;
            return this.st - o.st;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            lectures.add(new Lecture(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(lectures);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 1;

        for (int i = 0; i < N; i++) {
            while (!pq.isEmpty() && pq.peek() <= lectures.get(i).st)
                pq.poll();
            pq.offer(lectures.get(i).et);
            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);
    }
}
