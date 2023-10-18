package section10;

import java.util.Arrays;
import java.util.Scanner;

public class S05 {
    public int solution(int n,int k,int[] coins) {

        int [] dy =new int[k+1];
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0]=0;

        for(int i=0;i<n;i++){
            for(int j=coins[i];j<=k;j++){
                dy[j]=Math.min(dy[j],dy[j-coins[i]]+1);
            }
        }

        return dy[k];
    }


    public static void main(String[] args) {
        S05 T = new S05();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int[] coins = new int[n];
        for(int i=0;i<n;i++){
            coins[i]=kb.nextInt();
        }
        int k = kb.nextInt();

        System.out.print(T.solution(n,k,coins));
    }
}
