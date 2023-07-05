package section06;

import java.util.Scanner;

public class S04 {

    public int [] solution(int n,int m,int [] arr){
        int [] cache =new int[n];

        for(int x:arr){
            int pos=-1;
            for(int i=0;i<n;i++) {
                if (x == cache[i])
                    pos = i;
            }

            if(pos==-1){
                for(int i=n-1;i>=1;i--){
                    cache[i]=cache[i-1];
                }
            }else{
                for(int i=pos;i>=1;i--){
                    cache[i]=cache[i-1];
                }
            }

            cache[0]=x;
        }

        return cache;
    }

    public static void main(String[] args) {
        S04 T = new S04();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m=kb.nextInt();
        int[] arr = new int[m];

        for (int i = 0; i < m; i++) {
            arr[i] = kb.nextInt();
        }

        for (int x : T.solution(n, m, arr)) {
            System.out.print(x + " ");
        }
    }
}
