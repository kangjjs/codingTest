package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B10816 {

    static int[] arr;
    static HashMap<Integer,Integer> hm;
    static int binarySearch(int x) {
        int lt = 0;
        int rt = arr.length - 1;

        while (lt <= rt) {
            int mid = (lt + rt) / 2;

            if (x > arr[mid]) {
                lt = mid + 1;
            } else if (x < arr[mid]) {
                rt = mid - 1;
            } else {
                return hm.get(x);
            }
        }

        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[n];
        hm = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            arr[i] = x;
            hm.put(x,hm.getOrDefault(x,0)+1);
        }

        int m = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sb.append(binarySearch(Integer.parseInt(st.nextToken()))).append(" ");
        }

        System.out.println(sb);
    }
}
