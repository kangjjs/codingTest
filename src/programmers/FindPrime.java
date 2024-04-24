package programmers;

import java.util.ArrayList;

public class FindPrime {
    static ArrayList<Integer> list;
    static String str;
    static boolean[] visited;
    public int solution(String numbers) {
        int answer = 0;
        list = new ArrayList<>();
        str="";
        visited = new boolean[7];
        for(int i = 0; i < numbers.length();i++){
            dfs(str,numbers,i+1);
        }

        for(int x : list){
            if(isPrime(x))
                answer++;
        }

        return answer;
    }

    static void dfs(String s,String numbers,int L){
        if(s.length()==L){
            int x = Integer.parseInt(s);
            if(!list.contains(x)){
                list.add(x);
            }
        }else{
            for(int i = 0; i < numbers.length();i++){
                if(!visited[i]){
                    visited[i] = true;
                    s += numbers.charAt(i);
                    dfs(s,numbers,L);
                    visited[i] = false;
                    s = s.substring(0,s.length()-1);
                }
            }
        }
    }

    static boolean isPrime(int n) {
        if(n<2) return false;

        for(int i=2; i*i<=n; i++) {
            if(n % i == 0) return false;
        }

        return true;
    }
}
