package section08;

import java.util.Scanner;

public class S02 {

    static int n,m,sum=0;
    static int [] check;
    static int [] arr;

    public void solution(int k,int s){
        if(s>m)
            return;
        if(k==n){
            sum=Math.max(sum,s);
            return;
        }
        else{
            sum=Math.max(sum,s);
            solution(k+1,s+arr[k]);
            solution(k+1,s);
        }
    }

    public static void main(String[] args){
        S02 T = new S02();
        Scanner kb = new Scanner(System.in);
        m=kb.nextInt();
        n=kb.nextInt();
        check = new int [n+1];
        arr=new int[n];

        for(int i=0;i<n;i++){
            arr[i]=kb.nextInt();
        }

        T.solution(0,0);
        System.out.print(sum);
    }
}
