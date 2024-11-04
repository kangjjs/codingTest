package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B14658 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list.add(new int[]{x, y});
        }

        int max = 0;

        for(int[] star1 : list){
            for(int[] star2:list){
                int sx = star1[0];
                int sy = star2[1];
                int cnt = 0;
                for(int[] star : list){
                    if(star[0]>=sx&&star[0]<=sx+l&&star[1]>=sy&&star[1]<=sy+l)
                        cnt++;
                }

                max = Math.max(cnt,max);
            }
        }

        System.out.println(k-max);
    }
}
