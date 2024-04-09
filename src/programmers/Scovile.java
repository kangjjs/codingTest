package programmers;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Scovile {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int x : scoville) {
            pq.offer(x);
        }

        while (pq.peek() < K) {
            if (pq.size() > 1) {
                pq.offer(pq.poll() + (pq.poll() * 2));
                answer++;
            }else
                return -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scovile s = new Scovile();
        System.out.println(s.solution(new int[]{1, 2, 3, 9, 10, 12}, 7));
    }
}
