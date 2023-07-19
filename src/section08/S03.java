package section08;

import java.util.Scanner;

public class S03 {

    static int n,m,sum=0;
    static int [] score;
    static int [] time;

    public void solution(int k,int t,int s){
        if(t>m)
            return;
        if(k==n) {
            sum=Math.max(sum,s);
        } else{
            solution(k+1,t+time[k],s+score[k]);
            solution(k+1,t,s);
        }
    }

    public static void main(String[] args){
        S03 T = new S03();
        Scanner kb = new Scanner(System.in);
        n=kb.nextInt();
        m=kb.nextInt();
        score=new int[n];
        time=new int[n];
        for(int i=0;i<n;i++){
            score[i]=kb.nextInt();
            time[i]=kb.nextInt();
        }

        T.solution(0,0,0);
        System.out.print(sum);
    }
}
