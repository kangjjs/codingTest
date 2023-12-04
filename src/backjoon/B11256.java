package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B11256 {

    static public class Box implements Comparable<Box> {
        int r, c;

        public Box(int r, int c) {
            this.r = r;
            this.c = c;
        }


        @Override
        public int compareTo(Box o) {
            return (o.c * o.r) - (this.c * this.r);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int J = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            ArrayList<Box> boxes = new ArrayList<>();

            for (int j = 0; j < N; j++) {
                StringTokenizer s = new StringTokenizer(br.readLine());
                boxes.add(new Box(Integer.parseInt(s.nextToken()), Integer.parseInt(s.nextToken())));
            }

            Collections.sort(boxes);
            int k = 0;
            int cnt = 0;
            while (J > 0) {
                int x = boxes.get(k).r * boxes.get(k).c;
                J = J - x;
                cnt++;
                k++;
            }

            sb.append(cnt);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
