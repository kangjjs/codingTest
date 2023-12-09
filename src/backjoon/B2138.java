package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B2138 {

    static int change(int n, int[] a, int[] b) {
        int cnt = 0;

        for (int i = 0; i < n - 1; i++) {
            if (a[i] != b[i]) {
                cnt++;
                a[i] = 1 - a[i];
                a[i + 1] = 1 - a[i + 1];
                if (i != n - 2)
                    a[i + 2] = 1 - a[i + 2];
            }
        }

        if(Arrays.equals(a,b))
            return cnt;
        else
            return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        String str1 = br.readLine();
        for (int i = 0; i < N; i++) {
            arr1[i] = str1.charAt(i) - '0';
        }

        String str2 = br.readLine();
        for (int i = 0; i < N; i++) {
            arr2[i] = str2.charAt(i) - '0';
        }

        int[] arr3 = Arrays.copyOf(arr1, N);
        arr3[0] = 1 - arr3[0];
        arr3[1] = 1 - arr3[1];

        int answer = change(N,arr1,arr2);
        int answer2 = change(N,arr3,arr2);

        if(answer2!=-1)
            answer2++;

        if(answer==-1)
            System.out.println(answer2);
        else if(answer2==-1)
            System.out.println(answer);
        else
            System.out.println(Math.min(answer,answer2));
    }
}
