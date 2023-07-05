package section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class S06 {

    public int solution(int n,int m){
        int answer=0;
        Queue<Integer> queue =new LinkedList<>();

        for(int i=0;i<n;i++){
            queue.offer(i+1);
        }

        while(!queue.isEmpty()){
            for(int i=1;i<m;i++)
                queue.offer(queue.poll());
            queue.poll();
            if(queue.size()==1)
                answer=queue.poll();
        }

        return answer;
    }

    public static void main(String[] args) {
        S06 T = new S06();
        Scanner kb = new Scanner(System.in);
        int n=kb.nextInt();
        int m=kb.nextInt();

        System.out.print(T.solution(n,m));
    }
}