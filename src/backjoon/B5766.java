package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B5766 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (n == 0 && m == 0)
                break;

            HashMap<Integer, Integer> hm = new HashMap<>();

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < m; j++) {
                    int num = Integer.parseInt(st.nextToken());
                    hm.put(num, hm.getOrDefault(num, 0) + 1);
                }
            }

            ArrayList<Integer> list = new ArrayList<>();
            ArrayList<Integer> cnt = new ArrayList<>();
            for (int x : hm.values()) {
                if (!cnt.contains(x))
                    cnt.add(x);
            }

            Collections.sort(cnt);
            int second = cnt.get(cnt.size() - 2);

            for(int key:hm.keySet()){
                if(hm.get(key)==second){
                    list.add(key);
                }
            }

            Collections.sort(list);
            for(int x:list){
                sb.append(x).append(" ");
            }

            sb.append('\n');
        }


        System.out.print(sb);
    }
}