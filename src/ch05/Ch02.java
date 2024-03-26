package ch05;

import java.util.Arrays;
import java.util.HashMap;

class Ch02 {
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        int lt = 0,rt =nums.length-1;

        while(lt<=rt){
            if(nums[lt]+nums[rt]<=5){
                lt++;
            }
            rt--;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Ch02 T = new Ch02();
        System.out.println(T.solution(new int[]{2, 5, 3, 4, 2, 3}));
        System.out.println(T.solution(new int[]{2, 3, 4, 5}));
        System.out.println(T.solution(new int[]{3, 3, 3, 3, 3}));
    }
}
