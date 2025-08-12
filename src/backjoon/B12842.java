package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B12842 {

    static class Person implements Comparable<Person> {

        public int id, period;
        public long next;

        public Person(int id, long next, int period) {
            this.id = id;
            this.next = next;
            this.period = period;
        }

        @Override
        public int compareTo(Person o) {
            if (this.next != o.next)
                return Long.compare(this.next, o.next);
            return this.id - o.id;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] arr = new int[m + 1];

        for (int i = 1; i <= m; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int eat = n - s;
        PriorityQueue<Person> pq = new PriorityQueue<>();

        for (int i = 1; i <= m; i++) {
            pq.add(new Person(i,0L,arr[i]));
        }

        int ans = -1;

        for(int i=0;i<eat;i++){
            Person p = pq.poll();
            ans = p.id;
            p.next+=p.period;
            pq.add(p);
        }

        System.out.println(ans);
    }
}
