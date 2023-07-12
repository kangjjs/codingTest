package section07;

import java.util.Scanner;

public class S10 {

    static int n,m,answer=0;
    static int [] [] graph;
    static int [] check;

    public void solution(int k){
        if(k==n)
            answer++;
        else {
            for(int i=1;i<=n;i++){
                if(check[i]==0&&graph[k][i]==1){
                    check[i]=1;
                    solution(i);
                    check[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        S10 T = new S10();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        m = kb.nextInt();

        graph = new int [n+1][n+1];
        check = new int [n+1];

        for(int i=0;i<m;i++){
            int x=kb.nextInt();
            int y=kb.nextInt();
            graph[x][y]=1;
        }

        check[1]=1;
        T.solution(1);
        System.out.print(answer);
    }
}