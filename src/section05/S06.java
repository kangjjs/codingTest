package section05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Main {

    public int solution(int n,int m) {
        Queue<Integer> queue =new LinkedList<>();

        for(int i=1;i<=n;i++){
            queue.add(i);
        }

        int cnt=0;

        while(queue.size()!=1){
            cnt++;
            Integer t = queue.poll();

            if(cnt%m==0)
                continue;
            queue.offer(t);
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();

        System.out.print(T.solution(n,m));
    }
}