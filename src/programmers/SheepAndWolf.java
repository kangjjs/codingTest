package programmers;

import java.util.*;

public class SheepAndWolf {

    static ArrayList<ArrayList<Integer>> graph;
    static int ans;

    public void dfs(int s,ArrayList<Integer> list,int[] info,int sheep,int wolf){
        if(info[s]==0){
            sheep++;
        }else{
            wolf++;
        }

        if(sheep<=wolf)
            return;
        ans = Math.max(ans,sheep);
        ArrayList<Integer> next = new ArrayList<>(list);
        if(!graph.get(s).isEmpty()){
            next.addAll(graph.get(s));
        }
        next.remove(Integer.valueOf(s));

        for(int n:next){
            dfs(n,next,info,sheep,wolf);
        }
    }

    public int solution(int[] info, int[][] edges) {
        ans = 0;
        graph = new ArrayList<>();
        int len = edges.length;
        for (int i = 0; i <= len; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
        }

        ArrayList<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(0,list,info,0,0);

        return ans;
    }
}
