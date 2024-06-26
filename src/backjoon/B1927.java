package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class B1927 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(br.readLine());
            if(x==0){
                if(!queue.isEmpty()){
                    sb.append(queue.poll()).append('\n');
                }else{
                    sb.append("0").append('\n');
                }
            }else{
                queue.offer(x);
            }
        }

        System.out.print(sb);
    }
}
