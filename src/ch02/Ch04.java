package ch02;

import java.util.HashMap;

class Ch04 {
    public int solution(int[] nums, int m){
        int answer = 0;

        int sum=0;
        HashMap<Integer,Integer> hm= new HashMap<>();
        hm.put(0,1);

        for(int x:nums){
            sum+=x;

            if(hm.containsKey(sum-m))
                answer+=hm.get(sum-m);
            hm.put(sum,hm.getOrDefault(sum,0)+1);
        }

        return answer;
    }

    public static void main(String[] args){
        Ch04 T = new Ch04();
        System.out.println(T.solution(new int[]{2, 2, 3, -1, -1, -1, 3, 1, 1}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2, 2, -3}, 5));
        System.out.println(T.solution(new int[]{1, 2, 3, -3, 1, 2}, 3));
        System.out.println(T.solution(new int[]{-1, 0, 1}, 0));
        System.out.println(T.solution(new int[]{-1, -1, -1, 1}, 0));
    }
}
