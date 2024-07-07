package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B12919 {

    static String s,t;
    static int answer =0;

    static void dfs(String t){
        int len = t.length();

        if(len == s.length()){
            if(t.equals(s)){
                answer = 1;
            }

            return;
        }

        if(t.endsWith("A")){
            dfs(t.substring(0,len-1));
        }

        if(t.startsWith("B"))
            dfs(new StringBuilder(t.substring(1)).reverse().toString());
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();

        dfs(t);
        System.out.println(answer);
    }
}
