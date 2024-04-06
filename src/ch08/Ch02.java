package ch08;

import java.util.*;

class Ch02 {
    public int solution(int[][] routes, int s, int e) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        int n = routes.length;

        for (int i = 0; i < n; i++) {
            for(int x:routes[i]){
                hm.putIfAbsent(x,new HashSet<>());
                hm.get(x).add(i);
            }
        }

        int[] ch =new int[n];
        Queue<Integer> q =new LinkedList<>();
        q.offer(s);
        int L =0;

        while(!q.isEmpty()){
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int cur = q.poll();

                for(int line : hm.get(cur)){
                    if(ch[line]==1)
                        continue;
                    ch[line]=1;
                    for(int stop : routes[line]){
                        if(stop == e)
                            return L;
                        q.offer(stop);
                    }
                }
            }

            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Ch02 T = new Ch02();
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5, 6, 19}, {2, 7, 8, 13}, {5, 9, 10}, {9, 11, 12, 18}, {13, 14, 15}, {14, 12, 16, 17}}, 1, 12));
        System.out.println(T.solution(new int[][]{{1, 3, 5, 7}, {9, 3, 12}, {6, 5, 8}, {2, 8, 14, 15}, {2, 14, 16}}, 1, 14));
        System.out.println(T.solution(new int[][]{{7, 12}, {5, 19}, {7, 19}, {9, 12, 13}, {9, 5, 15}}, 9, 19));
        System.out.println(T.solution(new int[][]{{1, 2, 3, 4, 5}, {9, 7, 10}, {7, 6, 3, 8}, {5, 11, 8, 12}}, 1, 10));
    }
}
