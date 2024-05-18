package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class MiddleAverage {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            ArrayList<Integer> list = new ArrayList<>();
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }

            Collections.sort(list);
            double sum = 0;
            for (int i = 1; i < list.size()-1; i++) {
                sum+=list.get(i);
            }
            long avg = Math.round(sum/(list.size()-2));

            sb.append(avg).append('\n');
        }
        System.out.print(sb);
    }
}
