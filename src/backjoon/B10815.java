package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10815 {

    static int[] arr;

    static boolean binarySearch(int x) {
        int lt = 0;
        int rt = arr.length - 1;
        int mid;

        while (lt <= rt) {
            mid = (lt + rt) / 2;

            if (x > arr[mid]) {
                lt = mid + 1;
            } else if (x < arr[mid]) {
                rt = mid - 1;
            }else{
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            if(binarySearch(Integer.parseInt(st.nextToken())))
                sb.append("1").append(" ");
            else
                sb.append("0").append(" ");
        }

        System.out.println(sb);
    }
}
