package ch04;

import java.util.Arrays;

class Ch06 {
    public int solution(int[] tasks, long k) {
        int n = tasks.length;
        int[] sT = new int[n + 1];
        sT[0] = 0;
        System.arraycopy(tasks, 0, sT, 1, n);
        Arrays.sort(sT);
        long rest = tasks.length;
        for (int i = 1; i < sT.length; i++) {
            long time = rest * (sT[i] - sT[i - 1]);
            if (k < time) {
                long idx = k % rest;
                int cnt = 0;
                for (int j = 0; j < tasks.length; j++) {
                    if(tasks[j]>=sT[i]){
                        if(cnt==idx)
                            return j+1;
                        cnt++;
                    }
                }
            }else{
                k -= time;
                rest--;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Ch06 T = new Ch06();
        System.out.println(T.solution(new int[]{1, 2, 3}, 5));
        System.out.println(T.solution(new int[]{8, 5, 2, 9, 10, 7}, 30));
        System.out.println(T.solution(new int[]{8, 9, 12, 23, 45, 16, 25, 50}, 100));
    }
}

