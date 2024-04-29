package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B18870 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] ori = arr.clone();

        HashMap<Integer,Integer> hm = new HashMap<>();
        Arrays.sort(arr);
        int count = 0;
        for(int i = 0;i<n;i++){
            if(!hm.containsKey(arr[i]))
                hm.put(arr[i],count++);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(hm.get(ori[i])).append(" ");
        }

        System.out.println(sb);
    }
}
