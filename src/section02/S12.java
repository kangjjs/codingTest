package section02;

import java.util.Scanner;

public class S12 {

    public int solution(int n,int m, int [][] arr){
        int answer =0;

        for(int i=1;i<=n;i++){
            for (int j=1;j<=n;j++){
                int cnt=0;

                for(int k=0;k<m;k++){
                    int pi=0,pj=0;

                    for(int s=0;s<n;s++){
                        if(arr[k][s]==i)
                            pi=s;
                        if(arr[k][s]==j)
                            pj=s;
                    }

                    if(pi<pj)
                        cnt++;
                }

                if(cnt==m)
                    answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        S12 T = new S12();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        int[][] arr = new int[k][n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = kb.nextInt();
            }
        }

        System.out.print(T.solution(n, k,arr));
    }
}
