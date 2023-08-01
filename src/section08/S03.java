package section08;

import java.util.Scanner;

public class S03 {

    static int n,m,answer=Integer.MIN_VALUE;

    static int [] time,score;

    public void solution(int l,int t,int s){
        if(t>m)
            return;
        if(l==n){
            answer=Math.max(s,answer);
        }else{
            solution(l+1,t+time[l],s+score[l]);
            solution(l+1,t,s);
        }
    }

    public static void main(String[] args) {
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();
        m=kb.nextInt();

        time = new int[n];
        score = new int[n];

        for(int i=0;i<n;i++){
            score[i]=kb.nextInt();
            time[i]=kb.nextInt();
        }

        T.solution(0,0,0);
        System.out.print(answer);
    }
}
