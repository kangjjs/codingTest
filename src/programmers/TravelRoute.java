package programmers;

import java.util.ArrayList;
import java.util.Collections;

public class TravelRoute {
    static ArrayList<String> list;
    static boolean[] visited;

    static void dfs(int L,String start,String end,String[][] tickets){
        if(L==tickets.length){
            list.add(end);
        }else{
            for(int i = 0;i<tickets.length;i++){
                if(!visited[i]){
                    if(start.equals(tickets[i][0])){
                        visited[i] = true;
                        dfs(L+1,tickets[i][1],end+" "+tickets[i][1],tickets);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public String[] solution(String[][] tickets) {
        list = new ArrayList<>();
        visited = new boolean[tickets.length];

        dfs(0,"ICN","ICN",tickets);
        Collections.sort(list);

        return list.get(0).split(" ");
    }
}
