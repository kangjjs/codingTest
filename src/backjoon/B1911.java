package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B1911 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new int[]{start,end});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int board = 0;
        for(int[] cur:list){
            int start = cur[0];
            int end = cur[1];

            if(board < start)
                board = start;

            while(board<end){
                board+=l;
                ans++;
            }
        }

        System.out.println(ans);
    }
}
