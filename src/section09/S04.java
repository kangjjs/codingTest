package section09;

import java.util.*;

class Lecture implements Comparable<Lecture> {

    public int m;
    public int d;

    public Lecture(int m, int d) {
        this.m = m;
        this.d = d;
    }

    @Override
    public int compareTo(Lecture o) {
        return o.d - this.d;
    }
}

class S04 {

    static int max = Integer.MIN_VALUE;

    public int solution(int n, ArrayList<Lecture> arrayList) {

        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Collections.sort(arrayList);
        int j = 0;

        for (int i = max; i >= 1; i--) {
            for (; j < n; j++) {
                if (arrayList.get(j).d < i)
                    break;
                pq.offer(arrayList.get(j).m);
            }

            if (!pq.isEmpty())
                answer += pq.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        ArrayList<Lecture> arrayList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int m = kb.nextInt();
            int d = kb.nextInt();
            arrayList.add(new Lecture(m, d));
            if (d > max)
                max = d;
        }

        System.out.print(T.solution(n, arrayList));
    }
}
