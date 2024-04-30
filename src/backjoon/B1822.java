package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B1822 {



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nA = Integer.parseInt(st.nextToken());
        int nB = Integer.parseInt(st.nextToken());
        TreeSet<Integer> set = new TreeSet<>();
        ArrayList<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < nA; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nB; i++) {
            int x = Integer.parseInt(st.nextToken());
            set.remove(x);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(set.size()).append('\n');
        for(int x: set){
            sb.append(x).append(" ");
        }

        System.out.println(sb);
    }
}
