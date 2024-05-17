package samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Bread {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            sb.append("#").append(cnt++).append(" ");
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] arr = new int[n];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                arr[i] = x;
            }

            Arrays.sort(arr);

            int b = 0;

            int time;
            boolean flag = true;
            boolean[] check = new boolean[22224];
            if(arr[0]==0){
                sb.append("Impossible").append('\n');
                continue;
            }

            for (int i = 0; i < n; i++) {
                time = arr[i];
                if (time < m) {
                    flag = false;
                    break;
                } else {
                    int x = time / m;
                    for (int j = 1; j <= x; j++) {
                        if (!check[m*j]) {
                            check[m*j] = true;
                            b += k;
                        }
                    }
                }

                if (b == 0) {
                    flag = false;
                    break;
                } else {
                    b--;
                }
            }

            if (!flag)
                sb.append("Impossible").append('\n');
            else
                sb.append("Possible").append('\n');
        }

        System.out.print(sb);
    }
}
