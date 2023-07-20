package section08;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class S05 {

    static int n,m,answer=Integer.MAX_VALUE;
    static Integer [] coin;

    public void solution(int k,int s){
        if(k>=answer)
            return;
        if(s>m)
            return;
        if(s==m){
            answer=Math.min(k,answer);
        }else{
            for(int i=0;i<n;i++){
                solution(k+1,s+coin[i]);
            }
        }
    }

    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        coin = new Integer[n];
        for(int i=0;i<n;i++){
            coin[i]=kb.nextInt();
        }

        Arrays.sort(coin, Collections.reverseOrder());
        m=kb.nextInt();

        T.solution(0,0);
        System.out.print(answer);
    }
}
