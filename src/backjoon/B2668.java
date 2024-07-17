package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class B2668 {

    static int n;
    static int[] arr;
    static boolean[] visited;
    static ArrayList<Integer> list;

    static void dfs(int s,int x){
        if(!visited[arr[s]]){
            visited[arr[s]] = true;
            dfs(arr[s],x);
            visited[arr[s]] = false;
        }

        if(arr[s]==x){
            list.add(x);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        list = new ArrayList<>();
        visited = new boolean[n+1];

        for (int i = 1; i <=n ; i++) {
            visited[i] = true;
            dfs(i,i);
            visited[i]=false;
        }

        Collections.sort(list);
        System.out.println(list.size());
        for(int x:list){
            System.out.println(x);
        }
    }
}