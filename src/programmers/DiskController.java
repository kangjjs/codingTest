package programmers;

import java.util.Arrays;
import java.util.PriorityQueue;

class DiskController {
    static class Disk implements Comparable<Disk> {
        public int st, pt;

        public Disk(int st, int pt) {
            this.st = st;
            this.pt = pt;
        }

        @Override
        public int compareTo(Disk d) {
            if (this.pt == d.pt)
                return this.st - d.st;
            return this.pt - d.pt;
        }
    }

    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        int n = jobs.length;
        int time = 0;
        int sum = 0;
        int idx = 0;
        int count = 0;
        while (count < n) {
            while (idx < n && jobs[idx][0] <= time) {
                pq.offer(new Disk(jobs[idx][0], jobs[idx++][1]));
            }

            if (pq.isEmpty()) {
                time = jobs[idx][0];
            } else {
                Disk cur = pq.poll();
                sum += cur.pt + time - cur.st;
                time += cur.pt;
                count++;
            }
        }

        return sum / n;
    }
}