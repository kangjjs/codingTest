package programmers;

import java.util.*;

class FunctionDevelopment {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        int idx = 0;
        for (int x : progresses) {
            q.offer(x);
        }

        int days = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while (!q.isEmpty()) {
            int cnt = 0;
            while (!q.isEmpty() && q.peek() + speeds[idx] * days >= 100) {
                q.poll();
                idx++;
                cnt++;
            }
            if (cnt != 0)
                list.add(cnt);
            days++;
        }
        int[] answer = new int[list.size()];

        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}