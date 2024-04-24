package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B13300 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] rooms = new int[2][7];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            rooms[S][Y]++;
        }

        int answer = 0;
        for (int i = 0; i < 2; i++) {
            for (int j = 1; j < 7; j++) {
                int x = rooms[i][j];
                if(x==0)
                    continue;
                while(x>K){
                    x-=K;
                    answer++;
                }
                answer++;
            }
        }

        System.out.println(answer);
    }
}
