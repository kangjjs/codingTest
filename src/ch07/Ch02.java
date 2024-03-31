package ch07;

import java.util.*;

class Ch02 {
    public int solution(int[] pool, int a, int b, int home) {
        int answer = 0;
        int[][] ch = new int[2][10001];
        for (int x:pool) {
            ch[0][x]=1;
            ch[1][x]=1;
        }
        
        Queue<int[]> q = new LinkedList<>();
        ch[0][0] = 1;
        ch[1][0] = 1;
        q.offer(new int[]{0,0});

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int [] cur = q.poll();

                if(cur[0]==home)
                    return answer;
                int nx = cur[0]+a;
                if(nx<=10001 && ch[0][nx] == 0){
                    ch[0][nx] = 1;
                    q.offer(new int[]{nx,0});
                }

                nx = cur[0]-b;
                if(nx>=0 && ch[1][nx] == 0 && cur[1] == 0){
                    ch[1][nx] = 1;
                    q.offer(new int[]{nx,1});
                }
            }
            answer++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Ch02 T = new Ch02();
        System.out.println(T.solution(new int[]{11, 7, 20}, 3, 2, 10));
        System.out.println(T.solution(new int[]{1, 15, 11}, 3, 2, 5));
        System.out.println(T.solution(new int[]{9, 15, 35, 30, 20}, 2, 1, 25));
        System.out.println(T.solution(new int[]{5, 12, 7, 19, 23}, 3, 5, 18));
        System.out.println(T.solution(new int[]{10, 15, 20}, 3, 2, 2));
    }
}
