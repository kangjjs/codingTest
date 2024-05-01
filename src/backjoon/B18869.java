package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B18869 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n],sort;
        int[][] space = new int[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }

            sort = Arrays.stream(arr)
                    .distinct()
                    .sorted()
                    .toArray();

            for (int j = 0; j < n; j++) {
                space[i][j] = Arrays.binarySearch(sort,arr[j]);
            }
        }

        int ans = 0;

        for (int i = 0; i < m; i++) {
            for (int j = i+1; j < m; j++) {
                if(Arrays.equals(space[i],space[j]))
                    ans++;
            }
        }

        System.out.println(ans);
    }
}
