package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1946 {

    static class Rate implements Comparable<Rate> {
        int x, y;

        public Rate(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Rate o) {
            return this.x-o.x;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        ArrayList<Rate> arrayList;
        StringBuilder sb =new StringBuilder();

        while(T-->0){
            int N = Integer.parseInt(br.readLine());
            arrayList =new ArrayList<>();

            for (int i = 0; i < N; i++) {
                StringTokenizer st =new StringTokenizer(br.readLine());
                arrayList.add(new Rate(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }

            Collections.sort(arrayList);

            int ans =1;
            int y = arrayList.get(0).y;

            for (int i = 1; i < arrayList.size(); i++) {
                if(arrayList.get(i).y<y){
                    ans++;
                    y=arrayList.get(i).y;
                }
            }

            sb.append(ans);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
