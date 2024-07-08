package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14719 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int[] height = new int[w];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < w; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;

        for (int i = 1; i < w - 1; i++) {
            int lt = 0;
            int rt = 0;
            for (int j = 0; j < i; j++) {
                lt = Math.max(height[j],lt);
            }

            for (int j = i+1; j < w ; j++) {
                rt = Math.max(height[j],rt);
            }

            if(height[i]<lt&&height[i]<rt){
                ans += Math.min(lt,rt) - height[i];
            }
        }

        System.out.println(ans);
    }
}
