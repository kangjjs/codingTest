package backjoon;

import java.util.*;
import java.io.*;

public class B15650 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int arr[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];

        DFS(1, 0);
        System.out.println(sb);
    } // End of main

    static void DFS(int at, int depth) {

        if (depth == M) {
            for (int val : arr) {
                sb.append(val).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = at; i <= N; i++) {
            arr[depth] = i;
            DFS(i + 1, depth + 1);
        }

        return;
    } // End of DFS

}