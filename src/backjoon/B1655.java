package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size())
                maxHeap.add(x);
            else
                minHeap.add(x);
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int tmp = maxHeap.poll();
                    maxHeap.offer(minHeap.poll());
                    minHeap.offer(tmp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb);
    }
}
