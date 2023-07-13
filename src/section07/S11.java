package section07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S11 {

    static int n,m;
    static int [][] graph;
    static int [] check;
    static int [] dis;

    public void solution(int k){
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(k);

        while(!queue.isEmpty()){
            int x=queue.poll();

            for(int i=1;i<=n;i++){
                if(graph[x][i]==1&&check[i]==0){
                    check[i]=1;
                    queue.offer(i);
                    dis[i]=dis[x]+1;
                }
            }

        }
    }

    public static void main(String[] args) {
        S11 T = new S11();
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

        dis= new int[n+1];
        check[1]=1;
        dis[1]=0;

        T.solution(1);

        for(int i=2;i<=n;i++){
            System.out.println(i+" : "+ dis[i]);
        }
    }
}
