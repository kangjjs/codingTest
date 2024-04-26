package programmers;

import java.util.*;

class TwoPower {
    private static int answer;
    private static boolean[] visit;
    private static List<List<Integer>> list;

    public int solution(int n, int[][] wires) {
        answer = Integer.MAX_VALUE;
        for(int i= 0;i<wires.length;i++){
            bfs(i,n,wires);
        }

        return answer;
    }

    public static void bfs(int idx, int n, int[][] wires){
        list = new ArrayList<>();
        for(int i = 0; i<=n; i++){
            list.add(new ArrayList<>());
        }

        for(int i=0;i<wires.length;i++){
            if(i==idx)
                continue;
            list.get(wires[i][0]).add(wires[i][1]);
            list.get(wires[i][1]).add(wires[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(1);

        visit = new boolean[n+1];
        visit[1] = true;

        while(!q.isEmpty()){
            int cur = q.poll();

            for(int x : list.get(cur)){
                if(!visit[x]){
                    visit[x] = true;
                    q.offer(x);
                }
            }
        }

        int a = 0, b=0;
        for(int i = 1;i<=n;i++){
            if(visit[i])
                a++;
            else
                b++;
        }

        answer = Math.min(answer,Math.abs(a-b));
    }
}