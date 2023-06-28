package ch03;

import java.time.LocalTime;
import java.util.*;
class Ch04 {

    public int getTime(String time){
        int h = Integer.parseInt(time.split(":")[0]);
        int m = Integer.parseInt(time.split(":")[1]);

        return h*60+m;
    }

    public int solution(int[] laser, String[] enter){
        int answer = 0;

        int n = enter.length;
        int [][] medical =new int[n][2];

        for(int i=0;i<n;i++){
            int time =getTime(enter[i].split(" ")[0]);
            int order = Integer.parseInt(enter[i].split(" ")[1]);
            medical[i][0]=time;
            medical[i][1]=order;
        }

        Queue<Integer> Q = new LinkedList<>();
        Q.offer(medical[0][1]);
        int ft = medical[0][0];
        int pos=1;

        for(int t =ft; t<=1200;t++){
            if(pos<n&& t==medical[pos][0]){
                if(Q.isEmpty() && t>ft){
                    ft=t;
                }
                Q.offer(medical[pos][1]);
                pos++;
            }

            if(t==ft && !Q.isEmpty()){
                int index = Q.poll();
                ft +=laser[index];
            }

            answer = Math.max(answer,Q.size());
        }

        return answer;
    }

    public static void main(String[] args){
        Ch04 T = new Ch04();
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "11:10 2"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:23 0", "10:40 3", "10:42 2", "10:52 3", "15:10 0", "15:20 3", "15:22 1", "15:23 0", "15:25 0"}));
        System.out.println(T.solution(new int[]{30, 20, 25, 15}, new String[]{"10:20 1", "10:40 1", "11:00 1", "11:20 1", "11:40 1"}));
    }
}
