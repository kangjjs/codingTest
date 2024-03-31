package ch07;

import java.util.LinkedList;
import java.util.Queue;

class Ch01 {


    public int solution(int[] nums) {
        int n = nums.length;
        int[] ch = new int[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        ch[0] = 1;
        int L = 0;

        while (!q.isEmpty()) {
            int len = q.size();

            for (int i = 0; i < len; i++) {
                int x = q.poll();
                for (int j = 1; j <= nums[x]; j++) {
                    int nx = x + j;
                    if(nx==n-1)
                        return L+1;
                    if(nx<n&&ch[nx]==0){
                        ch[nx]=1;
                        q.offer(nx);
                    }
                }
            }
            L++;
        }

        return -1;
    }

    public static void main(String[] args) {
        Ch01 T = new Ch01();
        System.out.println(T.solution(new int[]{2, 2, 1, 2, 1, 1}));
        System.out.println(T.solution(new int[]{1, 0, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{2, 3, 1, 0, 1, 1, 2, 3, 1, 5, 1, 3, 1}));
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 1, 2, 1, 1, 3, 1, 2, 1}));
        System.out.println(T.solution(new int[]{1, 3, 2, 1, 1, 2, 3, 1, 3, 1, 2, 3, 5, 1, 5, 1, 2, 1, 1}));
    }
}
