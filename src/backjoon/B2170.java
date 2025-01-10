package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class B2170 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }
        list.sort(Comparator.comparingInt(a -> a[0]));
        int ans = 0;
        int start = list.get(0)[0];
        int end = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            int curStart = list.get(i)[0];
            int curEnd = list.get(i)[1];

            if(curStart> end){
                ans += end - start;
                start = curStart;
                end = curEnd;
            }else{
                end = Math.max(end,curEnd);
            }
        }

        ans += end- start;

        System.out.println(ans);
    }
}
