package ch03;

import java.util.LinkedList;
import java.util.Queue;

class Ch04 {

    public int time(String str) {
        int h = Integer.parseInt(str.split(":")[0]);
        int m = Integer.parseInt(str.split(":")[1]);

        return h * 60 + m;
    }

    public int solution(int[] laser, String[] enter) {
        int answer = 0;
        int n = enter.length;
        int[][] inList = new int[n][2];

        for (int i = 0; i < n; i++) {
            int a = time(enter[i].split(" ")[0]);
            int b = Integer.parseInt(enter[i].split(" ")[1]);
            inList[i][0] = a;
            inList[i][1] = b;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(inList[0][1]);
        int ft = inList[0][0];
        int pos = 1;

        for (int t = ft; t <= 1200; t++) {
            if (pos < n && t == inList[pos][0]) {
                if (queue.isEmpty() && inList[pos][0] > ft)
                    ft = inList[pos][0];
                queue.offer(inList[pos][1]);
                pos++;
            }

            if(t == ft && !queue.isEmpty()){
                int idx = queue.poll();
                ft += laser[idx];
            }

            answer = Math.max(answer,queue.size());
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch04 T = new Ch04();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}