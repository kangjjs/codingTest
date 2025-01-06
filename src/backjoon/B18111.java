package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B18111 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int minH = Integer.MAX_VALUE;
        int maxH = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, map[i][j]);
                minH = Math.min(minH, map[i][j]);
            }
        }

        int ansTime = Integer.MAX_VALUE;
        int ansHeight = 0;

        for (int i = minH; i <=maxH ; i++) {
            int time = 0;
            int in = k;

            for (int j = 0; j < n; j++) {
                for (int l = 0; l < m; l++) {
                    int curHeight = map[j][l];

                    if(curHeight>i){
                        int remove = curHeight-i;
                        time += remove *2;
                        in +=remove;
                    }else if(curHeight<i){
                        int add = i-curHeight;
                        time += add;
                        in -= add;
                    }
                }
            }

            if(in>=0){
                if(time<ansTime){
                    ansTime = time;
                    ansHeight = i;
                }else if(time==ansTime && i>ansHeight){
                    ansHeight = i;
                }
            }
        }

        System.out.print(ansTime+" "+ansHeight);
    }
}
