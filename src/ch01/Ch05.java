package ch01;

import java.util.*;
public class Ch05 {
    public int solution(int[] nums){
        int answer = 0;

        ArrayList<Integer> peaks =new ArrayList<>();
        int n=nums.length;

        for(int i=1;i<n-1;i++){
            if(nums[i-1]<nums[i]&&nums[i]>nums[i+1])
                peaks.add(i);
        }

        for(int x:peaks){
            int count=1;
            int left=x;
            int right=x;

            while(left-1>=0&&nums[left]>nums[left-1]){
                left--;
                count++;
            }

            while(right+1<n&&nums[right]>nums[right+1]){
                right++;
                count++;
            }

            answer=Math.max(answer,count);
        }

        return answer;
    }

    public static void main(String[] args){
        Ch05 T = new Ch05();
        System.out.println(T.solution(new int[]{1, 2, 1, 2, 3, 2, 1}));
        System.out.println(T.solution(new int[]{1, 1, 2, 3, 5, 7, 4, 3, 1, 2}));
        System.out.println(T.solution(new int[]{3, 2, 1, 3, 2, 4, 6, 7, 3, 1}));
        System.out.println(T.solution(new int[]{1, 3, 1, 2, 1, 5, 3, 2, 1, 1}));
    }
}