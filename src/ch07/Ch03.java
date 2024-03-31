package ch07;

import java.util.LinkedList;
import java.util.Queue;

class Ch03 {
    public int solution(int s, int e) {
        int[][] ch = new int[2][200001];
        Queue<Integer> q = new LinkedList<>();
        ch[0][s] = 1;
        q.offer(s);
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();
            L++;
            for(int i=0; i<len;i++){
                int x = q.poll();
                for(int nx:new int[]{x-1,x+1,x*2}){
                    if(nx>=0&&nx<=200000&&ch[L%2][nx]==0){
                        ch[L%2][nx]=1;
                        q.offer(nx);
                    }
                }
            }
            e = e + L;
            if(e>200000)
                return -1;
            if(ch[L%2][e]==1){
                return L;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Ch03 T = new Ch03();
        System.out.println(T.solution(1, 11));
        System.out.println(T.solution(10, 3));
        System.out.println(T.solution(1, 34567));
        System.out.println(T.solution(5, 6));
        System.out.println(T.solution(2, 54321));
    }
}
