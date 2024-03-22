package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class BridgeTruck {

    static class Truck {
        int w, t;

        public Truck(int w, int t) {
            this.w = w;
            this.t = t;
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        int sum = 0;
        Queue<Integer> waiting = new LinkedList<>();
        Queue<Truck> on = new LinkedList<>();

        for (int x : truck_weights) {
            waiting.offer(x);
        }

        on.offer(new Truck(waiting.poll(), 0));
        sum += on.peek().w;

        while (!on.isEmpty()) {
            answer++;

            for (Truck t : on) {
                t.t++;
            }

            if (on.peek().t > bridge_length) {
                sum -= on.poll().w;
            }

            if (!waiting.isEmpty() && sum + waiting.peek() <= weight) {
                sum += waiting.peek();
                on.offer(new Truck(waiting.poll(), 1));
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        BridgeTruck t = new BridgeTruck();
        System.out.println(t.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(t.solution(100, 100, new int[]{10}));
    }
}
