package section07;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S08 {

    int [] check = new int[10001];

    public int solution(int n,int m){
        int [] dx = {1,5,-1};

        Queue<Integer> queue =new LinkedList<>();

        queue.offer(n);
        check[n]=1;
        int L=0;

        while(!queue.isEmpty()){
            int len=queue.size();
            for(int i=0;i<len;i++){
                int x=queue.poll();
                for(int j=0;j<3;j++) {
                    int nx = x + dx[j];
                    if (nx==m)
                        return L+1;
                    if (nx>=1 && nx<=10000 && check[nx]==0){
                        check[nx]=1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }

        return 0;
    }

    public static void main(String[] args) {
        S08 T = new S08();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int m = kb.nextInt();

        System.out.print(T.solution(n,m));
    }
}
