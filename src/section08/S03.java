package section08;

import java.util.*;

class S03 {

    static int[] s,t;
    static int n, m;
    static int answer=0;

    public void solution(int l, int scoreSum,int timeSum,  int[] score,int [] time) {
        if(timeSum>m)
            return;
        if(l==n){
            answer=Math.max(scoreSum,answer);
        }else{
            solution(l+1,scoreSum+score[l],timeSum+time[l],score,time);
            solution(l+1,scoreSum,timeSum,score,time);
        }
    }


    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        n = kb.nextInt();
        m = kb.nextInt();
        s = new int[n];
        t = new int[n];

        for (int i = 0; i < n; i++) {
            s[i] = kb.nextInt();
            t[i] = kb.nextInt();
        }

        T.solution(0,0,0,s,t);
        System.out.print(answer);
    }
}

