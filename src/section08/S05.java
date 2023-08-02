package section08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S05 {

    static int n,m,answer=Integer.MAX_VALUE;
    static Integer [] coins;


    public void solution(int l,int s){
        if(s>m)
            return;
        if(l>=answer)
            return;
        if(s==m){
            answer=Math.min(answer,l);
        }else{
            for(int i=0;i<n;i++){
                solution(l+1,s+coins[i]);
            }
        }
    }

    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);

        n=kb.nextInt();

        coins=new Integer[n];

        for(int i=0;i<n;i++){
            coins[i]=kb.nextInt();
        }

        Arrays.sort(coins, Collections.reverseOrder());

        m=kb.nextInt();
        T.solution(0,0);
        System.out.print(answer);
    }
}