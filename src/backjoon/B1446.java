package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1446 {

    static class HighWay {
        int n, v;

        public HighWay(int n, int v) {
            this.n = n;
            this.v = v;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] distance = new int[m+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        ArrayList<ArrayList<HighWay>> list = new ArrayList<>();

        for (int i = 0; i < m + 1; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            if (end > m)
                continue;
            if (end - start < value)
                continue;
            list.get(end).add(new HighWay(start,value));
        }

        distance[0] = 0;
        for (int i = 1  ; i <= m ; i++) {
            if(!list.get(i).isEmpty()){
                for(HighWay h : list.get(i)){
                    distance[i] = Math.min(Math.min(distance[i-1]+1,distance[h.n]+h.v),distance[i]);
                }
            }else{
                distance[i] = distance[i-1]+1;
            }
        }

        System.out.println(distance[m]);
    }
}
